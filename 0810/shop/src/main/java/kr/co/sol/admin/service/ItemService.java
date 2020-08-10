package kr.co.sol.admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dto.ItemDTO;

public interface ItemService {
	List<ItemDTO> getItem(ItemDTO idto);
	int insertProduct(ItemDTO idto, MultipartFile File);
}
