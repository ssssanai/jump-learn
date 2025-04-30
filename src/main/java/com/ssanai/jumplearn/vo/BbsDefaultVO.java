package com.ssanai.jumplearn.vo;

import com.sun.jna.platform.win32.Sspi;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
// 게시판용 VO
public class BbsDefaultVO  {
	private int id;
	private String title;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private int view_count;
	private String admin_id;
}
