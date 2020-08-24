package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.admin.dto.ItemInquiryDTO;

public interface ItemInquiryService {
	List<ItemInquiryDTO> getReview(ItemInquiryDTO iqdto);
}
