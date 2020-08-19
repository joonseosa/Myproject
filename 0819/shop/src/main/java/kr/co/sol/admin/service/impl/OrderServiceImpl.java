package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sol.admin.dao.OrderDAO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.service.OrderService;

public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public List<OrderDTO> getOrder(){
		return orderDAO.getOrder();
	}
}


