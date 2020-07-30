package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.shop.dto.ProductDTO;


@Mapper
public interface ProductMgrDAO {

	List<ProductDTO> getProducts(ProductDTO pdto);

	int procutMgrDao(ProductDTO pdto);

	int insertProduct(ProductDTO pdto);

	int updateProduct(ProductDTO pdto);

	int deleteProduct(ProductDTO pdto);
}
