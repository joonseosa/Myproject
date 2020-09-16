package kr.co.sol.admin.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/memberdelete")
	public String Memberdelete(HttpServletRequest request, HttpServletResponse response,String[] checkArr, MemberDTO memberDTO,
			Model model) {
		System.out.println("memberdelete controller");
		int result = 0;
		String mem_id= null;
//		for (String i : checkArr) {
//			mem_id = i;
//			memberDTO.setMem_id(mem_id);
//			memberService.memberDelete(memberDTO);
//		}    
//밑에 for 문이랑 같은 내용 임 		
		for(int i=0; i<checkArr.length; i++) {
			mem_id = checkArr[i];
			memberDTO.setMem_id(mem_id);
			memberService.memberDelete(memberDTO);
		}
		return "redirect:MemberMgr";	
	}
}
