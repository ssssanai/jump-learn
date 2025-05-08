package com.ssanai.jumplearn.service.bbs;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.BbsFileDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import com.ssanai.jumplearn.vo.BbsFileVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsServiceInterface {
    public int getTotalCount(PageRequestDTO requestDTO);

    public List<BbsDefaultDTO> listAll(PageRequestDTO pageDTO);

    public int insert(BbsDefaultDTO dto);

    public int update(BbsDefaultDTO dto);

    public int delete(int id);

    public BbsDefaultDTO selectOne( int id);

    public PageResponseDTO<BbsDefaultDTO> searchList(PageRequestDTO pageDTO);

    public List<BbsFileDTO> attachedPic(@Param("id") int id);

    public List<BbsFileDTO> attachedPdf(@Param("id") int id);

}
