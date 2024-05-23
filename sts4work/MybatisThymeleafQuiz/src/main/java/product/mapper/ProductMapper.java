package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import product.dto.ProductDto;

@Mapper
public interface ProductMapper {

	public int getTotalCount();
	public void insertProduct(ProductDto dto);
	public List<ProductDto> getAllDatas();
	public ProductDto getOneData(int num);
}
