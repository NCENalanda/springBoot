package com.jpa.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpa.api.adaptor.ProductAdapterInterface;
import com.jpa.api.dao.ProductRepository;
import com.jpa.api.dto.CustomSort;
import com.jpa.api.dto.ProductDto;
import com.jpa.api.model.ProductModel;



@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired //(required=true)
    private ProductRepository repoProduct;
	
	@Autowired  //(required=true)
    private ProductAdapterInterface adaptorProduct;
	
	@Override
	public ProductDto addProduct(ProductDto dto) {
		
		log.info("addProduct()    "+this.getClass().getName());
		return adaptorProduct.adaptor(repoProduct.save(adaptorProduct.adaptor(dto)));
	}

	@Override
	@Cacheable(value = "userCache")
	public List<ProductDto> getAllProduct() {
				log.info("getAllProduct()  "+this.getClass().getName());
				return  adaptorProduct.adaptor(repoProduct.findAll());
		 		
	}

	@Override
	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public ProductDto getProduct(int id) {
		ProductDto dto=null;
		
		log.info("getProduct()  "+this.getClass().getName());
		Optional<ProductModel> opModel=repoProduct.findById(id);
		if(opModel.isPresent()) {
			dto=adaptorProduct.adaptor(opModel.get());
		}
		else {
			throw new RuntimeException("Resourse Not Found");
		}
		return dto;
	}

	@Override
	@CacheEvict(value = "userCache")
	public String deleteProduct(int id) {
		String str="UnSucessful";
		log.info("deleteProduct()  "+this.getClass().getName());
		repoProduct.deleteById(id);
		str="Successful";
				return str;
	}
	
	public List<ProductDto> sortBy(String sort){
		//repoProduct.findAll(sort);
		return null;
	}
	@Cacheable(cacheNames = { "userCache" })
	@Override
	public List<ProductDto> getAllProduct(CustomSort customSort) {
		// TODO Auto-generated method stub
		log.info("getAllProduct(String str)     "+this.getClass().getName());
		if(customSort.getDirection().equalsIgnoreCase("Desc")) {
			Sort sort = new Sort(Sort.Direction.DESC, customSort.getProperties());
			return adaptorProduct.adaptor(repoProduct.findAll(sort));
		}
		else {
			Sort sort = new Sort(Sort.Direction.ASC, customSort.getProperties());
		return adaptorProduct.adaptor(repoProduct.findAll(sort));
		}
	}
}
