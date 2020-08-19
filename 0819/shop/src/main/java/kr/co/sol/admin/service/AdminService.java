package kr.co.sol.admin.service;

import java.util.HashMap;
import java.util.List;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.PageDTO;
import kr.co.sol.admin.dto.QnaDTO;

public interface AdminService {
   String logon(AdminDTO adto);

   List<QnaDTO> getQna();

HashMap<String, Object> getMember(PageDTO pdto);

HashMap<String, Object> getItem(PageDTO pdto);

List<OrderDTO> getOrder();

List<OrderCancelDTO> getOrderCancel();
}
