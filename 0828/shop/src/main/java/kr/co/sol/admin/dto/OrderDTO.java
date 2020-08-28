package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class OrderDTO {
	//order_item 
	private int orders_item_money;
	private int orders_item_cnt;
	private String option_name;
	private int item_no;
	private int order_no;
	
	//order_list
	private String order_date;
	private String order_status;
	private String order_pay_option;
	private int order_money;
	private String order_tracking_num;
	private String order_to_name;
	private String order_to_phone;
	private int order_zipcode;
	private String order_to_address;
	private String order_address_detail;
	private String order_request;
	private String mem_id;
	private String order_to_email;
	
	
	//item
	private String item_name;
	private String item_descripttion;
	private int item_first_price;
	private int item_discount;
	private String item_thumbnail;
	private int item_sales_rate;
	private int item_stock;
	private int category_no;
	private String reg_date;
	private int option_be_or_not;
	
	//Member
 	private String mem_password;  //비밀번호 
	private String mem_name;      //이름
	private String mem_address;   //주소
	private String mem_zipcode;       //우퍈번호 
	private String mem_mobile; //휴대폰번호  
	private String mem_email; //이메일 
	private int mem_email_reception; //이메일 수신여부
	private String mem_reg_date;   //회원가입일
	private int role; //관리자 계정
	private String mem_last_date; //마지막 로그인
	private String gender; //성별
	private String birth_date; //마지막 로그인
	
	
	
}

	

