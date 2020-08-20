package kr.co.sol.admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dto.OrderDTO;

public interface OrderService {
	List<OrderDTO> getOrder(OrderDTO odto);
	int updateOrder(OrderDTO odto);
}
