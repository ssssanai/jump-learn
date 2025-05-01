package com.ssanai.jumplearn.service.login;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.mapper.login.MemberLoginMapper;
import com.ssanai.jumplearn.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberLoginServiceImpl implements MemberLoginServiceIf {
    private final MemberLoginMapper MemberLoginXmlMapper;
    private final ModelMapper modelMapper;


    @Override//회원가입
    public int register(MemberDTO dto){
        log.info("회원가입 시도1");
        log.info(dto.toString());
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int rs = MemberLoginXmlMapper.register(vo);
        log.info("성공 실패 여부 : "+ rs);
        return rs;
    }
    @Override //로그인
    public MemberDTO login(MemberDTO dto){
        log.info("로그인 시도1");
        log.info(dto.toString());
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        log.info(vo.toString());
        MemberDTO Mdto = MemberLoginXmlMapper.login(vo);
        log.info(Mdto);
        return Mdto;
    }
    @Override //회원가입시 중복 ID CHECK
    public MemberDTO registerIdCheck(String id) {
        MemberDTO dto;
        log.info("중복ID CHECK");
        log.info(id);
        dto = MemberLoginXmlMapper.registerIdCheck(id);
        return dto;
    }
    @Override //비밀번호 변경전 아이디, 이메일 확인
    public int confirmMember(MemberDTO dto){

        return 0;
    }
    @Override //비밀번호 변경
    public int changePassword(MemberDTO dto){

        return 0;
    }
    @Override //로그아웃
    public void logout(MemberDTO dto){

    }
    @Override //사진 업로드
    public int profileUpdate(MemberDTO dto){
        return 0;
    }
    @Override //회원정보 수정
    public int memberUpdate(MemberDTO dto){
        return 0;
    }
}
