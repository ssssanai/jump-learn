package com.ssanai.jumplearn.mapper.login;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.vo.MemberVO;

public interface MemberLoginMapper {
    public int register(MemberVO vo); //회원가입
    public MemberDTO login(MemberVO vo); //로그인
    public MemberDTO registerIdCheck(String id); //회원가입시 중복 ID CHECK
    public int confirmMember(MemberVO vo); //비밀번호 변경전 아이디, 이메일 확인
    public int changePassword(MemberVO vo); //비밀번호 변경
    public void logout(MemberVO vo); // 로그아웃
    public int profileUpdate(MemberVO vo); //사진 업로드
    public int memberUpdate(MemberVO vo); //회원 정보 수정
}
