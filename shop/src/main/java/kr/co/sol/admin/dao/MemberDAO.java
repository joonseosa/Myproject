package kr.co.sol.admin.dao;

import java.util.List;

import kr.co.sol.admin.dto.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> getMember();
}
