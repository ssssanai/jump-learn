package com.ssanai.jumplearn.controller.post;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.service.bbs.BbsServiceInterface;
import com.ssanai.jumplearn.service.post.PostServiceIf;
import com.ssanai.jumplearn.util.BbsPage;
import com.ssanai.jumplearn.util.FilePathConfig;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
@MultipartConfig(
		maxFileSize = 104857600,
		maxRequestSize = 1048576000
)
public class PostController {

	private final PostServiceIf postService;
	private final FilePathConfig filePathConfig;
	private final BbsServiceInterface bbsService;
	// 자유 게시판 컨트롤러
	@GetMapping("/searchListPage")
	public String list(
			HttpServletRequest req,
			@ModelAttribute("pageDTO") PageRequestDTO reqDTO,
			HttpSession session,
			Model model
	) {
//		Object loginInfo = session.getAttribute("loginInfo");
//		if (loginInfo instanceof AdminDTO adto) {
//			log.info("관리자 로그인: {}", adto.toString());
//			model.addAttribute("isAdmin", true);
//			model.addAttribute("adto", adto);
//		} else {
//			model.addAttribute("isAdmin", false);
//		}
		PageResponseDTO<PostDTO> resDTO = postService.searchList(reqDTO);
		int totalCount = postService.postTotalCount(reqDTO);
		StringBuilder URI = new StringBuilder()
				.append(req.getRequestURI())
				.append("?")
				.append(reqDTO.getLinkParamsWithoutNo());
		log.info("URI" + URI);
		String paging = BbsPage.pagingArea(resDTO.getTotal_count(), reqDTO.getPage_no(), reqDTO.getPage_size(), reqDTO.getPage_block_size(), URI.toString());
		model.addAttribute("dtoList", resDTO.getDtoList());
		model.addAttribute("pageInfo", resDTO);
		model.addAttribute("paging", paging);

		return "post/list";
	}

	@GetMapping("/view")
	public String view(
			@RequestParam("id") String id,
			Model model,
			HttpSession session
	) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginInfo");
		model.addAttribute("loginInfo", memberDTO);
		bbsService.viewCount(Integer.parseInt(id), "tbl_post");
		PostDetailDTO dto = postService.selectDetailById(Integer.parseInt(id));
		model.addAttribute("dto", dto);
		List<BbsFileDTO> fileList = postService.selectFileById(Integer.parseInt(id));
		log.info("fileList" + fileList);
		model.addAttribute("fileList", postService.selectFileById(Integer.parseInt(id)));
		List<CommentDTO> commentList = postService.selectCommentById(Integer.parseInt(id));
		model.addAttribute("commentList", commentList);
		// 좋아요 아이콘 처리를 위해 추가
		boolean isLiked = postService.isLiked(Integer.parseInt(id), memberDTO.getId()) > 0;
		model.addAttribute("isLiked", isLiked);
		log.info("commentList" + commentList);
		return "post/viewPage";
	}

	@GetMapping("/write")
	public String write() {
		return "post/write";
	}
	@Transactional
	@PostMapping("/write")
	public String write(
			PostDTO dto,
			RedirectAttributes redirectAttributes,
			@RequestParam(value = "file", required = false) MultipartFile[] file,
			HttpSession session
	) {

		try {
			//1. 회원 ID, 상태 확인 2이면 게시글 작성 못함
			//2. 모든 파일을 서버에 먼저 저장
			//2-1. 실패한 경우 저장한 파일 삭제
			//3.게시글 DB 저장
			//4.파일정보 DB 저장
			//----------------------------------------------
			//1번 완료
			MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginInfo");
			if (memberDTO == null || memberDTO.getStatus() == 2) {
				redirectAttributes.addFlashAttribute("msg", "게시물 생성 권한이 없습니다.");
				return "redirect:/post/write";
			}
			//dto에 아이디 저장
			dto.setMember_id(memberDTO.getId());

			String uploadDir = filePathConfig.getUploadPath();
			List<BbsFileDTO> savedFiles = new ArrayList<>();
			List<Integer> f_id = new ArrayList<>();
			if (file != null && file.length > 0) {
				int count = 1;

				for (MultipartFile f : file) {
					if (!f.isEmpty()) {
						try {
							log.info("파일저장 루틴 시작");
							String newName = f.getOriginalFilename();
							File target = new File(uploadDir, newName);
							f.transferTo(target); //서버 저장
							//리스트 DTO에 보관
							BbsFileDTO fileDTO = new BbsFileDTO();
							fileDTO.setFilePath("/upload");
							fileDTO.setFileName(newName);
							fileDTO.setFileExt(
									f.getOriginalFilename()
											.substring(f.getOriginalFilename()
													.lastIndexOf("."))
							);
							fileDTO.setRelatedId(count);
							count++;
							fileDTO.setFileSize(f.getSize());
							//파일 DB저장
							int i= postService.insertFile(fileDTO);
							if (i< 1) {
								redirectAttributes.addFlashAttribute("msg", "파일 정보 DB 저장 실패");
								return "redirect:/post/write";
							}
							savedFiles.add(fileDTO);
							f_id.add(i);
							log.info("fileDTO저장 성공" + fileDTO) ;
						} catch (Exception e) {
							//실패한 경우 지금까지 저장 파일 삭제
							for (BbsFileDTO saved : savedFiles) {
								new File(uploadDir, saved.getFileName()).delete();
							}
							redirectAttributes.addFlashAttribute("msg", "파일 저장 실패: ");
							return "redirect:/post/write";
						}
					}
				}
			}
			//게시글 DB 저장
			int p_id = postService.insertPost(dto);
			if(p_id < 1){
				// 게시글 저장 실패  저장된 파일들 삭제
				for (BbsFileDTO saved : savedFiles) {
					new File(uploadDir, saved.getFileName()).delete();
				}
				redirectAttributes.addFlashAttribute("msg", "게시글 저장 실패");
				return "redirect:/post/write";
			}
			log.info("파일 아이디 :"+ f_id.toString());
			log.info("게시글 아이디 : "+ p_id);

			for(int i : f_id){
				int rs = postService.bridgeFile(i,p_id);
				if(rs < 1){
					log.error("파일과 게시글 연결 실패, 게시글 ID: " + p_id + ", 파일 ID: " + i);
					return "redirect:/post/write";
				}
			}
			log.info("게시글 저장 성공");

			redirectAttributes.addFlashAttribute("msg", "게시글 등록 성공");
			return "redirect:/post/searchListPage";

		} catch (Exception e) {
			log.error("write >> error : {}", e.getMessage(), e);
			redirectAttributes.addFlashAttribute("msg", "서버 오류: " + e.getMessage());
			return "redirect:/post/write";
		}
	}
	@GetMapping("/deletePost")
	public String deletePost(
			@RequestParam("id")String id,
			RedirectAttributes redirectAttributes
	){
		int rs = postService.deletePost(Integer.parseInt(id));
		if(rs < 1){
			redirectAttributes.addFlashAttribute("msg","삭제 실패");
		}else {
			redirectAttributes.addFlashAttribute("msg", "삭제 성공");
		}
		return "redirect:/post/searchListPage";
	}
	@GetMapping("/updatePost")
	public String updatePost(
			@RequestParam("id") String id,
			Model model
	){
		PostDetailDTO dto = postService.selectDetailById(Integer.parseInt(id));
		model.addAttribute("dto", dto);
		return "post/updatePost";
	}
	@PostMapping("/updatePost")
	public String updatePost(
			PostDTO dto,
			RedirectAttributes redirectAttributes
	) {
		log.info(dto.toString());
		int rs = postService.updatePost(dto);
		if(rs < 1){
			redirectAttributes.addFlashAttribute("msg","수정 실패");
			return "redirect:/post/updatePost?id="+dto.getId();
		}else{
			redirectAttributes.addFlashAttribute("msg","수정 성공");
		}
		return "redirect:/post/view?id="+dto.getId();
	}
	@GetMapping("/updateFile")
	public String updateFile(
			@RequestParam("id") String id,
			Model model
	){
		List<BbsFileDTO> fileList = postService.selectFileById(Integer.parseInt(id));
		log.info("fileList" + fileList);
		int fileCount = (fileList != null) ? fileList.size() : 0;
		model.addAttribute("fileCount", fileCount);
		model.addAttribute("id",id);
		model.addAttribute("fileList", postService.selectFileById(Integer.parseInt(id)));
		return "post/updateFile";
	}
	@PostMapping("/updateFile")
	public String updateFile(
			@RequestParam("id")String id,
			RedirectAttributes redirectAttributes,
			@RequestParam(value = "file", required = false) MultipartFile[] file,
			@RequestHeader(value = "Referer", required = false) String referer
	){
		String uploadDir = filePathConfig.getUploadPath();
		List<BbsFileDTO> savedFiles = new ArrayList<>();
		List<Integer> f_id = new ArrayList<>();
		if (file != null && file.length > 0) {
			int count = 1;

			for (MultipartFile f : file) {
				if (!f.isEmpty()) {
					try {
						log.info("파일저장 루틴 시작");
						String newName = f.getOriginalFilename();
						File target = new File(uploadDir, newName);
						f.transferTo(target); //서버 저장
						//리스트 DTO에 보관
						BbsFileDTO fileDTO = new BbsFileDTO();
						fileDTO.setFilePath("/upload");
						fileDTO.setFileName(newName);
						fileDTO.setFileExt(
								f.getOriginalFilename()
										.substring(f.getOriginalFilename()
												.lastIndexOf("."))
						);
						fileDTO.setRelatedId(count);
						count++;
						fileDTO.setFileSize(f.getSize());
						//파일 DB저장
						int i= postService.insertFile(fileDTO);
						if (i< 1) {
							redirectAttributes.addFlashAttribute("msg", "파일 정보 DB 저장 실패");
							return "redirect:" + referer;
						}
						savedFiles.add(fileDTO);
						f_id.add(i);
						log.info("fileDTO저장 성공" + fileDTO) ;
					} catch (Exception e) {
						//실패한 경우 지금까지 저장 파일 삭제
						for (BbsFileDTO saved : savedFiles) {
							new File(uploadDir, saved.getFileName()).delete();
						}
						redirectAttributes.addFlashAttribute("msg", "파일 저장 실패: ");
						return "redirect:" + referer;
					}
				}
			}
		}
		log.info("파일 아이디 :"+ f_id.toString());
		log.info("게시글 아이디 : "+ id);

		for(int i : f_id){
			int rs = postService.bridgeFile(i, Integer.parseInt(id));
			if(rs < 1) {
				log.error("파일과 게시글 연결 실패, 게시글 ID: " + id + ", 파일 ID: " + i);
				return "redirect:/post/write";
			}
		}
		redirectAttributes.addFlashAttribute("msg","게시글 수정 성공");
		return "redirect:/post/view?id="+id;
	}
	@PostMapping("/deleteFile")
	public String deleteFile(
			@RequestParam("file_id") String file_id,
			@RequestParam("id")String id,
			RedirectAttributes redirectAttributes,
			@RequestHeader(value = "Referer", required = false) String referer
	){
		log.info("id"+id);
		int rs = postService.deleteFile(Integer.parseInt(file_id));
		if(rs < 1){
			redirectAttributes.addFlashAttribute("msg","파일삭제 실패");
		}
		return "redirect:" + referer;
	}
	@PostMapping("/insertComment")
	public String insertComment(
			CommentDTO commentDTO,
			RedirectAttributes redirectAttributes,
			@RequestHeader(value = "Referer", required = false) String referer
	) {
		log.info("댓글 입력"+commentDTO.toString());
		int rs = postService.insertComment(commentDTO);
		if(rs < 1){
			redirectAttributes.addAttribute("msg","답글 실패");
		}
		if (referer != null) {
			return "redirect:" + referer;
		} else {
			return "redirect:/post/searchListPage";
		}
	}
	@GetMapping("/deleteComment")
	public String deleteComment(
			@RequestHeader(value = "Referer", required = false) String referer,
			@RequestParam("id") String id,
			RedirectAttributes redirectAttributes
	) {
		int rs = postService.deleteComment(Integer.parseInt(id));
		if(rs < 1){
			redirectAttributes.addFlashAttribute("msg","삭제 실패");
		}else {
			redirectAttributes.addFlashAttribute("msg", "삭제 성공");
		}
		if (referer != null) {
			return "redirect:" + referer;
		} else {
			return "redirect:/post/searchListPage";
		}
	}
	@GetMapping("/updateComment")
	public String updateComment(
			@RequestParam("comment_id")String id,
			Model model
	){
		model.addAttribute("id", id);
		return "post/comment_update_popup";
	}
	@PostMapping("/updateComment")
	public String updateComment(
			CommentDTO dto,
			RedirectAttributes redirectAttributes
	){
		int rs = postService.updateComment(dto);
		if(rs < 1){
			redirectAttributes.addFlashAttribute("msg","수정 실패");
		}else {
			redirectAttributes.addFlashAttribute("msg", "수정 성공");
		}
		return "redirect:/post/updateComment?comment_id="+dto.getComment_id();
	}

	@GetMapping("/like/{member_id}/{post_id}")
	public String likePost(
		@PathVariable("member_id") String member_id,
		@PathVariable("post_id") int post_id,
		RedirectAttributes ra
	){
		int id = postService.isLiked(post_id, member_id);
		int result = 0;
		if(id > 0) {
			result = postService.cancelLike(id);
		} else {
			result = postService.insertLike(post_id, member_id);
		}

		if(result < 1) {
			log.info("좋아요 컨트롤 실패");
			ra.addFlashAttribute("msg", "처리 중 오류가 발생했습니다.");
		} else {
			log.info("좋아요 컨트롤 성공");
		}

		return "redirect:/post/view?id="+post_id;
	}
}
