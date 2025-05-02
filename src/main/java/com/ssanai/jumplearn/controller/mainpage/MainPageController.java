package com.ssanai.jumplearn.controller.mainpage;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/main")
public class MainPageController {
	@GetMapping
	public String mainPage() {
		return "mainPage/mainPage";
	}
}
