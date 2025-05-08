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
public class ClassVideoDTO {
	private int id;
	private int class_id;
	private int video_order;
	// 외부 영상인 경우
	private String video_url;
	// 로컬 영상인 경우
	private String video_path;
	private String video_name;
	private String video_extension;
	private long video_size;

	private String title;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;

	//해당 선생님 필드 추가
	private String teacher_id;
	//해당 데이터 필드 추가
	private String data_name;
	private int data_id;

}
