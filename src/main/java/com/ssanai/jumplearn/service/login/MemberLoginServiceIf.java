package com.ssanai.jumplearn.service.login;

import com.ssanai.jumplearn.dto.MemberDTO;

public interface MemberLoginServiceIf {
    public void register(MemberDTO dto); //회원가입
    public MemberDTO login(MemberDTO dto); //로그인
    public void confirmMember(MemberDTO dto); //비밀번호 변경전 아이디, 이메일 확인
    public void changePassword(MemberDTO dto); //비밀번호 변경
    public void logout(MemberDTO dto); // 로그아웃
    public void profileUpdate(MemberDTO dto); //사진 업로드
    public void memberUpdate(MemberDTO dto); //회원 정보 수정
}
