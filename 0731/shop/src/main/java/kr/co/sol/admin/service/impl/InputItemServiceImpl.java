package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sol.admin.dao.InputItemDAO;
import kr.co.sol.admin.service.InputItemService;
import kr.co.sol.shop.dto.InputItemDTO;

public class InputItemServiceImpl implements InputItemService {

	@Autowired
	InputItemDAO inputitemDao;
	
	@Override
	public List<InputItemDTO> getInput(InputItemDTO idto) {
		return inputitemDao.getInput(idto);
	}

}
