package kr.co.sol.admin.dao;

import java.util.List;

import kr.co.sol.shop.dto.InputItemDTO;

public interface InputItemDAO {
	//여러개를 넣을때 
	List<InputItemDTO> getInput(InputItemDTO idto);
	
	
}
