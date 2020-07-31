package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.admin.dao.AdminDAO;
import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.service.AdminService;
import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.shop.dto.InputItemDTO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDao;
	
	@Override
	public String logon(AdminDTO adto) {
		return adminDao.logon(adto);
	}

	@Override
	public List<MemberDTO> getMembers(MemberDTO mdto) {
		return adminDao.getMembers(mdto);
	}

	@Override
	public List<InputItemDTO> getInput(InputItemDTO idto) {
		return adminDao.getInput(idto);
	}

}

