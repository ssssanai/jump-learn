package com.ssanai.jumplearn.service.bbs;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.mapper.BbsMapper;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BbsServiceImpl implements BbsServiceInterface {
    private final BbsMapper bbsMapper;
    private final ModelMapper modelMapper;


    public  List<BbsDefaultDTO> listAll(){
        return null;
    };

    @Override
    public List<BbsDefaultDTO> list(){
        return null;
    };

    @Override
    public int insert(BbsDefaultDTO dto){
        BbsDefaultVO vo = modelMapper.map(dto,BbsDefaultVO.class);
        int result = bbsMapper.insert(vo);
        int id = vo.getId();
        return result;
    };

    @Override
    public int update(BbsDefaultDTO dto){
        return 0;
    };

    @Override
    public int delete(int id){
        return 0;
    };

    @Override
    public BbsDefaultDTO selectOne( int id){
        return null;
    };
}
