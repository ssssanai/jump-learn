package com.ssanai.jumplearn.service.bbs;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.vo.BbsDefaultVO;

import java.util.List;

public interface BbsServiceInterface {

    public List<BbsDefaultDTO> listAll();

    public List<BbsDefaultDTO> list();

    public int insert(BbsDefaultDTO dto);

    public int update(BbsDefaultDTO dto);

    public int delete(int id);

    public BbsDefaultDTO selectOne( int id);

}
