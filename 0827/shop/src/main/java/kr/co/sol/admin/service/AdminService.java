package kr.co.sol.admin.service;

import java.util.HashMap;
import java.util.List;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.PageDTO;
import kr.co.sol.admin.dto.ItemInquiryDTO;

public interface AdminService {
   String logon(AdminDTO adto);

   //List<ItemInquiryDTO> getItemInquirys(ItemInquiryDTO iqdto);
   HashMap<String, Object> getItemInquirys(PageDTO pdto);   //상품문의 페이징 처리 
   int ItemInquiryDelete(ItemInquiryDTO iqdto);
   
   
   
HashMap<String, Object> getMember(PageDTO pdto);

HashMap<String, Object> getItem(PageDTO pdto);

HashMap<String, Object> getOrder(PageDTO pdto, int order_no);

List<OrderCancelDTO> getOrderCancel(OrderCancelDTO ocdto);

ItemInquiryDTO getItemInquiry(ItemInquiryDTO iqdto);

void ItemInquiryWriteProc(ItemInquiryDTO iqdto);

void OrderCancelUpdate(OrderCancelDTO ocdto);  // 주문취소상품  update 

void OrderCancelDelete(OrderCancelDTO ocdto);




}
