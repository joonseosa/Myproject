package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.admin.dto.OrderCancelDTO;
@Mapper
public interface OrderCancelDAO {
	List<OrderCancelDTO> getOrderCancel(OrderCancelDTO ocdto);
}
