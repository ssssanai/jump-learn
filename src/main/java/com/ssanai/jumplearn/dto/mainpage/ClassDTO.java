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
	public String file_name;
	public String file_path;
	public String file_ext;
	public long file_size;
	public int id; // 강좌 id
	public String category;
	public String title; // 강좌 제목
	public String introduce; // 강좌 소개
	public String teacher_id; // 강사 ID
	public String name; // 강사 이름
	public int price; // 가격
	public String target; // 대상
	public int pay_count; // 팔린 수
	public LocalDateTime created_at;
	public String notice;
}
