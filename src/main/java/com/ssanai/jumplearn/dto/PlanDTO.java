package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Log4j2
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDTO {
	private int id;
	private String member_id;
	private String title;
	private String description;
	private LocalDate study_date;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
