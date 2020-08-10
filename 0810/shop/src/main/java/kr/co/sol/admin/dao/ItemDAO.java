package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.co.sol.admin.dto.ItemDTO;
@Mapper
public interface ItemDAO {
		List<ItemDTO> getItem(ItemDTO idto);
		int insertProduct(ItemDTO idto);
}
