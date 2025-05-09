package com.ssanai.jumplearn.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {
	// 자유 게시판 컨트롤러
	@GetMapping("/list")
	public String list() {


		return "post/list";
	}

	@GetMapping("/write")
	public String write(){
		return "post/write";
	}
}
