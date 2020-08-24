package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.admin.dao.ItemInquiryDAO;
import kr.co.sol.admin.dto.ItemInquiryDTO;
import kr.co.sol.admin.service.ItemInquiryService;
@Service
public class ItemInquiryServiceImpl implements ItemInquiryService {
	
	@Autowired
	ItemInquiryDAO iteminquiryDAO;
	
	
	@Override
	public List<ItemInquiryDTO> getReview(ItemInquiryDTO iqdto) {
		return iteminquiryDAO.getItemInquiry(iqdto);
	}

}
