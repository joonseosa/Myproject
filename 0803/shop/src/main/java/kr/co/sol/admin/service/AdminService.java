package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.QnaDTO;

public interface AdminService {
   String logon(AdminDTO adto);

   List<QnaDTO> getQna();	

}
