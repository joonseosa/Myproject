package kr.co.sol.admin.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.PageDTO;
import kr.co.sol.admin.dto.PayMoneyDTO;
import kr.co.sol.admin.dto.ItemInquiryDTO;
import kr.co.sol.admin.dto.MdItemDTO;
import kr.co.sol.admin.service.AdminService;
import kr.co.sol.admin.service.ItemService;
import kr.co.sol.admin.service.OrderService;
import kr.co.sol.admin.service.ItemInquiryService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;

	@Autowired
	ItemService itemService;

	@Autowired
	OrderService orderService;
	
	@Autowired
	ItemInquiryService reviewService;
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

	
	//회원관리 	
	@RequestMapping("/MemberMgr")
	public String MemberList(HttpServletRequest request, HttpServletResponse response, MemberDTO memberDTO,Model model,PageDTO pdto) {
		HashMap<String, Object> hash = adminService.getMember(pdto);
		model.addAttribute("memberList",(List<MemberDTO>) hash.get("list"));
		model.addAttribute("pdto", (PageDTO) hash.get("pdto"));
		
		System.out.println("확인 ㅎ");
		return "admin/MemberMgr";
	}
	

	
	
	//상품문의
	@RequestMapping("/ItemInquiry")
	public String QnaList(HttpServletRequest request, HttpServletResponse response, ItemInquiryDTO iqdto, Model model,PageDTO pdto) {
		HashMap<String, Object> hash = adminService.getItemInquirys(pdto);
		model.addAttribute("iteminquiryList", (List<ItemInquiryDTO>) hash.get("list"));
	      model.addAttribute("pdto", (PageDTO) hash.get("pdto"));
		return "admin/ItemInquiry";
	}
	
	@RequestMapping("/ItemInquiryDetail")
	public String ItemInquiryDetail(HttpServletRequest request, HttpServletResponse response, ItemInquiryDTO iqdto, Model model) {
		ItemInquiryDTO result =  adminService.getItemInquiry(iqdto);
		model.addAttribute("iqdto",result);
		return "admin/ItemInquiryDetail";
	}
	
	@RequestMapping("/ItemInquiryWrite")
	public String ItemInquiryWrite(HttpServletRequest request, HttpServletResponse response, ItemInquiryDTO iqdto, Model model) {
		model.addAttribute("item_no",request.getParameter("item_no"));
		model.addAttribute("inq_no",request.getParameter("inq_no"));
		return "admin/ItemInquiryWrite";
	}
	
	@RequestMapping("/ItemInquiryWriteProc")
	public String ItemInquiryWriteProc(HttpServletRequest request, HttpServletResponse response, ItemInquiryDTO iqdto, Model model) {
		String mem_id="audwns";
		if(mem_id==null||mem_id.equals("")||mem_id.length()==0) {
			return "admin/ItemInquiryWrite";
		}else {
			iqdto.setMem_id(mem_id);
			iqdto.setInq_content(request.getParameter("content"));
			adminService.ItemInquiryWriteProc(iqdto);
		}
		
		return "redirect:ItemInquiry";
	}

	@RequestMapping("ItemInquiryDelete")
	public String ItemInquiryDelete(HttpServletRequest request, HttpServletResponse response, ItemInquiryDTO iqdto, Model model) {
		int result=adminService.ItemInquiryDelete(iqdto);
		return "redirect:ItemInquiry";
	}
	
	
	

	
	
	//상품관리
	
	@RequestMapping("/ProductMgr")
	public String ProductList(HttpServletRequest request, HttpServletResponse response, ItemDTO itemDTO,PageDTO pdto, Model model) {
		HashMap<String, Object> hash = adminService.getItem(pdto);
		 model.addAttribute("itemList", (List<ItemDTO>) hash.get("list"));
	      model.addAttribute("pdto", (PageDTO) hash.get("pdto"));
	      
		return "admin/ProductMgr";
		
//		List<ItemDTO> itemList = adminService.getItem();
//		model.addAttribute("itemList", itemList);
//		return "admin/ProductMgr";
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

	
	//주문관리
	@RequestMapping("/OrderMgr")
	public String OrderList(HttpServletRequest request, HttpServletResponse response, OrderDTO odto,PageDTO pdto,Model model) {
		int order_no = odto.getOrder_no();
		HashMap<String, Object> hash = adminService.getOrder(pdto, order_no);

		 model.addAttribute("orderList", (List<OrderDTO>) hash.get("list"));
	      model.addAttribute("pdto", (PageDTO) hash.get("pdto"));
	      
		return "admin/OrderMgr";
	}

	@RequestMapping("/OrderDetail")
	public String orderDetail(HttpServletRequest request, HttpServletResponse response,OrderDTO odto,PageDTO pdto, Model model) {
		System.out.println("===>"+odto.getOrder_no());
		int order_no = odto.getOrder_no();
		List<OrderDTO> result = (List<OrderDTO>) orderService.getOrder(odto);
		model.addAttribute("odto",result.get(0));
		return "admin/OrderDetail";
	}
	
	@RequestMapping(value="/adminOrderProc")
	   public String orderProc(HttpServletRequest request,
			   OrderDTO odto, Model model) {
		   HttpSession session = request.getSession();
		   MemberDTO adminDto= 
				   (MemberDTO) session.getAttribute("adminDto");
		   //수정이냐 삭제냐.. 구분
		    String flag = request.getParameter("flag");
		   String url = null; 
		   String msg = null;
		   int r=0;
		   System.out.println("======플래그확인"+flag);
		   if("U".equals(flag)) {
		   //수정일 때
		    r =orderService.updateOrder(odto);
		   } else if("D".equals(flag)) {
			   //삭제일 때
		    r = orderService.deleteOrder(odto);  
		   }
		   if(r>0) {
	          msg="수정 또는 삭제 완료";
			  url  = "/orderMgr";
		   }else {
			  msg="수정 또는 삭제실패";
			  url  = "/orderMgr";
		   }
		   session.setAttribute("adminDto", adminDto);
		   model.addAttribute("msg", msg);
		   model.addAttribute("url", url);
		   return "redirect:OrderMgr";
	   }

	
	
	//주문취소상품  
	@RequestMapping("/OrderCancel")
	public String OrderCancelList(HttpServletRequest request, HttpServletResponse response,
			OrderCancelDTO ocdto, Model model) {
		List<OrderCancelDTO> ordercancelList = adminService.getOrderCancel(ocdto);
		System.out.println(ordercancelList);
		model.addAttribute("ordercancelList", ordercancelList);
		return "admin/OrderCancel";
	}
	
	@RequestMapping("/OrderCancelDetail")
	public String OrderCancelDetail(HttpServletRequest request, HttpServletResponse response,OrderCancelDTO ocdto,PageDTO pdto, Model model) {
		System.out.println("===>"+ocdto.getOrder_no());
		int order_no = ocdto.getOrder_no();
		List<OrderCancelDTO> result = (List<OrderCancelDTO>) adminService.getOrderCancel(ocdto);
		model.addAttribute("ocdto",result.get(0));
		return "admin/OrderCancelDetail";
	}
	
	
	
	@RequestMapping("/OrderCancelUpdate")
	public String OrderCancelUpdate(HttpServletRequest request, HttpServletResponse response,OrderCancelDTO ocdto,  Model model) {
		//ItemDTO  idto2=itemService.getItem(idto);
		adminService.OrderCancelUpdate(ocdto);	
		return "redirect:OrderCancel";
	}
	@RequestMapping("/OrderCancelDelete")
	public String OrderCancelDelete(HttpServletRequest request, HttpServletResponse response,OrderCancelDTO ocdto,  Model model) {
		//ItemDTO  idto2=itemService.getItem(idto);
		adminService.OrderCancelDelete(ocdto);	
		return "redirect:OrderCancel";
	}
	
	@RequestMapping("/OrderProc")
	public String OrderProc(HttpServletRequest request, HttpServletResponse response, OrderDTO odto,PageDTO pdto, Model model) {
		int order_no = odto.getOrder_no();
		List<OrderDTO> orderList = (List<OrderDTO>) adminService.getOrder(pdto, order_no);
		model.addAttribute("orderList", orderList);
		return "redirect:OrderMgr";
	}
	

	//md추천상품 
	@RequestMapping("/MdItem")
	public String MdItem(HttpServletRequest request, HttpServletResponse response, MdItemDTO midto,PageDTO pdto,ItemDTO idto, Model model) {
		List<MdItemDTO> mditemList = adminService.getMdItem(midto);
		model.addAttribute("mditemList",mditemList);
		return "admin/MdItem";
	}
	
	@RequestMapping("/MdItemInsert")
	public String MdItemInsert(HttpServletRequest request, HttpServletResponse response, MdItemDTO midto,PageDTO pdto,ItemDTO idto, Model model) {
		adminService.MdItemInsert(midto);
		return "redirect:MdItem";
	}
	
	@ResponseBody
	@RequestMapping("/itemCheck")
	public int itemCheck(HttpServletRequest request, HttpServletResponse response, MdItemDTO midto,PageDTO pdto,ItemDTO idto, Model model) {
		String item_no = request.getParameter("item_no");
		int num = adminService.MdItemSelect(item_no);
		return num;
	}
	
	@RequestMapping("/MdItemDelete")
	public String Memberdelete(HttpServletRequest request, HttpServletResponse response,String[] checkArr, MdItemDTO midto,
			Model model) {
		int result = 0;
		String item_no=null;
//		for (String i : checkArr) {
//			mem_id = i;
//			memberDTO.setMem_id(mem_id);
//			memberService.memberDelete(memberDTO);
//		}    
//밑에 for 문이랑 같은 내용 임 		
		for(int i=0; i<checkArr.length; i++) {
			item_no = checkArr[i];
			midto.setItem_no(Integer.parseInt(item_no));
			adminService.MdItemDelete(midto);
		}
		return "redirect:MdItem";	
	}
	
	
	//매출조회
		@RequestMapping("/PayMoney")
		public String PayMoney(HttpServletRequest request, HttpServletResponse response,
				PayMoneyDTO pmdto,OrderDTO odto, Model model) {
			List<PayMoneyDTO> paymoneyList = adminService.getPayMoney(pmdto);
			model.addAttribute("paymoneyList",paymoneyList);
			return "admin/PayMoney";
		}
		
		@ResponseBody
		@PostMapping("loginCheck")
		public String loginCheck(String pw, String id,HttpServletRequest request) {
			AdminDTO adto = new AdminDTO();  
			adto.setAdmin_id(id);
			adto.setAdmin_passwd(pw);
			String adminIdKey = adminService.logon(adto);
			
//			System.out.println("adminIdKey : "+adminIdKey);
//			System.out.println("a : "+a);
//			
//			System.out.println(adminIdKey == a);
	
//String 은 객체 클래스 임 ,  String 끼리 비교할때는  equals를 사용해야함 			
// DB에 없는 ID 는 NULL로 들어옴 			
			if(adminIdKey == null) {
				return"";
			}else {
				request.getSession().setAttribute("adminIdKey", adminIdKey);
				System.out.println(adminIdKey);
				return "성공";
			}
			
		}
	
	
	
	
}
