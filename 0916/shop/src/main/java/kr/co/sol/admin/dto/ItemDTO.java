package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemDTO {
	private int item_no; //상품번호
	private String item_name; //상품명
	private String item_descripttion; //상품설명
	private int item_first_price; //상품원가
	private int item_discount; //할인가격
	private String item_thumbnail; //상품 썸네일
	private int item_sales_rate; //판매량
	private int item_stock; //재고
	private int category_no; //카테고리번호
	private String reg_date; // 등록일자
	private int option_be_or_not;
}
