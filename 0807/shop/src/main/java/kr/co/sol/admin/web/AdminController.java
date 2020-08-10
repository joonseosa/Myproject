package kr.co.sol.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.QnaDTO;
import kr.co.sol.admin.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
//logger.
	@RequestMapping("/")
	public String adminIndex(HttpServletRequest request, HttpServletResponse response, AdminDTO adto) {
		return "admin/Index";
	}
	
	@RequestMapping("/login")
	public String adminLogin(HttpServletRequest request, HttpServletResponse response, AdminDTO adto) {
		return "admin/Login";
	}
	
//	@RequestMapping("/admin/index")
//	public String admindex(HttpServletRequest request,
//			  HttpServletResponse response,
//			  AdminDTO adto) {
//		return "admin/Index";
//	}
	
	@RequestMapping("/adloginProc")
	public String adloginProc(HttpServletRequest request, HttpServletResponse response, AdminDTO adto) {
		System.out.println("로그인확인하기 : "+adto.toString());
		//받아온 id와 password를 갖기고 로그인 처리하기
	   String adminIdKey = adminService.logon(adto);
		//세션에저장하기
	   HttpSession session = request.getSession();
	   session.setAttribute("adminIdKey", adminIdKey);
		return "admin/Index";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("adminIdKey");
		return"admin/Index";
	}

	@RequestMapping("/QnAList")
	public String QnaList(HttpServletRequest request, HttpServletResponse response,QnaDTO qnaDTO,Model model ) {
		List<QnaDTO> qnaList = adminService.getQna();
		model.addAttribute("qnaList", qnaList);
		return "admin/Qna";
	}
	
	@RequestMapping("/MemberMgr")
	public String MemberList(HttpServletRequest request, HttpServletResponse response,MemberDTO memberDTO,Model model ) {
		List<MemberDTO> memberList = adminService.getMember();
		model.addAttribute("memberList",memberList);
		System.out.println("확인 ㅎ");
		return "admin/MemberMgr";
	}
	
	@RequestMapping("/ProductMgr")
	public String ProductrList(HttpServletRequest request, HttpServletResponse response,ItemDTO itemDTO,Model model ) {
		List<ItemDTO> itemList=adminService.getItem();
		model.addAttribute("itemList", itemList);
		return "admin/ProductMgr";
	}
	
	@RequestMapping("/OrderMgr")
	public String OrderList(HttpServletRequest request, HttpServletResponse response,OrderDTO orderDTO,Model model ) {
		List<OrderDTO> orderList=adminService.getOrder();
		model.addAttribute("orderList",orderList);
		return "admin/OrderMgr";
	}
	
	@RequestMapping("/OrderCancel")
	public String OrderCancelList(HttpServletRequest request, HttpServletResponse response,OrderCancelDTO ordercancelDTO,Model model ) {
		List<OrderCancelDTO> ordercancelList=adminService.getOrderCancel();
		model.addAttribute("ordercancelList",ordercancelList);
		return "admin/OrderCancel";
	}
	
}