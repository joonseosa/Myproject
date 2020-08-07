package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sol.admin.dao.ItemDAO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.service.ItemService;

public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemDAO itemDAO;
	
	@Override
	public List<ItemDTO> getItem(){
		return itemDAO.getItem();
	}
}
