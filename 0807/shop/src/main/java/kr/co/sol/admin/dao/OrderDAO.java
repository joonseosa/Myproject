package kr.co.sol.admin.dao;

import java.util.List;

import kr.co.sol.admin.dto.OrderDTO;

public interface OrderDAO {
	List<OrderDTO> getOrder();
}
