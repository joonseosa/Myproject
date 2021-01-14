package com.study.project;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class ProjectDaoImpl implements ProjectDao {

@Autowired
private SqlSessionTemplate sqlSession;

@Override
public Map<String, Object> loginCheck(String memId) {
	return  sqlSession.selectOne("mapper.loginCheck",memId);
}

@Override
public List<Map<String, Object>> list(Map<String, Object> map) {
	return sqlSession.selectList("mapper.list", map);
}

@Override
public int seq() {

	return sqlSession.selectOne("mapper.seq");
}

@Override
public int insert(Map<String, Object> map) {
	
	return sqlSession.insert("mapper.insert", map) ;
}

@Override
public int hisInsert(Map<String, Object> map) {
	return sqlSession.insert("mapper.hisInsert", map);
}

@Override
public Map<String, Object> detail(int seq) {
	return sqlSession.selectOne("mapper.detail",seq);
}

@Override
public List<Map<String, Object>> hisList(int seq) {
	return sqlSession.selectList("mapper.hisList",seq);
}

@Override
public int detailUpdate(Map<String, Object> map) {
	
	return sqlSession.update("mapper.detailUpdate",map);
}

@Override
public int dataChk(Map<String, Object> map) {
	return sqlSession.selectOne("mapper.dataChk", map.get("seq").toString());
}








}
