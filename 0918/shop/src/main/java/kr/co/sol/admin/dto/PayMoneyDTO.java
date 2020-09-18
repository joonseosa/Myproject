package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayMoneyDTO {
    
	private String order_date;  //주문날짜
	private int order_money;    //결제금액
	
}
