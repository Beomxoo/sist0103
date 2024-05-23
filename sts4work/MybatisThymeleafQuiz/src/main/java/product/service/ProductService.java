package product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import product.dto.ProductDto;
import product.mapper.ProductMapper;

@Service
@AllArgsConstructor
public class ProductService {
	
	private final ProductMapper productMapper;
	
	public int getTotalCount()
	{
		return productMapper.getTotalCount();
	}
	
	public void insertProduct(ProductDto dto)
	{
		productMapper.insertProduct(dto);
	}
	
	public List<ProductDto> getAllDatas()
	{
		return productMapper.getAllDatas();
	}
	public ProductDto getOneData(int num)
	{
		return productMapper.getOneData(num);
	}
	
}
