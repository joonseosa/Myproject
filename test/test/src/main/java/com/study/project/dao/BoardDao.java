package com.study.project.dao;

import java.util.List;
import java.util.Map;

import com.study.project.vo.PagingVO;


public interface BoardDao {

	List<Map<String, Object>> list(Map<String, Object> map);

	int insert(Map<String, Object> map);

	Map<String, Object> detail(int seq);

	int viewCnt(int seq);

	int update(Map<String, Object> map);

	int delete(List<Integer> list);

	//페이징 처리 
	int total(Map<String, Object> map);

	List<Map<String, Object>> milist(Map<String, Object> searchMap);

	






	 
}
