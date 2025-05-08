package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.InquiryDTO;
import com.ssanai.jumplearn.dto.PageRequestDTO;
import com.ssanai.jumplearn.mapper.inquiry.InquiryMapper;
import com.ssanai.jumplearn.vo.InquiryCommentVO;
import com.ssanai.jumplearn.vo.InquiryVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class InquiryMapperTest {
	@Autowired(required = false)
	private InquiryMapper mapper;

	@Test
	public void test() {
		List<InquiryDTO> list = mapper.getInquiryList(
				PageRequestDTO.builder()
						.search_category("title")
						.search_word("오류")
						.page_no(1)
						.page_block_size(10)
						.page_size(10)
						.build()
		);
		for (InquiryDTO inquiryDTO : list) {
			log.info(inquiryDTO);
		}
	}

	@Test
	public void test2() {
		List<InquiryDTO> inquiry = mapper.getInquiry(1);
		log.info(inquiry);
	}

	@Test
	public void test3() {
		int total = mapper.getInquiryTotalCount(
				PageRequestDTO.builder().build()
		);
		log.info(total);
	}

	@Test
	public void test4() {
		int total = mapper.getInquiryTotalCount(
				PageRequestDTO.builder()
						.search_category("title")
						.search_word("오류")
						.page_no(1)
						.page_block_size(10)
						.page_size(10)
						.build()
		);
		log.info(total);
	}

	@Test
	public void test5() {
		int result = mapper.register(InquiryVO.builder().member_id("member001").title("asdf").content("asdfasdfasdf").visibility(1).build());
		log.info(result);
	}

	@Test
	public void test6() {
		int result = mapper.modify(InquiryVO.builder().id(24).title("1243").content("asdfasdf12341234asdf").visibility(1).build());
		log.info(result);
	}

	@Test
	public void test7() {
		int result = mapper.delete(23);
		log.info(result);
	}

	@Test
	public void test8() {
		InquiryCommentVO vo = InquiryCommentVO.builder()
				.inquiry_id(29)
				.commenter("member001")
				.content("댓글 테스트 5")
				.comment_id_type("member")
				.build();
		log.info(vo.toString());
		int result = mapper.addComment(vo);
		log.info(result);
	}

	@Test
	public void test9() {
		InquiryCommentVO vo = InquiryCommentVO.builder().id(8).content("댓글 수정됨.").build();
		log.info(vo);
		int result = mapper.updateComment(vo);
		log.info(result);
	}

	@Test
	public void test10() {
		int result = mapper.deleteComment(5);
		log.info(result);
	}
}
