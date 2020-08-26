package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dao.OrderDAO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public List<OrderDTO> getOrder(OrderDTO odto){
		return orderDAO.getOrder(odto);
	}

	@Override
	public int updateOrder(OrderDTO odto) {
		return orderDAO.updateOrder(odto);
	}

	@Override
	public int deleteOrder(OrderDTO odto) {
		return orderDAO.deleteOrder(odto);
	}

	
}


