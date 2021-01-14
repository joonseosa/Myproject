package com.study.project;

import java.util.List;
import java.util.Map;

public interface ProjectDao {

	Map<String, Object> loginCheck(String memId);

	List<Map<String, Object>> list(Map<String, Object> map);

	int seq();

	int insert(Map<String, Object> map);

	int hisInsert(Map<String, Object> map);

	Map<String, Object> detail(int seq);

	List<Map<String, Object>> hisList(int seq);

	int detailUpdate(Map<String, Object> map);

	int dataChk(Map<String, Object> map);






}
