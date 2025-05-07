package com.ssanai.jumplearn.service.mainpage;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;

import java.util.List;

public interface MainPageServiceIf {
	public MemberDTO getMemberInfo(String id); // 멤버 정보 가져오기
	public List<ClassDTO> getBottomCards();
	public List<ClassDTO> getRecommendClassWithoutTarget();
	public List<ClassDTO> getRecommendClassWithTarget(String target);
}
