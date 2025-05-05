package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.mapper.course.CourseMapper;
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
public class CourseServiceImpl implements CourseServiceIf{
	private final CourseMapper courseMapper;
	private final ModelMapper modelMapper;

	@Override
	public List<ClassDTO> getClassList() {
		return courseMapper.getClassList();
	}

	@Override
	public List<BasketDTO> getBasketList(String id) {
		return courseMapper.getBasketList(id);
	}
}
