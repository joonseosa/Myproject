package kr.co.sol.admin.dao;

import java.util.List;

import kr.co.sol.admin.dto.OrderCancelDTO;

public interface OrderCancelDAO {
	List<OrderCancelDTO> getOrderCancel();
}
