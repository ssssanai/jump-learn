package com.ssanai.jumplearn.service.mainpage;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.mapper.mainpage.MainPageMapper;
import com.ssanai.jumplearn.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageServiceIf {
	private final MainPageMapper mainPageMapper;
	private final ModelMapper modelMapper;


	@Override
	public MemberDTO getMemberInfo(String id) {
		log.info("MainPageService >> getMemberInfo");

		MemberVO vo = mainPageMapper.getMemberInfo(id);
		MemberDTO dto = null;
		if(vo != null) {
			 dto = modelMapper.map(mainPageMapper.getMemberInfo(id), MemberDTO.class); ;
		}
		log.info(dto);
		return dto;
	}

	@Override
	public List<ClassDTO> getBottomCards() {
		log.info("MainPageService >> getBottomCards");
		List<ClassDTO> dtoList = mainPageMapper.getBottomCards();
		log.info(dtoList.size());
		return dtoList;
	}

	@Override
	public List<ClassDTO> getRecommendClassWithoutTarget() {
		log.info("MainPageService >> getRecommendClassWithoutTarget");
		List<ClassDTO> dtoList = mainPageMapper.getRecommendClassWithoutTarget();
		log.info(dtoList.size());
		return dtoList;
	}

	@Override
	public List<ClassDTO> getRecommendClassWithTarget(String target) {
		log.info("MainPageService >> getRecommendClassWithTarget");
		List<ClassDTO> dtoList = mainPageMapper.getRecommendClassWithTarget(target);
		log.info(dtoList.size());
		return dtoList;
	}
}
