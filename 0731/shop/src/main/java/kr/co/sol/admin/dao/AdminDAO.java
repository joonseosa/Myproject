package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.shop.dto.InputItemDTO;

@Mapper
public interface AdminDAO {
	String logon(AdminDTO adto);
	List<MemberDTO> getMembers(MemberDTO mdto);
	List<InputItemDTO> getInput(InputItemDTO idto);
}
