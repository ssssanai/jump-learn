package com.ssanai.jumplearn.service;


import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.BbsFileDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.bbs.BbsServiceInterface;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import com.ssanai.jumplearn.vo.BbsFileVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BbsServiceTests {

    @Autowired(required = false)
    private BbsServiceInterface bbsService;
//
//    @Test
//    public void testGetTotalCount() {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .page_no(2)
//                .page_size(10)
//                .build();
//        int totalCount = bbsService.getTotalCount(pageRequestDTO);
//        Assertions.assertTrue(totalCount >= 0, "전체 게시글 수 조회");
//        log.info("BbsServiceTests >> testGetTotalCount >> totalCount : {}", totalCount);
//    }
//
//    @Test
//    public void testListAll() {
//                PageRequestDTO pageDTO = PageRequestDTO.builder()
//                .page_no(2)
//                .page_size(10)
//                .search_category("title")
//                .search_word("50")
//                .build();
//        List<BbsDefaultDTO> dtoList = bbsService.listAll(pageDTO);
//        Assertions.assertNotNull(dtoList, "listAll() should not return null");
//        log.info("testListAll -> {}", dtoList);
//    }
//
//    @Test
//    public void testInsert() {
//        BbsDefaultDTO dto = BbsDefaultDTO.builder()
//                .title("서비스 테스트 제목")
//                .content("서비스 테스트 본문")
//                .admin_id("admin001")
//                .build();
//
//        int result = bbsService.insert(dto);
//        Assertions.assertEquals(1, result, "insert() should affect 1 row");
//    }
//
//    @Test
//    public void testUpdate() {
//        BbsDefaultDTO dto = BbsDefaultDTO.builder()
//                .id(106)
//                .title("서비스 수정된 제목106-1")
//                .content("서비스 수정된 본문106-1")
//                .admin_id("admin001")
//                .build();
//
//        int result = bbsService.update(dto);
//    }
//
//    @Test
//    public void testDelete() {
//        int id = 105;
//        int result = bbsService.delete(id);
//        Assertions.assertEquals(1, result, "delete() should affect 1 row");
//        log.info("testDelete affected rows: {}", result);
//    }
//
//    @Test
//    public void testSelectOne() {
//        int id = 102;
//        BbsDefaultDTO dto = bbsService.selectOne(id);
//        Assertions.assertNotNull(dto, "selectOne(" + id + ") should find a record");
//        log.info("testSelectOne -> {}", dto);
//    }
//
//    @Test
//    public void testSearchList(){
//        PageRequestDTO pageDTO = PageRequestDTO.builder()
//                .page_no(2)
//                .page_size(10)
//                .search_category("title")
//                .search_word("입력")
//                .build();
//
//        PageResponseDTO resDTO = bbsService.searchList(pageDTO);
//        Assertions.assertNotNull(resDTO , "성공");
//        log.info("BbsTests >> testSearchList >> resDTO : {}", resDTO);
//    }

//    @Test
//    public void attachedPic(){
//        List<BbsFileDTO> files = bbsService.attachedPic(1);
//
//        Assertions.assertNotNull(files,"파일 리스트가 없습니다.");
//        Assertions.assertFalse(files.isEmpty(),"파일이 없습니다.");
//        files.forEach(f -> log.info("file VO => {}",f));
//
//    }

//    @Test
//    public void attachedPdf(){
//        List<BbsFileDTO> files = bbsService.attachedPdf(1);
//
//        Assertions.assertNotNull(files,"파일 리스트가 없습니다.");
//        Assertions.assertFalse(files.isEmpty(),"파일이 없습니다.");
//        files.forEach(f -> log.info("file VO => {}",f));
//
//    }
}
