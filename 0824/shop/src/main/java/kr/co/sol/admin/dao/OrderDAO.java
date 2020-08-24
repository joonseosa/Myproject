package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.admin.dto.OrderDTO;
@Mapper
public interface OrderDAO {
	List<OrderDTO> getOrder(OrderDTO odto);
	int updateOrder(OrderDTO odto);
	int deleteOrder(OrderDTO odto);

}
