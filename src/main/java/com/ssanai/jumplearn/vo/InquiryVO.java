package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InquiryVO {
	private int id;
	private String member_id;
	private String title;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private String inquiry_status;
	private int visibility;
}
