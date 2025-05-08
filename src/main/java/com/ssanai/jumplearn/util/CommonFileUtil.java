package com.ssanai.jumplearn.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonFileUtil {

	// 파일명/확장자 리턴
	public String getFileInfo(String sType, String fileName) {
		String rtnResult = "";
		switch(sType) {
		case "FILE_NAME" :
			rtnResult = fileName.substring(0, fileName.lastIndexOf("."));
			break;
		case "FILE_EXT" : 
			rtnResult = fileName.substring(fileName.lastIndexOf(".")+1);
			break;
		case "FILE_SIZE" :
			break;
		default :
		}

		return rtnResult; 
	}
	
	// 파일명 변경
	public String fileRename(String sDir, String fileName) {
		//원본 파일 -> 확장자 추출
		String fileExt = fileName.substring(fileName.lastIndexOf("."));
		
		// 날짜+시간 을 이용한 임시 파일명 생성
		String now = new SimpleDateFormat("yyyyMMdd_HHmmssS").format(new Date());
		
		// 임시파일명+확장자 -> 새로운 파일명 생성
		String newFileName = now + fileExt;
		
		// 기존 파일명 --> 새로운 파일명으로 변경
		File oldFile = new File(sDir + File.separator + fileName);
		File newFile = new File(sDir + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		// 새로운 파일명으로 반환
		return newFileName; 
	}
	
	// 파일 사이즈
	public Long getFileSize(String sDir, String fileName) {
		File file = new File(sDir + File.separator + fileName);
		return (file !=null ? file.length() : 0);
	}
	
	// 파일 업로드
	public String fileUpload(HttpServletRequest req, String sDir) 
			throws ServletException, IOException {
		// Part 객체를 이용하여 서버로 전송된 파일 정보 처리
		Part part = req.getPart("file1");

		// Part 객체의 헤더값 참조 -> content-disposition 조회
		String pHeader = part.getHeader("content-disposition");
		// --> form-data; name="attatchFile"; filename="파일명.xxx"
		System.out.println("partHeader : "+ pHeader);
		
		// 헤더에서 추출한 파일명 처리
		String[] pArrHeader = pHeader.split("filename=");
		String orgFileName = pArrHeader[1].trim().replace("\"", "");
		
		if ( !orgFileName.isEmpty() ) {
			part.write(sDir + File.separator + orgFileName);
		}
		return orgFileName;
	}

	// 파일 업로드
	public Map<String, String> fileUpload(HttpServletRequest req, String sDir, String reqFile, String renameFlag) 
			throws ServletException, IOException {
		// Part 객체를 이용하여 서버로 전송된 파일 정보 처리
		Part part = req.getPart(reqFile);

		// Part 객체의 헤더값 참조 -> content-disposition 조회
		String pHeader = part.getHeader("content-disposition");
		// --> form-data; name="attatchFile"; filename="파일명.xxx"
		System.out.println("partHeader : "+ pHeader);
		
		// 헤더에서 추출한 파일명 처리
		String[] pArrHeader = pHeader.split("filename=");
		String orgFileName = pArrHeader[1].trim().replace("\"", "");

		String mimeType = (part != null ? part.getContentType() : "");
		String fileName = "";
		String fileExt = "";
		System.out.println("part.getContentType() : "+ mimeType);
		
		String fileSize = (part!=null ? String.valueOf(part.getSize()) : "0");
		String newFileName = "";

		if ( !orgFileName.isEmpty() ) {
			if ( renameFlag.equals("Y") ) {
				//원본 파일 -> 확장자 추출
				if ( orgFileName.lastIndexOf(".") >= 0 ) {
					fileExt = orgFileName.substring(orgFileName.lastIndexOf(".")+1);
				}
				
				// 날짜+시간 을 이용한 임시 파일명 생성
				String now = new SimpleDateFormat("yyyyMMdd_HHmmssS").format(new Date());
				
				// 임시파일명+확장자 -> 새로운 파일명 생성
				newFileName = now + (!fileExt.isEmpty() ? "."+ fileExt : "");
				orgFileName = newFileName;
			}
			
			part.write(sDir + File.separator + orgFileName);
		}

		Map<String, String> info = new HashMap<>();
		info.put("mimeType", mimeType);
		info.put("fileName", orgFileName);
		info.put("fileExt", fileExt);
		info.put("fileSize", fileSize);
		return info;
	}

	// 파일 삭제
	public void fileDelete(HttpServletRequest req, String sDir, String fileName) {
		//String Dir = req.getServletContext().getRealPath(sDir);
		String Dir = sDir;
		File file = new File(Dir + File.separator + fileName);
		if ( file.exists() ) {
			file.delete();
		}
	}
	
	//multiple 파일 업로드
	public List<String> multiFileUpload(HttpServletRequest req, String sDir) 
			throws ServletException, IOException {
		// 파일명 저장용 컬렉션
		List<String> arrFileName = new ArrayList<>();
		
		//Part 객체를 컬렉션에 담아서 사용
		Collection<Part> parts = req.getParts(); 
		for(Part part : parts) {
			if ( !part.getName().equals("files") )
				continue;

			// Part 객체의 헤더값 참조 -> content-disposition 조회
			String pHeader = part.getHeader("content-disposition");
			// --> form-data; name="attatchFile"; filename="파일명.xxx"
			System.out.println("partHeader : "+ pHeader);
			
			// 헤더에서 추출한 파일명 처리
			String[] pArrHeader = pHeader.split("filename=");
			String orgFileName = pArrHeader[1].trim().replace("\"", "");
			
			if ( !orgFileName.isEmpty() ) {
				System.out.println("multiFileUpload >> orgFileName : "+ orgFileName);

				part.write(sDir + File.separator + orgFileName);
			}

			arrFileName.add(orgFileName);
		}
		
		return arrFileName;
	}

	// 파일 다운로드
	public void fileDownload(
		HttpServletRequest req,
		HttpServletResponse res,
		String dir, String orgFileName, String outFileName
	) {
		//dir = "D:\\java10\\JSP\\bbsModel2\\src\\main\\webapp\\Uploads";
		//dir = "/Uploads";
		String realPath = req.getServletContext().getRealPath(dir);
		
		try {
			File file = new File(realPath, orgFileName);
			InputStream is = new FileInputStream(file);
			
			//클라이언트 브라우저 체크
			String userAgent = req.getHeader("User-Agent");
			if ( userAgent.indexOf("WOW64") == -1 ) {
				outFileName = new String(outFileName.getBytes("UTF-8"), "ISO-8859-1");
			} else {
				outFileName = new String(outFileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			
			//다운로드할 파일의 응답 헤더 설정
			res.reset();
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attatch; filename=\""+ outFileName +"\"");
			res.setHeader("Content-Length", ""+file.length());
			//out.clear();
			
			OutputStream os = res.getOutputStream();
			
			byte b[] = new byte[(int)file.length()];
			int readBuffer = 0;
			while( (readBuffer = is.read(b)) > 0 ) {
				os.write(b, 0, readBuffer);
			}
			
			// 입출력 스트림 종료
			is.close();
			os.close();
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다. : "+ e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("에러 발생 : "+ e.getMessage());
			e.printStackTrace();
		}
	}
}