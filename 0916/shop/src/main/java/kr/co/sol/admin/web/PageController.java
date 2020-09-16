package kr.co.sol.admin.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.PageDTO;
import kr.co.sol.admin.service.AdminService;
import kr.co.sol.admin.service.ItemService;
@Controller
public class PageController {
	@Autowired
	AdminService adminService;

	@Autowired
	ItemService itemService;
	
	
	}
	
	
	
	
	
