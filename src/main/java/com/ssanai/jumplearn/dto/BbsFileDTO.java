package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsFileDTO {
    private Integer id;
    private String  filePath;
    private String  fileName;
    private String  fileExt;
    private Long    fileSize;
    private String  relatedTable;
    private Integer relatedId;
}
