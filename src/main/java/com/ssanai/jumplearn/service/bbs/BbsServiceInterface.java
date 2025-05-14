package com.ssanai.jumplearn.service.bbs;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import com.ssanai.jumplearn.vo.BbsFileVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BbsServiceInterface {
	public int getTotalCount(PageRequestDTO requestDTO, String table_name);

	public List<BbsDefaultDTO> listAll(PageRequestDTO pageDTO, String table_name);

	public BbsDefaultDTO selectOne(int id, String table_name);

	public int insert(BbsDefaultDTO dto, String table_name);

	public int update(BbsDefaultDTO dto, String table_name);

	public int delete(int id, String table_name);

	public PageResponseDTO<BbsDefaultDTO> searchList(PageRequestDTO pageDTO, String table_name);

	public int viewCount(int id, String table_name);
}
