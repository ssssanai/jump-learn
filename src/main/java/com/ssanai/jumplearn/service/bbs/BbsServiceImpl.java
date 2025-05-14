package com.ssanai.jumplearn.service.bbs;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.mapper.bbs.*;
import com.ssanai.jumplearn.util.CommonDateUtil;
import com.ssanai.jumplearn.util.FilePathConfig;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import com.ssanai.jumplearn.vo.BbsFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BbsServiceImpl implements BbsServiceInterface {
	private final BbsMapper bbsMapper;
	private final ModelMapper modelMapper;

	@Override
	public int getTotalCount(PageRequestDTO requestDTO, String table_name) {
		return bbsMapper.getTotalCount(requestDTO, table_name);
	}

	@Override
	public List<BbsDefaultDTO> listAll(PageRequestDTO pageDTO, String table_name) {
		List<BbsDefaultVO> bbsVOList = bbsMapper.listAll(pageDTO, table_name);
		List<BbsDefaultDTO> bbsDTOList = bbsVOList.stream().map(
				vo -> modelMapper.map(vo, BbsDefaultDTO.class)
		).collect(Collectors.toList());
		return bbsDTOList;

	}

	@Override
	public int insert(BbsDefaultDTO dto, String table_name) {
		BbsDefaultVO vo = modelMapper.map(dto, BbsDefaultVO.class);
		int result = bbsMapper.insert(vo, table_name);
		return result;
	}

	@Override
	public int update(BbsDefaultDTO dto, String table_name) {
		BbsDefaultVO vo = modelMapper.map(dto, BbsDefaultVO.class);
		int result = bbsMapper.update(vo, table_name);
		return result;
	}

	@Override
	public int delete(int id, String table_name) {
		return bbsMapper.delete(id, table_name);
	}

	@Override
	public BbsDefaultDTO selectOne(int id, String table_name) {
		BbsDefaultVO vo = bbsMapper.selectOne(id, table_name);
		BbsDefaultDTO dto = (vo != null ? modelMapper.map(vo, BbsDefaultDTO.class) : null);
		return dto;
	}

	@Override
	public PageResponseDTO<BbsDefaultDTO> searchList(PageRequestDTO pageDTO, String table_name) {
		int totalCount = bbsMapper.getTotalCount(pageDTO, table_name);
		List<BbsDefaultVO> voList = bbsMapper.searchList(pageDTO, table_name);
		List<BbsDefaultDTO> bbsDefaultDTOList = voList.stream().map(
				vo -> modelMapper.map(vo, BbsDefaultDTO.class)
		).collect(Collectors.toList());

		PageResponseDTO<BbsDefaultDTO> pageResponseDTO =
				PageResponseDTO
						.<BbsDefaultDTO>withAll()
						.reqDTO(pageDTO)
						.dtoList(bbsDefaultDTOList)
						.total_count(totalCount)
						.build();
		return pageResponseDTO;
	}

	@Override
	public int viewCount(int id, String table_name) {
		return bbsMapper.viewCount(id, table_name);
	}

}
