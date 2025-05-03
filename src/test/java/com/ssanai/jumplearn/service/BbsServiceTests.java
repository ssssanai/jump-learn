package com.ssanai.jumplearn.service;


import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.service.bbs.BbsServiceInterface;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
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

    @Test
    public void testListAll() {
        List<BbsDefaultDTO> dtoList = bbsService.listAll();
        Assertions.assertNotNull(dtoList, "listAll() should not return null");
        log.info("testListAll -> {}", dtoList);
    }

    @Test
    public void testList() {
        List<BbsDefaultDTO> dtoList = bbsService.list();
        Assertions.assertNotNull(dtoList, "list() should not return null");
        log.info("testList -> {}", dtoList);
    }

    @Test
    public void testSelectOne() {
        // 사전에 ID=2 데이터가 반드시 있어야 합니다.
        int id = 2;
        BbsDefaultDTO dto = bbsService.selectOne(id);
        Assertions.assertNotNull(dto, "selectOne(" + id + ") should find a record");
        log.info("testSelectOne -> {}", dto);
    }

    @Test
    public void testInsert() {
        BbsDefaultDTO dto = BbsDefaultDTO.builder()
                .title("서비스 테스트 제목")
                .content("서비스 테스트 본문")
                .admin_id("admin001")   // DTO에 맞는 필드명 사용
                .build();

        int result = bbsService.insert(dto);
        Assertions.assertEquals(1, result, "insert() should affect 1 row");
        log.info("testInsert affected rows: {}", result);
        log.info("Inserted DTO (id may be set if service populates it): {}", dto);
    }

    @Test
    public void testUpdate() {
        // 사전에 ID=2 데이터가 있어야 합니다.
        BbsDefaultDTO dto = BbsDefaultDTO.builder()
                .id(2)                        // 수정할 PK
                .title("서비스 수정된 제목")
                .content("서비스 수정된 본문")
                .admin_id("tester")             // 필요 시
                .build();

        int result = bbsService.update(dto);
        Assertions.assertEquals(1, result, "update() should affect 1 row");
        log.info("testUpdate affected rows: {}", result);
    }

    @Test
    public void testDelete() {
        // 사전에 ID=3 데이터가 있어야 합니다.
        int id = 4;
        int result = bbsService.delete(id);
        Assertions.assertEquals(1, result, "delete() should affect 1 row");
        log.info("testDelete affected rows: {}", result);
    }
}
