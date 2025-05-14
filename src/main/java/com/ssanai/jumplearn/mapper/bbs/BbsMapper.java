package com.ssanai.jumplearn.mapper.bbs;


import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import com.ssanai.jumplearn.vo.BbsFileVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsMapper {
	//    (table_name: tbl_*, colName: *_id ) (* = [edu, info, lib, news, notice, activity])
	public int getTotalCount(@Param("dto") PageRequestDTO pageDTO, @Param("table_name") String table_name);

	public List<BbsDefaultVO> listAll(@Param("dto") PageRequestDTO pageDTO, @Param("table_name") String table_name);

	public BbsDefaultVO selectOne(@Param("id")int id, @Param("table_name") String table_name);

	public int insert(@Param("vo") BbsDefaultVO vo, @Param("table_name") String table_name);

	public int update(@Param("vo") BbsDefaultVO vo, @Param("table_name") String table_name);

	public int delete(@Param("id") int id, @Param("table_name") String table_name);

	public List<BbsDefaultVO> searchList(@Param("dto") PageRequestDTO pageDTO, @Param("table_name") String table_name);

	public int viewCount(@Param("id") int id, @Param("table_name") String table_name);

}