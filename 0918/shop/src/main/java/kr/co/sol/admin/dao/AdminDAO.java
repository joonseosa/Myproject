package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.PayMoneyDTO;
import kr.co.sol.admin.dto.ItemInquiryDTO;
import kr.co.sol.admin.dto.MdItemDTO;

@Mapper
public interface AdminDAO {
	String logon(AdminDTO adto);

	List<ItemInquiryDTO> getItemInquirys(@Param("start") int start, @Param("end") int end);  //상품문의 페이징 처리 , 뒤에 s 붙었음 
	int ItemInquiryDelete(ItemInquiryDTO iqdto);
	void ItemInquiryWriteProc(ItemInquiryDTO iqdto);
	int getItemInquiryscnt();
	ItemInquiryDTO getItemInquiry(ItemInquiryDTO iqdto);   //상품문의 detail(상세보기 출력)


	//회원관리
	List<MemberDTO> getMember(@Param("start1") int start1, @Param("end1") int end1);
	int getMemberCount();

	//상품등록
	List<ItemDTO> getItem(@Param("start") int start, @Param("end") int end);
	int getItemCount();

	//주문관리
	List<OrderDTO> getOrder(@Param("start") int start, @Param("end") int end, @Param("order_no") int order_no);
	int getOrderCount();

	//주문취소상품
	List<OrderCancelDTO> getOrderCancel(OrderCancelDTO ocdto);

	int OrderCancelUpdate(OrderCancelDTO ocdto);

	void OrderCancelDelete(OrderCancelDTO ocdto);
	
	//MD추천상품 
	List<MdItemDTO> getMdItem(MdItemDTO midto);

	void MdItemInsert(MdItemDTO midto);

	int MdItemSelect(@Param("item_no") String item_no);
	
	int MdItemDelete(MdItemDTO midto);

	List<PayMoneyDTO> getPayMoney(PayMoneyDTO pmdto);

	int orderCancelStatus(OrderCancelDTO ocdto);

}


	

