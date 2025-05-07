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
public class BasketDTO {
	public int id;
	public int class_id;
	public String member_id; // 학생 아이디
	public LocalDateTime created_at; // 장바구니에 추가한 날짜
	public String title; // 강좌 제목
	public String introduce; // 강좌 설명
	public int price;
	public String file_path;
	public String file_name;
	public String file_ext;
	public String teacher; // 선생님 이름
}
