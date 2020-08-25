package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.ItemInquiryDTO;

@Mapper
public interface AdminDAO {
	String logon(AdminDTO adto);

	List<ItemInquiryDTO> getItemInquirys(ItemInquiryDTO iqdto);

	List<MemberDTO> getMember(@Param("start1") int start1, @Param("end1") int end1);

	List<ItemDTO> getItem(@Param("start") int start, @Param("end") int end);

	List<OrderDTO> getOrder(@Param("start") int start, @Param("end") int end, @Param("order_no") int order_no);
	
	List<OrderCancelDTO> getOrderCancel();

	int getItemCount();

	int getMemberCount();
	
	int getOrderCount();

	ItemInquiryDTO getItemInquiry(ItemInquiryDTO iqdto);
}
