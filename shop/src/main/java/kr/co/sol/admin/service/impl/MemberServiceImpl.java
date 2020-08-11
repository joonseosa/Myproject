package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sol.admin.dao.MemberDAO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.service.MemberService;

public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> getMember(){
		return memberDAO.getMember();
	}
}
