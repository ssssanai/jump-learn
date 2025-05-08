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
    int id;
    String file_path;
    String file_name;
    int file_size;
    String file_ext;
    String related_table;
    int related_id;
    LocalDateTime created_at;
}
