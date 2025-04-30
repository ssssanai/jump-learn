package com.ssanai.jumplearn.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
// 게시판용 VO
public class BbsDefaultDTO {
	@PositiveOrZero
	@Min(0)
	private int id;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	@PositiveOrZero
	@Builder.Default
	@Min(0)
	private int view_count=0;
	@NotBlank
	private String admin_id;
}
