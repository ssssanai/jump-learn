package com.ssanai.jumplearn.vo;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostFileVO {
	private int id;
	private int file_id; // tbl_bbs_file PK 참조
	private int post_id; // tbl_post 참조
}
