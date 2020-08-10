package kr.co.sol.admin.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dao.ItemDAO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemDAO itemDAO;
	
	@Override
	public List<ItemDTO> getItem(ItemDTO idto){
		return itemDAO.getItem(idto);
	}
	
// 썸네일 사진 등록 및 지정된 경로에 저장  
	@Override	
	public int insertProduct(ItemDTO idto, MultipartFile File) {
		String sourceFileName = File.getOriginalFilename();
		 File destinationFile; 
		 if (sourceFileName == null || 
				 sourceFileName.length()==0) { 
			 idto.setItem_thumbnail("C:\\study\\thumbnail\\"+idto.getItem_thumbnail());
		   } else {
			   idto.setItem_thumbnail(sourceFileName);
			 //파일명 Random처리(다른 이름으로)
		     destinationFile = new File("C:\\study\\thumbnail\\"+sourceFileName); 	
		    System.err.println("destinationFile.getParentFile()"+destinationFile.getParentFile());
		     destinationFile.getParentFile().mkdirs(); 
		     try {
					File.transferTo(destinationFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
				 	e.printStackTrace();
			 }
		   } 
		 return itemDAO.insertProduct(idto);
	}
		
	}

	
	




