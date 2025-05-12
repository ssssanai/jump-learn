package com.ssanai.jumplearn.mapper.pay;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.vo.PayVO;
import com.ssanai.jumplearn.vo.PlanVO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface PayMapper {
	public int createPay(@Param("dto") BasketDTO dto); // 생성 (장바구니에 있는 항목이 결제 됐을 때 추가)
	public List<EnrollmentsDTO> getPayList(@Param("member_id") String member_id);// 결제 내역 조회
	public List<PayVO> getList(@Param("member_id") String member_id);
	public int confirmPurchase(@Param("id") int id); // 구매 확정
	public int refund(@Param("id") int id); // 환불 요청
	public List<Integer> getPayIdListFromEnrollDontHave(@Param("member_id") String member_id);
//	public int deletePay(@Param("id") int id); // 삭제
}
