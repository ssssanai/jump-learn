package com.ssanai.jumplearn.mapper.mainpage;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.vo.MemberVO;

import java.util.List;
import java.util.Map;

public interface MainPageMapper {
	public MemberVO getMemberInfo(String id); // 멤버 정보 가져오기
	public List<ClassDTO> getBottomCards();
	public List<ClassDTO> getRecommendClassWithoutTarget();
	public List<ClassDTO> getRecommendClassWithTarget(String target);
}
