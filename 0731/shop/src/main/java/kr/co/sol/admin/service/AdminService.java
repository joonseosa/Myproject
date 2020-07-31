package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.shop.dto.InputItemDTO;

public interface AdminService {
   String logon(AdminDTO adto);
   List<MemberDTO> getMembers(MemberDTO mdto);
	List<InputItemDTO> getInput(InputItemDTO idto);

}
