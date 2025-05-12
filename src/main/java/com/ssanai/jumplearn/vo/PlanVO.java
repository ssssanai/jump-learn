package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PlanVO {
	private int id;
	private String member_id;
	private String title;
	private String description;
	private LocalDate study_date;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
