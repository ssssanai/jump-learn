package com.ssanai.jumplearn.dto.mainpage;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassDTO {
	private String file_name;
	private String file_path;
	private String file_ext;
	private long file_size;
	private int id; // 강좌 id
	private String category;
	private String title; // 강좌 제목
	private String introduce; // 강좌 소개
	private String teacher_id; // 강사 ID
	private String name; // 강사 이름
	private int price; // 가격
	private String target; // 대상
	private int pay_count; // 팔린 수
	private LocalDateTime created_at;
	private String notice;
}
