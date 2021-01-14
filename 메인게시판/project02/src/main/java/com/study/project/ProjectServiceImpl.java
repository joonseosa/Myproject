package com.study.project;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("service")
public class ProjectServiceImpl implements ProjectService{

	@Resource(name= "dao")
	private ProjectDao projectDao;

	@Override
	public Map<String, Object> loginCheck(String memId) {
		// TODO Auto-generated method stub
		return projectDao.loginCheck(memId);
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return projectDao.list(map);
	}

	@Override
	public int seq() {
		
		return projectDao.seq();
	}

	@Override
	public int insert(Map<String, Object> map) {
		
		
		return projectDao.insert(map);
	}

	@Override
	public int hisInsert(Map<String, Object> map) {
		
		return projectDao.hisInsert(map);
	}

	@Override
	public Map<String, Object> detail(int seq) {
		return projectDao.detail(seq);
	}

	@Override
	public List<Map<String, Object>> hisList(int seq) {
		return projectDao.hisList(seq);
	}

	@Override
	public int detailUpdate(Map<String, Object> map) {

		return projectDao.detailUpdate(map);
	}

	@Override
	public int dataChk(Map<String, Object> map) {
		return projectDao.dataChk(map);
	}





	
	
	

}
