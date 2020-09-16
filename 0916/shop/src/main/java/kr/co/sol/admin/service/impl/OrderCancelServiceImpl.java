package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sol.admin.dao.OrderCancelDAO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.service.OrderCancelService;

public class OrderCancelServiceImpl implements OrderCancelService {
	@Autowired
	OrderCancelDAO ordercancelDAO;
	
	@Override
	public List<OrderCancelDTO> getOrderCancel(OrderCancelDTO ocdto) {
		return ordercancelDAO.getOrderCancel(ocdto) ;
	}

}
