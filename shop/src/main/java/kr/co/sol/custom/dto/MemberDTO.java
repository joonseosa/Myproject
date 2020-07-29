package kr.co.sol.custom.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

    private String mem_id    ;
    private String m_passwd  ;
    private String m_name    ;
    private String m_email   ;
    private String m_phone   ;
    private String zipcode   ;
    private String address   ;
    private String address2  ;
    private String m_job     ;
    private String m_roll     ;



}
