package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.co.sol.admin.dto.ItemDTO;
@Mapper
public interface ItemDAO {
		List<ItemDTO> getItems(ItemDTO idto);
		int insertProduct(ItemDTO idto);
		int updateProduct(ItemDTO idto);
		int deleteProduct(ItemDTO idto);
		ItemDTO getItem(ItemDTO idto);
}
