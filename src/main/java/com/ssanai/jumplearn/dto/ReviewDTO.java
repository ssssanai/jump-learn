package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
	private int class_id;
	private String member_id;
	private String review;
	private int feedback_score;
}
