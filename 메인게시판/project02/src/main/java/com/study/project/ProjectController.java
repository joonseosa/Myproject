package com.study.project;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

	@Resource(name = "service")
	private ProjectService projectService;
	
	
	@RequestMapping("login")
	public String login(){
				
		return "/login";
	}
	
	//로그인 오류처리 page  , 오류가 발생하면 login2.jsp 로 이동하게됨 
	@RequestMapping("login2")
	public String login2() {
		
		return "login2";
	}
	
	
	@RequestMapping("loginCheck")
	public String loginCheck(@RequestParam String memId,@RequestParam String memPw,Model model
							,HttpSession session,HttpServletResponse response)throws IOException {
		
	
		
		Map<String, Object> memInfo =projectService.loginCheck(memId);
		
		
		if(memInfo == null || memInfo.isEmpty()) {
			// 아이디 입력 오류시
			model.addAttribute("loginChk", "errorId");
			return "/login";
		}else if(!memPw.equals(memInfo.get("memPass").toString())) {
			//비번 입력 오류시   비번이 같지 않다면 ! 
			model.addAttribute("loginChk", "errorPw");
			return "/login";
		}else {
			//로그인성공 , 세션 처리 
			session.setAttribute("memInfo", memInfo);
			return "redirect:list";
		}
		
	}
		
	@RequestMapping("logout")
	 public String logout(HttpSession session) {
		//세션 정보 날려버리기 
		session.invalidate();
		
		return "redirect:login";
	}
	 
	 
	 @RequestMapping("list")
	 public String list(@RequestParam Map<String, Object> map, Model model,HttpSession session) {
		 	Map<String, Object> memInfo = (Map<String, Object>)session.getAttribute("memInfo");
		 	if(memInfo != null) {
		 	
		 	String memId = memInfo.get("memId").toString();
		 	map.put("memId", memId);
		 	
		 
		 	
		 	//mem rank 설정
		 	String memRank = memInfo.get("memRank").toString();
		 	
		 	//map에  memRank
		 	map.put("memRank", memRank);
		 	
		 List<Map<String, Object>> list = projectService.list(map); 
		 model.addAttribute("list",list);
		 model.addAttribute("searchList",map);
		 return "/list";
		 	}else {
		 
		 		return "redirect:login2";
		 	}
		 
		 
		 
	 }
	 
	 @RequestMapping("searchList")
	 public String searchList(@RequestParam Map<String, Object> map,Model model,HttpSession session) {
		 Map<String, Object> memInfo = (Map<String, Object>)session.getAttribute("memInfo");
		 if(memInfo != null) {
		 String memId = memInfo.get("memId").toString();
		 	

		 	map.put("memId", memId);
		 	//mem rank 설정
		 	String memRank = memInfo.get("memRank").toString();
		 	
		 	
		 	
		 	//map에  memRank
		 	map.put("memRank", memRank);
		 	
		 	
		 List<Map<String, Object>> list = projectService.list(map); 
		 model.addAttribute("list",list);
		 
		 return "/searchList";
		 }else {
			 return "redirect:login2";
		 }
	 }
	 
	 
	 @RequestMapping("write")
	 public String write(@RequestParam Map<String, Object>map,Model model,HttpSession session) {
		 Map<String, Object> memInfo = (Map<String, Object>)session.getAttribute("memInfo");
		
		 if(memInfo != null) {
		 int seq = projectService.seq();
		  
		  model.addAttribute("seq", seq);
		 
		  model.addAttribute("ChkCond", "add");
		
		 return "/write";
		 }else {
			 return "redirect:login2";
		 }
	 }
	
	@RequestMapping("insert")
	public String insert(@RequestParam Map<String, Object> map, HttpSession session) {
		Map<String, Object> memInfo = (Map<String, Object>)session.getAttribute("memInfo");

		
		if(memInfo != null) {
		int insert = projectService.insert(map);	
		 int hisInsert = projectService.hisInsert(map);
		 
		return "redirect:list";
		
		}else {
			return "redirect:login2";
		}
		}
	
	@RequestMapping("detail")
	public String detail(@RequestParam int seq,Model model,HttpSession session) {
			Map<String, Object> map = projectService.detail(seq);
			List<Map<String, Object>> hisList = projectService.hisList(seq);
			
			model.addAttribute("map",map);
			model.addAttribute("hisList", hisList);
			//detail에서  결재상태체크  
			
			
			// detail에서 mode if~else 문
			//detail 66행~ 78행 
			//detail이 수정되는 상황 
			model.addAttribute("ChkCond", "Chk");
		return "/detail";
		}
	
	@RequestMapping("detailUpdate")
	public String detailUpdate(@RequestParam Map<String, Object> map,@RequestParam int seq,Model model) {
		int update = projectService.detailUpdate(map);
		
		
		return "redirect:list";	
	}		
			
	@RequestMapping("detailInsert")
	public String detailInsert(@RequestParam Map<String, Object> map, HttpSession session ) {
		Map<String, Object> memInfo = (Map<String, Object>)session.getAttribute("memInfo");
		if(memInfo == null) {
			return "redirect:login2";
		}
		int seq = projectService.dataChk(map);
		
		map.put("memInfo", memInfo);
		
		String rank = memInfo.get("memRank").toString();
		String aChk = "Y";
		if((!"tmp".equals(map.get("appStatus").toString())) && ("ga".equals(rank) || "ba".equals(rank))){
			map.put("appChk", aChk);
		}
		
		if(seq == 0) {
			projectService.insert(map);
		}else {
			projectService.detailUpdate(map);
		}
			projectService.hisInsert(map);
		
		return "redirect:list";
	
	}
	
	
}
