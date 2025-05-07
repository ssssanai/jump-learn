package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsMapper {
    public int getTotalCount(PageRequestDTO pageDTO);

    public List<BbsDefaultVO> listAll(PageRequestDTO pageDTO);

    public BbsDefaultVO selectOne( int id);

    public int insert(BbsDefaultVO vo);

    public int update(BbsDefaultVO vo);

    public int delete(int id);

    public List<BbsDefaultVO> searchList(PageRequestDTO pageDTO);

}