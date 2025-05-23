package com.ssanai.jumplearn.service;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.dto.PageResponseDTO;
import com.ssanai.jumplearn.service.inquiry.InquiryServiceIf;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class InquiryServiceTest {
	@Autowired(required = false)
	private InquiryServiceIf inquiryService;

	@Test
	public void test() {
		PageResponseDTO<InquiryDTO> list = inquiryService.getInquiryList(
				PageRequestDTO.builder()
						.search_category("title")
						.search_word("오류")
						.page_no(1)
						.page_block_size(10)
						.page_size(10)
						.build()
		);

		log.info(list);
	}

	@Test
	public void test2() {
		List<InquiryDTO> list = inquiryService.getInquiry(1);
		log.info(list);
	}

	@Test
	public void test3() {
		PageResponseDTO<InquiryDTO> list = inquiryService.getInquiryList(new PageRequestDTO());
		log.info(list);
	}

	@Test
	public void test4() {
		int result = inquiryService.register(
				InquiryDTO.builder()
						.member_id("member001")
						.inquiry_title("TITLE")
						.inquiry_content("CONTENT")
						.build()
		);
		log.info(result);
	}

	@Test
	public void test5() {
		int result = inquiryService.modify(
				InquiryDTO.builder()
						.inquiry_id(28)
						.inquiry_title("asdf")
						.inquiry_content("COsdfadT")
						.build()
		);
		log.info(result);
	}

	@Test
	public void test6() {
		int result = inquiryService.delete(27);
		log.info(result);
	}

	@Test
	public void test7() {
		InquiryDTO dto = InquiryDTO.builder()
				.inquiry_id(29)
				.inquiry_commenter("member001")
				.inquiry_comment_id_type("member")
				.inquiry_comment_content("InquiryServiceTest test7()")
				.build();
		int result = inquiryService.addComment(dto);
		log.info(result);
	}

	@Test
	public void test8() {
		InquiryDTO dto = InquiryDTO.builder()
				.comment_id(8)
				.inquiry_comment_content("InquiryServiceTest test8")
				.build();
		log.info(dto);
		int result = inquiryService.updateComment(dto);
		log.info(result);
	}

	@Test
	public void test9() {
		int result = inquiryService.deleteComment(28);
		log.info(result);
	}
}
