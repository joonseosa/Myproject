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

	//List<ItemInquiryDTO> getItemInquirys(ItemInquiryDTO iqdto);  //상품문의 list 출력 , 뒤에 s 붙었음 
	List<ItemInquiryDTO> getItemInquirys(@Param("start") int start, @Param("end") int end);  //상품문의 페이징 처리 
	int ItemInquiryDelete(ItemInquiryDTO iqdto);
	void ItemInquiryWriteProc(ItemInquiryDTO iqdto);
	int getItemInquiryscnt();
	ItemInquiryDTO getItemInquiry(ItemInquiryDTO iqdto);   //상품문의 detail(상세보기 출력)

	List<MemberDTO> getMember(@Param("start1") int start1, @Param("end1") int end1);
	int getMemberCount();

	List<ItemDTO> getItem(@Param("start") int start, @Param("end") int end);
	int getItemCount();


	List<OrderDTO> getOrder(@Param("start") int start, @Param("end") int end, @Param("order_no") int order_no);
	List<OrderCancelDTO> getOrderCancel();
	int getOrderCount();

	
}


	


