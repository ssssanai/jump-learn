package com.ssanai.jumplearn.dto.course;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchDTO {
	private String search_word;
	private String search_condition1;
	private String search_condition2;
	private String search_condition3;
	private String sort_condition;
}
