package com.ssanai.jumplearn.mapper;


import com.ssanai.jumplearn.mapper.BbsMapper;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BbsTests {
    @Autowired(required = false)
    private BbsMapper bbsMapper;


    @Test
    public void testListAll() {
        List<BbsDefaultVO> voList = bbsMapper.listAll();
        Assertions.assertNotNull(voList , "실패");
        log.info(voList.toString());
    }

    @Test
    public void testUpdate() {
        BbsDefaultVO vo = BbsDefaultVO.builder()
                .id(2)
                .title("테스트제목3")
                .content("테스트본문3")
                .build();
        int testResult = bbsMapper.update(vo);
        log.info("테스트 결과:" + testResult);
        log.info(vo.toString());
    }

    @Test
    public void testSelectOne() throws Exception {
        BbsDefaultVO vo = bbsMapper.selectOne(2);
        Assertions.assertNotNull(vo, "게시판 글 조회 성공");
        log.info("BbsTests >> testSelectOne >> vo : {}", vo.toString());
    }


    @Test
    public void testDelete() throws Exception {
        int testResult = bbsMapper.delete(3);
        log.info("삭제테스트결과:" + testResult);
    }


    @Test
    public void testInsert() throws Exception {
        BbsDefaultVO vo = BbsDefaultVO.builder()
                .title("테스트제목3")
                .content("테스트본문3")
                .admin_id("admin1")
                .build();
        int testResult = bbsMapper.insert(vo);
        log.info("테스트 결과:" + testResult);
        log.info(vo.toString());
    }


    @Test
    public void testList() {
        List<BbsDefaultVO> voList = bbsMapper.list();
        Assertions.assertNotNull(voList , "실패");
        log.info(voList.toString());
    }



}
