package com.ssanai.jumplearn.service.pay;

import com.ssanai.jumplearn.dto.BasketDTO;
import com.ssanai.jumplearn.dto.EnrollmentsDTO;
import com.ssanai.jumplearn.mapper.pay.PayMapper;
import com.ssanai.jumplearn.vo.PayVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class PayServiceImpl implements PayServiceIf{
	private final PayMapper payMapper;

	@Override
	public int createPay(BasketDTO dto) {
		return payMapper.createPay(dto);
	}

	@Override
	public List<EnrollmentsDTO> getPayList(String member_id) {
		return payMapper.getPayList(member_id);
	}

	@Override
	public int confirmPurchase(int id) {
		return payMapper.confirmPurchase(id);
	}

	@Override
	public int refund(int id) {
		return payMapper.refund(id);
	}

	@Override
	public List<PayVO> getList(String member_id) {
		return payMapper.getList(member_id);
	}

	@Override
	public List<Integer> getPayIdListFromEnrollDontHave(String member_id) {
		return payMapper.getPayIdListFromEnrollDontHave(member_id);
	}
}
