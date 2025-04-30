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
    public void register(MemberDTO dto){

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
    @Override //비밀번호 변경전 아이디, 이메일 확인
    public void confirmMember(MemberDTO dto){

    }
    @Override //비밀번호 변경
    public void changePassword(MemberDTO dto){

    }
    @Override //로그아웃
    public void logout(MemberDTO dto){

    }
    @Override //사진 업로드
    public void profileUpdate(MemberDTO dto){

    }
    @Override //회원정보 수정
    public void memberUpdate(MemberDTO dto){

    }
}
