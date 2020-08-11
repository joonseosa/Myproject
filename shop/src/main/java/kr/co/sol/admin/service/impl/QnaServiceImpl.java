package kr.co.sol.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sol.admin.dao.QnaDAO;
import kr.co.sol.admin.dto.QnaDTO;
import kr.co.sol.admin.service.QnaService;

public class QnaServiceImpl implements QnaService {
	
	@Autowired
	QnaDAO qnaDAO;
	
	
	@Override
	public List<QnaDTO> getQna() {
		return qnaDAO.getQna();
	}

}
