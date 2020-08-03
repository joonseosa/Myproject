package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.QnaDTO;

@Mapper
public interface AdminDAO {
	String logon(AdminDTO adto);

	List<QnaDTO> getQna();
}
