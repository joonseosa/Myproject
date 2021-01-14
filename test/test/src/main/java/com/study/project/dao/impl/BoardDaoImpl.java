package com.study.project.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.project.dao.BoardDao;
import com.study.project.vo.PagingVO;

@Repository("dao")
public class BoardDaoImpl implements BoardDao  {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		
		return sqlSession.selectList("mapper.list", map);
	}

	@Override
	public int insert(Map<String, Object> map) {
		return sqlSession.insert("mapper.insert", map);
	}

	@Override
	public Map<String, Object> detail(int seq) {

		return sqlSession.selectOne("mapper.detail", seq);
	}

	@Override
	public int viewCnt(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update("mapper.viewCnt", seq);
	}

	@Override
	public int update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update("mapper.update", map);
	}

	@Override
	public int delete(List<Integer> list) {
		// TODO Auto-generated method stub
		return sqlSession.delete("mapper.delete",list);
	}

	
	//페이징 처리 
	@Override
	public int total(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.pageCnt", map);
	}

	@Override
	public List<Map<String, Object>> milist(Map<String, Object> searchMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.milist",searchMap);
	}



	

	

	

	
	
}
