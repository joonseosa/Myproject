package kr.co.sol.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.sol.admin.dto.MemberDTO;

public interface MemberService {
	List<MemberDTO> getMember();

	int memberDelete(MemberDTO memberDTO);
}
