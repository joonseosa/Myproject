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

   List<ItemInquiryDTO> getItemInquiry(ItemInquiryDTO iqdto);

HashMap<String, Object> getMember(PageDTO pdto);

HashMap<String, Object> getItem(PageDTO pdto);

HashMap<String, Object> getOrder(PageDTO pdto, int order_no);

List<OrderCancelDTO> getOrderCancel();



}
