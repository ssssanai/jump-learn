package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.MemberDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.mapper.admin.MemberListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
public class MemberListServiceImpl implements MemberListServiceIf {
    private final MemberListMapper memberListMapper;
    private final ModelMapper modelMapper;

    @Override
    public List<MemberDTO> memberList() {
        List<MemberDTO> list;
        list = memberListMapper.memberList();
        return list;
    }

    @Override
    public int memberDelete(String id){
        int rs = memberListMapper.memberDelete(id);
        return rs;
    }

    @Override
    public int memberChange(String id, int status){
        int rs = memberListMapper.memberChange(id, status);
        return rs;
    }

    @Override
    public PageResponseDTO<MemberDTO> searchList(PageRequestDTO requestDTO) {
        // 조건에 따른 DB 조회
        int totalCount = memberListMapper.memberTotalCount(requestDTO);
        List<MemberDTO> memberList = memberListMapper.searchList(requestDTO);
        // VO --> DTO 객체 매핑
        List<MemberDTO> bbsDTOList =
                memberList.stream().map(
                        vo->modelMapper.map(vo, MemberDTO.class)
                ).collect(Collectors.toList());

        // DTO 객체 + UI 제어위한 파라미터 매핑
        PageResponseDTO<MemberDTO> responseDTO =
                PageResponseDTO
                        .<MemberDTO>withAll()
                        .reqDTO(requestDTO)
                        .dtoList(bbsDTOList)
                        .total_count(totalCount)
                        .build();
        return responseDTO;
    }

    @Override
    public int memberTotalCount(PageRequestDTO requestDTO) {
        return memberListMapper.memberTotalCount(requestDTO);
    }
}
