package kr.co.sol.admin.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.service.OrderMgrService;
import kr.co.sol.shop.dto.OrderDTO;

@Controller
public class OrderMgrController {

  @Autowired
  OrderMgrService  orderMgrService;
  

  @RequestMapping(value="/orderMgr")
  public String oderMgr(HttpServletRequest request,
			  HttpServletResponse response,
			  OrderDTO odto, Model model) {
	    List<OrderDTO> orderList= 
	    		orderMgrService.getOrders(odto);
	    
	    model.addAttribute("orderList", orderList);
	   return "admin/OrderMgr";
	
}
}