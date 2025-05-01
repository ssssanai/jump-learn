package com.ssanai.jumplearn.service.login;

import com.ssanai.jumplearn.dto.MemberDTO;

public interface MemberLoginServiceIf {
    public int register(MemberDTO dto); //회원가입
    public MemberDTO login(MemberDTO dto); //로그인
    public MemberDTO registerIdCheck(String id); //회원가입시 중복 ID CHECK
    public int confirmMember(MemberDTO dto); //비밀번호 변경전 아이디, 이메일 확인
    public int changePassword(MemberDTO dto); //비밀번호 변경
    public void logout(MemberDTO dto); // 로그아웃
    public int profileUpdate(MemberDTO dto); //사진 업로드
    public int memberUpdate(MemberDTO dto); //회원 정보 수정
}
