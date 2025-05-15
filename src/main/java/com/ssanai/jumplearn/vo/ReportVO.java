package com.ssanai.jumplearn.vo;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReportVO {
	private int id; // 신고 PK
	private int target_id; // 신고한 게시글 ID
	private String target_type; // 신고 대상(게시글)
	private String member_id; // 신고한 사람 ID
	private String reason; // 신고 사유
	private LocalDateTime created_at; // 신고 일시
	private String report_status; // 신고에 대한 처리 상태 (pending, complete)
}
