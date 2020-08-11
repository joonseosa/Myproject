package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderCancelDTO {
	private int order_no;   //주문번호
	private String cancel_recipt_date;	//취소접수일자
	private String cancel_complete_date;//취소완료일자 	
	private int admin_approval_or_not;   //관리자 승인여부
	private String cancel_reason;//취소사유 	
	private String detail_reason;//상세사유 	
	private int cancel_quantity; //수량 
	
}
