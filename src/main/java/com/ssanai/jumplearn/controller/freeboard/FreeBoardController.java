package com.ssanai.jumplearn.controller.freeboard;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.nio.file.Paths;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	@GetMapping("/list")
	public String list() {


		return "freeboard/list";
	}

	@GetMapping("/write")
	public String write(){
		return "freeboard/write";
	}
}
