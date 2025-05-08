package com.ssanai.jumplearn.vo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EnrollmentsVO {
	private int id;
	private String member_id;
	private int pay_id;
	private int class_id;
	private int progress;
	private String review;
	private int midterm_score;
	private int final_score;
	private int final_grade_score;
	private int feedback_score;
}
