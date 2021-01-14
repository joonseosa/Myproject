package com.study.project.service.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import com.study.project.dao.BoardDao;
import com.study.project.service.BoardService;

//service는  여러 dao를 호출 데이터의 접근,갱신,비즈니스 로직 수행
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name= "dao")
	private BoardDao boardDao;
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.list(map);
	}

	@Override
	public int insert(Map<String, Object> map) {
		return boardDao.insert(map);
		
		
	}

	@Override
	public Map<String, Object> detail(int seq) {
		return boardDao.detail(seq);
	}

	@Override
	public int viewCnt(int seq) {
		// TODO Auto-generated method stub
		return boardDao.viewCnt(seq);
	}

	@Override
	public int update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.update(map);
	}

	@Override
	public int delete(List<Integer> list) {
		// TODO Auto-generated method stub
		return boardDao.delete(list);
	}

	@Override
	public Map<String, Object> page(Map<String, Object> map) {
		
		int PAGE_SCALE=Integer.parseInt(map.get("listSize").toString());
		int BLOCK_SCALE=7;
		int curPage=Integer.parseInt(map.get("pageNo").toString());
		int count =Integer.parseInt(map.get("pageCnt").toString());
		int totPage =(int)Math.ceil(count*1.0/PAGE_SCALE);	 // 전체 페이지 갯수
		int totBlock=(int) Math.ceil(totPage/BLOCK_SCALE); // 전체 페이지 블록 갯수
		int curBlock=(int)Math.ceil((curPage-1) / BLOCK_SCALE)+1;
		 

		 int blockBegin = (curBlock-1)*BLOCK_SCALE+1;// 현재 페이지 블록의 시작번호
		
		 int blockEnd = blockBegin+BLOCK_SCALE-1; // 현재 페이지 블록의 끝번호
		 if(blockEnd > totPage) blockEnd = totPage;
		 
		 int pageBegin = (curPage-1)*PAGE_SCALE+1;// #{start}
		 int pageEnd = (pageBegin+PAGE_SCALE-1); // #{end}
		 
		 int nextPage= (curBlock > totBlock ? (curBlock*BLOCK_SCALE) : (curBlock*BLOCK_SCALE)+1);
		 if(nextPage >= totPage) nextPage = totPage;
		 
		 int prevPage = ((curPage == 1)? 1:(curBlock-1)*BLOCK_SCALE);
		 

	    // WHERE rn BETWEEN #{start} AND #{end}
	    // [이전] blockBegin -> 41 42 43 44 45 46 47 48 49 50 [다음]
	    // [이전] 41 42 43 44 45 46 47 48 49 50 <- blockEnd [다음]
		
	     Map<String, Object> pageMap= new HashMap<String, Object>();
	     pageMap.put("curBlock",curBlock);
	     pageMap.put("blockBegin",blockBegin);
	     pageMap.put("blockEnd",blockEnd);
	     pageMap.put("pageBegin",pageBegin);
	     pageMap.put("pageEnd",pageEnd);
	     pageMap.put("nextPage",nextPage);
	     pageMap.put("prevPage",prevPage);
		pageMap.put("curPage",curPage);
		pageMap.put("PAGE_SCALE",PAGE_SCALE);
		pageMap.put("BLOCK_SCALE",BLOCK_SCALE);
		pageMap.put("count",count);
		pageMap.put("totPage",totPage);
		pageMap.put("totBlock",totBlock);
		
		
		
		return pageMap;
	}

	@Override
	public int pageCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.total(map);
	}

	@Override
	public List<Map<String, Object>> milist(Map<String, Object> searchMap) {
		// TODO Auto-generated method stub
		return boardDao.milist(searchMap);
	}




	
	




	



		
}
