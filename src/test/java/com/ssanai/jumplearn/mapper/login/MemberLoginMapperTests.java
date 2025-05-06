package com.ssanai.jumplearn.mapper.login;

import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.mapper.admin.ClassListMapper;
import com.ssanai.jumplearn.mapper.admin.MemberListMapper;
import com.ssanai.jumplearn.util.CommonDateUtil;
import com.ssanai.jumplearn.vo.AdminVO;
import com.ssanai.jumplearn.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MemberLoginMapperTests {
    @Autowired(required = false)
    private MemberLoginMapper mapper;
    @Autowired(required = false)
    private AdminLoginMapper aMapper;
    @Autowired(required = false)
    private MemberListMapper lMapper;
    @Autowired(required = false)
    private ClassListMapper cMapper;
    private CommonDateUtil dUtil;


    @Test
    public void testLogin() {
        MemberVO vo = MemberVO.builder()
                .id("user001")
                .password("123456789a!")
                .build();
        MemberDTO dto= mapper.login(vo);
        Assertions.assertNotNull(dto, "로그인 실패 - dto가 null");
        log.info(dto.toString());
    }

    @Test
    public void testRegister() {
        CommonDateUtil dUtil = new CommonDateUtil();
        Date birthDate = dUtil.toDate2("2000-05-23");
        MemberVO vo = MemberVO.builder()
                .id("user002")
                .password("123456789a!")
                .name("림광철")
                .birth(birthDate)
                .email("choho4843@gmail.com")
                .grade("1")
                .gender("F")
                .build();
        int rs = mapper.register(vo);
        log.info(rs);
    }
    @Test
    public void testRegisterIdCheck() {
        MemberDTO dto;
        dto = mapper.registerIdCheck("user004");
        log.info(dto.getId());
        log.info(dto.getName());
    }
    @Test
    public void testLogin2() {
        AdminVO vo = AdminVO.builder()
                .id("admin001")
                .password("123456789a!")
                .build();
        AdminDTO dto= aMapper.login(vo);
        Assertions.assertNotNull(dto, "로그인 실패 - dto가 null");
        log.info(dto.toString());
    }
    @Test
    public void testMemberList(){
        List<MemberDTO> list = lMapper.memberList();
        log.info(list.toString());
    }
//    @Test
//    public void testMemberTotalCount(){
//        int rs = lMapper.memberTotalCount();
//        log.info(rs);
//    }
    @Test
    public void testMemberChage(){
        String id = "admin1";
        int status = 4;
        int rs = lMapper.memberChange(id, status);
        assertTrue(rs > 0);
    }
    @Test
    public void testMemberDelete(){
        String id = "admin1";
        int rs = lMapper.memberDelete(id);
        assertTrue(rs > 0);
    }

    @Test
    public void testClassList(){
        PageRequestDTO requestDTO = new PageRequestDTO();
        List<ClassDetailDTO> result = cMapper.searchList(requestDTO);
        log.info(result.toString());
    }
}
