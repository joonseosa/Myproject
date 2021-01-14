package com.study.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface BoardService {

	List<Map<String, Object>> list(Map<String, Object> map);

	int insert(Map<String, Object> map);

	Map<String, Object> detail(int seq);

	int viewCnt(int seq);

	int update(Map<String, Object> map);

	int delete(List<Integer> list);

	Map<String, Object> page(Map<String, Object> map);

	//페이징 처리 
	int pageCnt(Map<String, Object> map);

	List<Map<String, Object>> milist(Map<String, Object> searchMap);


    
	

	





	



}
