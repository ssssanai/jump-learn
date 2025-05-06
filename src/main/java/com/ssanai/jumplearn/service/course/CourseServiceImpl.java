package com.ssanai.jumplearn.service.course;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.ClassVideoDTO;
import com.ssanai.jumplearn.dto.ReviewDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.mapper.basket.BasketMapper;
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
public class CourseServiceImpl implements CourseServiceIf {
	private final CourseMapper courseMapper;
	private final ModelMapper modelMapper;

	@Override
	public List<ClassDTO> getClassList(SearchDTO searchDTO) {
		return courseMapper.getClassList(searchDTO);
	}

	@Override
	public int getListTotalCount(SearchDTO searchDTO) {
		return courseMapper.getListTotalCount(searchDTO);
	}

	@Override
	public ClassDetailDTO getClassDetailById(int id) {
		return courseMapper.getClassDetailById(id);
	}

	@Override
	public List<ClassVideoDTO> getClassVideoList(int id) {
		return courseMapper.getClassVideoList(id);
	}

	@Override
	public List<ReviewDTO> getReviewListById(int id) {
		return courseMapper.getReviewListById(id);
	}

	@Override
	public double getReviewRate(int id) {
		return courseMapper.getReviewRate(id);
	}
}
