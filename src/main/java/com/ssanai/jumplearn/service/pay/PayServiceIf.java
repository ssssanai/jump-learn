package com.ssanai.jumplearn.service.pay;

import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.vo.PlanVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayServiceIf {
//	public int createPay(@Param("vo") PlanVO vo); // 생성 (장바구니에 있는 항목이 결제 됐을 때 추가)
	public List<EnrollmentsDTO> getPayList(@Param("member_id") String member_id);// 결제 내역 조회
	public int confirmPurchase(@Param("id") int id); // 구매 확정
	public int refund(@Param("id") int id); // 환불 요청
//	public int deletePay(@Param("id") int id); // 삭제
}
