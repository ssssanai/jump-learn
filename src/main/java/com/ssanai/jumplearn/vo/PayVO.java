package com.ssanai.jumplearn.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PayVO {
	private int id; // 결제 ID
	private int class_id; // 강좌 ID
	private String member_id; // 구매한 멤버 ID
	private int cost; // 가격
	private LocalDateTime created_at; // 결제 일시
	private LocalDateTime canceled_at; // 결제 취소일시
	private int complete; // 1: 구매확정, 0: 구매 취소
}
