package kr.co.sol.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.QnaDTO;
import kr.co.sol.admin.service.AdminService;
import kr.co.sol.admin.service.ItemService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;

	@Autowired
	ItemService itemService;

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
		System.out.println("로그인확인하기 : " + adto.toString());
		// 받아온 id와 password를 갖기고 로그인 처리하기
		String adminIdKey = adminService.logon(adto);
		// 세션에저장하기
		HttpSession session = request.getSession();
		session.setAttribute("adminIdKey", adminIdKey);
		return "admin/Index";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("adminIdKey");
		return "admin/Index";
	}

	@RequestMapping("/QnAList")
	public String QnaList(HttpServletRequest request, HttpServletResponse response, QnaDTO qnaDTO, Model model) {
		List<QnaDTO> qnaList = adminService.getQna();
		model.addAttribute("qnaList", qnaList);
		return "admin/Qna";
	}

	@RequestMapping("/MemberMgr")
	public String MemberList(HttpServletRequest request, HttpServletResponse response, MemberDTO memberDTO,
			Model model) {
		List<MemberDTO> memberList = adminService.getMember();
		model.addAttribute("memberList", memberList);
		System.out.println("확인 ㅎ");
		return "admin/MemberMgr";
	}
	
	@RequestMapping("/ProductMgr")
	public String ProductrList(HttpServletRequest request, HttpServletResponse response, ItemDTO itemDTO, Model model) {
		List<ItemDTO> itemList = adminService.getItem();
		model.addAttribute("itemList", itemList);
		return "admin/ProductMgr";
	}

	@RequestMapping("/productInsert")
	public String productInsert() {
		return "admin/ProductInsert";
	}

	@RequestMapping("/productMgrProc")
	public String productInsert(HttpServletRequest request, @RequestParam("item_thumbnail2") MultipartFile file, HttpServletResponse response, ItemDTO idto) {
		System.out.println("아이템확인 : " + idto.toString());
		int result = itemService.insertProduct(idto, file);
		return "redirect:ProductMgr";
	}
	@RequestMapping("/productMgrDeleteProc")
	public String productDelete(HttpServletRequest request, ItemDTO idto,HttpServletResponse response) {
		
		
		System.out.println("아이템삭제확인 : " + idto.toString());
		int result = itemService.deleteProduct(idto);
		return "redirect:ProductMgr";
	}

	
	
	
	
	
	@RequestMapping("/productDetail")
	public String productDetail(HttpServletRequest request, HttpServletResponse response, ItemDTO idto, Model model) {
		ItemDTO result = itemService.getItem(idto);
		model.addAttribute("idto",result);
		return "admin/ProductDetail";
	}
	
	//product detail과 productupdate 내용이 같은이유는 같은내용을 불러오기때문에
	//detail 에서 보여지는 정보를 update로 넘어갔을때 그대로 가져와야하기때문에 
	
	@RequestMapping("/productUpdate")
	public String productUpdate(ItemDTO idto,  Model model) {
		ItemDTO  idto2=itemService.getItem(idto);
		model.addAttribute("idto",idto2);
		return "admin/ProductUpdate";
	}
	
	
	@RequestMapping("/productUpdateProc")
	public String productUpdate(HttpServletRequest request, @RequestParam("item_thumbnail2") MultipartFile file,HttpServletResponse response, ItemDTO idto, Model model) {
		//ItemDTO result = itemService.updateProduct(idto,file);
		System.out.println("상품수정확인"+idto.toString());
		int result=itemService.updateProduct(idto, file);
		model.addAttribute("idto",result);
		System.out.println("여기로 오나");
		return "redirect:ProductMgr";
	}
	
	//redirect를 적을 경우에는 해당 requestmapping으로 이동됨, 추가된 데이터가 리스트에 저장되서 보여짐
	//redirect 를 쓰지않고 return " jsp경로  "를 사용할 경우에는 데이터 없이 jsp로 이동하게됨. 추가,수정된 데이터 리스트없이 출력됨 
	
	@RequestMapping("/OrderMgr")
	public String OrderList(HttpServletRequest request, HttpServletResponse response, OrderDTO orderDTO, Model model) {
		List<OrderDTO> orderList = adminService.getOrder();
		model.addAttribute("orderList", orderList);
		return "admin/OrderMgr";
	}

	@RequestMapping("/OrderCancel")
	public String OrderCancelList(HttpServletRequest request, HttpServletResponse response,
			OrderCancelDTO ordercancelDTO, Model model) {
		List<OrderCancelDTO> ordercancelList = adminService.getOrderCancel();
		model.addAttribute("ordercancelList", ordercancelList);
		return "admin/OrderCancel";
	}

}
