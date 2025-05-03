package com.ssanai.jumplearn.dto.mainpage;

import lombok.*;
import lombok.extern.log4j.Log4j2;

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
	public int id; // 강좌 id
	public String title; // 강좌 제목
	public String introduce; // 강좌 소개
	public String teacher_id; // 강사
	public int price; // 가격
	public String target; // 대상
	public int pay_count; // 팔린 수
}
