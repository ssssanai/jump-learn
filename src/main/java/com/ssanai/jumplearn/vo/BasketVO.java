package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BasketVO {
	private int id;
	private int class_id;
	private String member_id;
	private LocalDateTime created_at;
}
