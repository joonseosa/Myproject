package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.QnaDTO;

public interface AdminService {
   String logon(AdminDTO adto);

   List<QnaDTO> getQna();

List<MemberDTO> getMember();

List<ItemDTO> getItem();

List<OrderDTO> getOrder();

List<OrderCancelDTO> getOrderCancel();	

}
