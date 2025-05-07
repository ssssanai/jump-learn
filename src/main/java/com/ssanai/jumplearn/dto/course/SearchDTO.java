package com.ssanai.jumplearn.dto.course;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.index.qual.Positive;

@Log4j2
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchDTO {
	@Builder.Default
	@Positive
	@Min(value=1)
	private int page_no=1;
	@Builder.Default
	@Positive
	@Min(value=1)
	private int page_size=10;
	@Builder.Default
	@PositiveOrZero
	@Min(value=0)
	private int page_skip_count=0;
	@Builder.Default
	@Positive
	@Min(value=1)
	private int page_block_size=10;

	public int getPage_skip_count() {
		return (this.page_no-1)*this.page_size;
	}

	private String search_word;
	private String search_condition1; // 입력란
	private String search_condition2; // 타겟
	private String search_condition3; // 과목
	private String sort_condition;
}
