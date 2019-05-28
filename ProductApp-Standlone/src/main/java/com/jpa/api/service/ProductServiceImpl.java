package com.jpa.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.jpa.api.dao.ProductRepository;
import com.jpa.api.model.ProductModel;



@Service
public class ProductServiceImpl implements ProductService {

	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired //(required=true)
    private ProductRepository repoProduct;
	
	@Override
	public ProductModel addProduct(ProductModel dto) {
		
		log.info("addProduct()    "+this.getClass().getName());
		return null;
	}
	
	public List<ProductModel> getProductsSortedBY(String str){
		log.info("getProductSortedBy()     "+this.getClass().getName());
		return null;
	}

	@Override
	public List<ProductModel> getAllProduct() {
		repoProduct.findAll().stream().forEach(System.out::println);
		log.info("getAllProduct()  "+this.getClass().getName());
		log.info('\n'+'\n'+"       getProductQuery()                                           ");
		repoProduct.getProductQuery().stream().forEach(System.out::println);
		
		log.info('\n'+'\n'+"       findAllByOrderByProdIdAsc()                                           ");
		repoProduct.findAllByOrderByProdIdAsc().stream().forEach(System.out::println);
		
		log.info('\n'+'\n'+"       findAllByOrderByProdIdDesc()                                           ");
		repoProduct.findAllByOrderByProdIdDesc().stream().forEach(System.out::println);
		
		
		log.info('\n'+'\n'+"       findAll(new Sort(\"price\"))                                           ");
		//repoProduct.findAll(new Sort("price")).stream().forEach(System.out::println);
		
		
		log.info('\n'+'\n'+"       findAll(new Sort(\"price\"))                                           ");
		//Constructor By Sort
		/*
		Sort sort= new Sort(Sort.Direction.ASC);
		Sort sort2= new Sort(Sort.Direction.ASC,"price");
		Sort sort3= new Sort(Sort.Direction.ASC,"Price","ProdId");
		
		//Static Method of Sort
		 Sort.by(Sort.Direction.ASC,"Price","","","");
		 Sort.by(Sort.Direction.DESC,"");
		 */
		 log.info('\n'+'\n'+"       findAll(Sort.by(\"Price\"))                                           ");
		List<String> list = new ArrayList<>();
		list.add("Price");
		list.add("ProdId");
		
		Sort sort1 = new Sort(Sort.Direction.ASC,list);
		
		Sort sort2 = new Sort(Sort.Direction.DESC,list);
		// repoProduct.findAll(Sort.by("Price","ProdId")).stream().forEach(System.out::println); //Success
		repoProduct.findAll(sort1).stream().forEach(System.out::println);
		
		Order.by("ProdName");
		repoProduct.findAll(Sort.by(Order.asc("ProdName"))).stream().forEach(System.out::println);
		/*
		 * Pageable
		 *      PageRequest
		 * */
		System.out.println();System.out.println();System.out.println();
		log.info('\n'+'\n'+"      findAll(PageRequest.of(0, 5))                                           ");
		repoProduct.findAll(PageRequest.of(0, 5)).stream().forEach(System.out::println);
		System.out.println();System.out.println();System.out.println();
		repoProduct.findAll(PageRequest.of(1, 5)).stream().forEach(System.out::println);
		return repoProduct.findAll();
				//return null;
		 		
	}

	@Override
	public ProductModel getProduct(int id) {
		ProductModel model=null;
		
		log.info("getProduct()  "+this.getClass().getName());
		Optional<ProductModel> opModel=repoProduct.findById(id);
		if(opModel.isPresent()) {
			;
		}
		else {
			throw new RuntimeException("Resourse Not Found");
		}
		return null;
	}

	@Override
	public String deleteProduct(int id) {
		String str="UnSucessful";
		log.info("deleteProduct()  "+this.getClass().getName());
		repoProduct.deleteById(id);
		str="Successful";
				return str;
	}
	
	@Override
	public List<ProductModel> query(){
		log.info("query()  "+this.getClass().getName());
		log.info("@Query(\"select u from ProductModel u\")  "+this.getClass().getName());
		repoProduct.findAllfromQuery().forEach(System.out::println);
		
		log.info("@Query(\"select u.ProdId from ProductModel u\")  "+this.getClass().getName());
		repoProduct.findProdIdquery().forEach(System.out::println);
		
		log.info("@Query(\"select u.ProdId from ProductModel u\")  "+this.getClass().getName());
		repoProduct.findProdIdquery(101).forEach(System.out::println);

		return null;
		
	}
	
	
	public void show() {
		log.info("addAll()  "+this.getClass().getName());					
	}
}
