package kr.co.sol.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private String mem_id;    //아이디
 	private String mem_password;  //비밀번호 
	private String mem_name;      //이름
	private String mem_address;   //주소
	private String mem_address_detail; //상세주소  
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
