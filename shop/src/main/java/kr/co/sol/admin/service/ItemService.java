package kr.co.sol.admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dto.ItemDTO;

public interface ItemService {
	List<ItemDTO> getItems(ItemDTO idto);
	int insertProduct(ItemDTO idto, MultipartFile File);
	int updateProduct(ItemDTO idto,MultipartFile File);
	ItemDTO getItem(ItemDTO idto);
}
