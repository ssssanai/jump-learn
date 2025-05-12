package com.ssanai.jumplearn.mapper.bbs;

import com.ssanai.jumplearn.dto.BbsFileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsFileMapper {
    public int fileUpload(BbsFileDTO dto);

    public int fileDelete(int id);
}
