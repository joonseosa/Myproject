package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.admin.dto.OrderCancelDTO;

public interface OrderCancelService {
	List<OrderCancelDTO> getOrderCancel(OrderCancelDTO ocdto);

}
