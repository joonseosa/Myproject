package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemInquiryDTO {
	private int inq_no;  //상품문의번호
	private String inq_title; //상품문의제목
	private String inq_content; //상품문의내용
	private String inq_reg_date; //상품문의생성날짜
	private int inq_ref;  //inq_ref
	private int item_no;  //상품번호
	private String mem_id; //아이디
	private int question_no;  //질문번호
    
	
	
	
}
