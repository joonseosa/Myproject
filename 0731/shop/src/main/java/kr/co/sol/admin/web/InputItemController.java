package kr.co.sol.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.service.AdminService;
import kr.co.sol.shop.dto.InputItemDTO;

@Controller
public class InputItemController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping("/admin/inputitem")
	public String inputitem(HttpServletRequest request,HttpServletResponse response,
			InputItemDTO idto,Model model) {
		System.out.println("??");
//		List<InputItemDTO> inputitem=adminService.getInput(idto);
		return"admin/InputItem";
	}
	
	
	
}
