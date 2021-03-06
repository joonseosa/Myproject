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
	public List<ItemDTO> getItems(ItemDTO idto){
		return itemDAO.getItems(idto);
	}
	
// 썸네일 사진 등록 및 지정된 경로에 저장  
	@Override	
	public int insertProduct(ItemDTO idto, MultipartFile File) {
		String sourceFileName = File.getOriginalFilename();
		 File destinationFile; 
		 if (sourceFileName == null || 
				 sourceFileName.length()==0) { 
			 idto.setItem_thumbnail("ready.jpg");
		   } else {
			   idto.setItem_thumbnail(sourceFileName);
			 //파일명 Random처리(다른 이름으로)
		     destinationFile = new File("C:\\study\\spring_workspace\\shop\\src\\main\\webapp\\img\\thumbnail\\"+sourceFileName); 	
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

	@Override
	public ItemDTO getItem(ItemDTO idto) {
		return itemDAO.getItem(idto);
	}

	
		
	
	@Override	
	public int updateProduct(ItemDTO idto, MultipartFile file) {
		String sourceFileName = file.getOriginalFilename();
		 File destinationFile; 
System.out.println("dddddddddddddddddddddd");
		 if (sourceFileName == null || 
				 sourceFileName.length()==0) { 
			 idto.setItem_thumbnail("ready.jpg");
		   } else {
			   idto.setItem_thumbnail(sourceFileName);
			 //파일명 Random처리(다른 이름으로)
		     destinationFile = new File("C:\\study\\spring_workspace\\shop\\src\\main\\webapp\\img\\thumbnail\\"+sourceFileName); 	
		    System.err.println("destinationFile.getParentFile()"+destinationFile.getParentFile());
		     destinationFile.getParentFile().mkdirs(); 
		     try {
					file.transferTo(destinationFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
				 	e.printStackTrace();
			 }
		   } 
		 return itemDAO.updateProduct(idto);
	}

	@Override
	public int deleteProduct(ItemDTO idto) {
		return itemDAO.deleteProduct(idto);
	}




}

	
	




