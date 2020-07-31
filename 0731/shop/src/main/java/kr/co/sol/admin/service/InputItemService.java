package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.shop.dto.InputItemDTO;

public interface InputItemService {
	List<InputItemDTO> getInput(InputItemDTO idto);
	
}
