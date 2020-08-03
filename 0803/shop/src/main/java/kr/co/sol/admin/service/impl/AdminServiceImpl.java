package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.admin.dao.AdminDAO;
import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.QnaDTO;
import kr.co.sol.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDao;
	
	@Override
	public String logon(AdminDTO adto) {
		return adminDao.logon(adto);
	}

	@Override
	public List<QnaDTO> getQna() {
		// TODO Auto-generated method stub
		return adminDao.getQna();
	}

}

