package com.jpa.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.dto.ProductDto;



@Service
public class ProductServiceImpl implements ProductService {

	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public ProductDto addProduct(ProductDto dto) {
		listDto.add(dto);
		log.info(this.getClass().getName());
		return dto;
	}

	@Override
	public List<ProductDto> getAllProduct() {
		log.info(this.getClass().getName());
				return  listDto;
		 		
	}

	@Override
	public ProductDto getProduct(int id) {
		List<ProductDto> list=new ArrayList<>();
		
		log.info(this.getClass().getName());
		
		 ListIterator<ProductDto> listItr=listDto.listIterator();	
		 while (listItr.hasNext()) {
			ProductDto productDto = (ProductDto) listItr.next();
			if(productDto.getProdId()==id) {
				list.add(productDto);
				break;
			}//if
			
		}//while
		 
		return list.get(0);
	}

	@Override
	public String deleteProduct(int id) {
		String str="UnSucessful";
		
		log.info("   -------------------delete---------------------     "+this.getClass().getName());
		
		 ListIterator<ProductDto> listItr=listDto.listIterator();	
		 while (listItr.hasNext()) {
			ProductDto productDto = (ProductDto) listItr.next();
			if(productDto.getProdId()==id) {
				listItr.remove();
				str="Sucessful";
				break;
			}//if
			
		}//while
		return str;
	}
	
	
	
	
	
	
	
	
	private static List<ProductDto> listDto =new ArrayList();
		
		static {
			log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			log.info("   ---------------------------------------------------Static Block-------------------------------------     ");
			log.info("************************************************************************************************");
			listDto.add(new ProductDto(101,"Mobile", 12999.00));
			listDto.add(new ProductDto(103,"Book", 909.00));
			listDto.add(new ProductDto(104,"Bag", 1250.60));
			listDto.add(new ProductDto(105,"Fan", 2680.570));
			listDto.add(new ProductDto(106,"Laptop", 45999.00));
			listDto.add(new ProductDto(107,"SumSung TV", 23891.00));
			listDto.add(new ProductDto(108,"Washing Machine", 17984.10));
			listDto.add(new ProductDto(109,"Shoe", 3260.43));
		}

		public List<ProductDto> getListDto() {
			return listDto;
		}

		public void setListDto(List<ProductDto> listDto) {
			this.listDto = listDto;
		}
	

}
