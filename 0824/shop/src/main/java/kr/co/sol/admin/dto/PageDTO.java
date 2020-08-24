package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString

public class PageDTO {
	//현재 페이지
	int presentPage;
	
	//페이지당 라인수
	int linePerPage=5;
	
	//전체레코드수
	int allCount;
	
	//전체페이지수
	int allPage;
	
	//페이지블럭(하나의 화면에  나오는 페이지의 수)
	int pageBlockPerNumber=7;
	
	// 현재 블럭 
	int presentPageBlock;
	
	//블럭에서 시작 페이지
	int startPage;
	
	//블럭에서 마지막 페이지 
	int endPage;
	
	
}
