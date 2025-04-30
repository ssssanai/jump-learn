package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsMapper {
    public List<BbsDefaultVO> listAll();

//    public List<BbsDefaultVO> list();

//    public int insert(BbsDefaultVO vo);

    public int update(BbsDefaultVO vo);

//    public int delete(int id);

//    public BbsDefaultVO selectOne(@Param("id") int id);

}