package com.ssanai.jumplearn.vo;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsFileVO {
    private int    id;
    private String filePath;
    private String fileName;
    private int    fileSize;
    private String fileExt;
    private String relatedTable;
    private int    relatedId;
    private LocalDateTime createdAt;
}
