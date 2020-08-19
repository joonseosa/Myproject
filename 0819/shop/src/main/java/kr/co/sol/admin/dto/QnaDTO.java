package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaDTO {
	private int qna_no;  //QnA 번호
	private String qna_TITLE;  //QnA 제목
	private String qna_EMAIL;  //QnA 이메일
	private String qna_MESSAGE;  //QnA 문자메세지
	private String qna_CONTENT;  //QnA  내용
	private int  qna_SECRET;     //비밀글 여부 
	private int  qna_ref;     //참조 
	private int  question_no;     //질문번호 
	private int  order_no;        //주문번호    
	private String qna_reg_date;     //생성일
	private String mem_id;   //작성자 
}
