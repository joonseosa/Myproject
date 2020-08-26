package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.admin.dto.ItemInquiryDTO;
@Mapper
public interface ItemInquiryDAO {
	List<ItemInquiryDTO> getItemInquiry(ItemInquiryDTO iqdto);
	int ItemInquiryDelete(ItemInquiryDTO iqdto);
}
