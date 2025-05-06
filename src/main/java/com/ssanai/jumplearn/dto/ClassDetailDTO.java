package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassDetailDTO {
	// 강좌 정보
	private int class_id;
	private String class_title;
	private String class_category;
	private String class_target;
	private int class_price;
	private String class_introduce;
	private String class_file_path;
	private String class_file_name;
	private String class_file_ext;
	//file_size추가
	private long class_file_size;
	//선생님 아이디 없길래 추가
	private String class_teacher_id;

	// 강사 정보
	private String teacher_name;
	private String teacher_introduce1;
	private String teacher_introduce2;
	private String teacher_introduce3;
	private String teacher_file_path;
	private String teacher_file_name;
	private String teacher_file_ext;

	// 동영상 개수
	private int total_video_count;

}
