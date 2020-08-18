package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.admin.dao.MemberDAO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> getMember(){
		return memberDAO.getMember();
	}

	@Override
	public int memberDelete(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return memberDAO.memberDelete(memberDTO);
	}

}
