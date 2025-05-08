package com.ssanai.jumplearn.service.bbs;

import com.ssanai.jumplearn.dto.BbsDefaultDTO;
import com.ssanai.jumplearn.dto.BbsFileDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.mapper.BbsMapper;
import com.ssanai.jumplearn.vo.BbsDefaultVO;
import com.ssanai.jumplearn.vo.BbsFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BbsServiceImpl implements BbsServiceInterface {
    private final BbsMapper bbsMapper;
    private final ModelMapper modelMapper;


    @Override
    public int getTotalCount(PageRequestDTO requestDTO) {
        return bbsMapper.getTotalCount(requestDTO);
    }

    @Override
    public  List<BbsDefaultDTO> listAll(PageRequestDTO pageDTO){
        List<BbsDefaultVO> bbsVOList = bbsMapper.listAll(pageDTO);
        List<BbsDefaultDTO> bbsDTOList =  bbsVOList.stream().map(
                vo->modelMapper.map(vo, BbsDefaultDTO.class)
        ).collect(Collectors.toList());
        return bbsDTOList;

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
        BbsDefaultVO vo = modelMapper.map(dto,BbsDefaultVO.class);
        int result = bbsMapper.update(vo);
        return result;
    };

    @Override
    public int delete(int id){
        int result = bbsMapper.delete(id);
        return result;
    };

    @Override
    public BbsDefaultDTO selectOne( int id){
        BbsDefaultVO vo = bbsMapper.selectOne(id);
        BbsDefaultDTO dto = (vo != null ? modelMapper.map(vo,BbsDefaultDTO.class) :null);
        return dto;
    };

    @Override
    public PageResponseDTO<BbsDefaultDTO> searchList(PageRequestDTO pageDTO){
        int totalCount = bbsMapper.getTotalCount(pageDTO);
        List<BbsDefaultVO> voList = bbsMapper.searchList(pageDTO);
        List<BbsDefaultDTO> bbsDefaultDTOList = voList.stream().map(
                vo->modelMapper.map(vo, BbsDefaultDTO.class)
        ).collect(Collectors.toList());

        PageResponseDTO<BbsDefaultDTO> pageResponseDTO =
                PageResponseDTO
                        .<BbsDefaultDTO>withAll()
                        .reqDTO(pageDTO)
                        .dtoList(bbsDefaultDTOList)
                        .total_count(totalCount)
                        .build();
        return pageResponseDTO;
    }

    @Override
    public List<BbsFileDTO> attachedPic( int id){
        List<BbsFileVO> fileVO = bbsMapper.attachedPic(id);
        List<BbsFileDTO> fileDTO = fileVO.stream().map(
                vo->modelMapper.map(vo, BbsFileDTO.class)
        ).collect(Collectors.toList());

        return fileDTO;
    };

    @Override
    public List<BbsFileDTO> attachedPdf( int id){
        List<BbsFileVO> fileVO = bbsMapper.attachedPdf(id);
        List<BbsFileDTO> pdfFileDTO = fileVO.stream().map(
                vo->modelMapper.map(vo, BbsFileDTO.class)
        ).collect(Collectors.toList());

        return pdfFileDTO;
    };
}
