package com.ssanai.jumplearn.mapper.bbs;

import com.ssanai.jumplearn.dto.BbsFileDTO;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface EduFileMapper {
    public int eduFileUpload(Map<String,Integer> params);

    public int eduFileDelete(int id);
}
