package com.ssanai.jumplearn.service.bbs;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.vo.BbsDefaultVO;

import java.util.List;

public interface BbsServiceInterface {
    public int getTotalCount(PageRequestDTO requestDTO);

    public List<BbsDefaultDTO> listAll(PageRequestDTO pageDTO);

    public int insert(BbsDefaultDTO dto);

    public int update(BbsDefaultDTO dto);

    public int delete(int id);

    public BbsDefaultDTO selectOne( int id);

    public PageResponseDTO<BbsDefaultDTO> searchList(PageRequestDTO pageDTO);

}
