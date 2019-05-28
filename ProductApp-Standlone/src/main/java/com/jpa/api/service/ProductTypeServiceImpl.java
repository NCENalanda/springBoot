package com.jpa.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.dao.ProductTypeRepository;
import com.jpa.api.model.ProductType;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository repoType;
	@Override
	public ProductType add() {
		List<ProductType> listType = new ArrayList<>();
		/*
		listType.add(new ProductType(1001, "Electroincs",""));
		listType.add(new ProductType(1100, "Mobiles", "Electroincs"));
		listType.add(new ProductType(1105, "Mobiles & Accessorices", "Electroincs"));
		listType.add(new ProductType(1110, "Smart Wearable Touch", "Electroincs"));
		listType.add(new ProductType(1115, "Laptop", "Electroincs"));
		listType.add(new ProductType(1120, "Audio Video & Accessorices", "Electroincs"));
		listType.add(new ProductType(1125, "Personal and Healthcare & Accessorices", "Electroincs"));
		listType.add(new ProductType(1130, "Computer & Accessorices ", "Electroincs"));
		listType.add(new ProductType(1135, "Gaming & Accessorices ", "Electroincs"));
		listType.add(new ProductType(1140, "Televisions", "Electroincs"));
		listType.add(new ProductType(1145, "Camra", "Electroincs"));
		listType.add(new ProductType(1150, "Desktop", "Electroincs"));
		listType.add(new ProductType(1155, "Tablet", "Electroincs"));
		listType.add(new ProductType(1160, "Air Conditioners", "Electroincs"));
		listType.add(new ProductType(1165, "Washing Machine", "Electroincs"));
		listType.add(new ProductType(1170, "Refrigerators", "Electroincs"));
		listType.add(new ProductType(1175, "Microwave Ovens", "Electroincs"));
		listType.add(new ProductType(1180, "Small Home Appliances", "Electroincs"));
		listType.add(new ProductType(1185, "Network $ Accessorices", "Electroincs"));
		
		listType.add(new ProductType(1005, "Fashion", ""));
		listType.add(new ProductType(1500, "Footwear", "Fashion"));
		
		listType.add(new ProductType(1600, "Shoe", "Footwear"));
		listType.add(new ProductType(2015, "Sports", "Shoe"));
		listType.add(new ProductType(2020, "Formal", "Shoe"));
		listType.add(new ProductType(2025, "Casual", "Shoe"));
		listType.add(new ProductType(2030, "Boots", "Shoe"));
		listType.add(new ProductType(2035, "Sneakars", "Shoe"));
		listType.add(new ProductType(2040, "Loafers", "Shoe"));
		
		listType.add(new ProductType(1605, "Sandals", "Footwear"));
		listType.add(new ProductType(2060, "Flats", "Footwear"));
		listType.add(new ProductType(2065, "Heels", "Footwear"));
		
		listType.add(new ProductType(2070, "Wedge", "Footwear"));
		listType.add(new ProductType(2045, "Slippers", "Footwear"));
		listType.add(new ProductType(2050, "Flip Flops",  "Slippers"));
		
		listType.add(new ProductType(1505, "Clothing", "Fashion"));
		listType.add(new ProductType(1700, "Top wear", "Clothing"));
		listType.add(new ProductType(2100, "Shirts", "Top wear"));
		listType.add(new ProductType(2105, "T-Shirts", "Top wear"));
		listType.add(new ProductType(2110, "Kurtas", "Top wear"));
		listType.add(new ProductType(2115, "Suits", "Top wear"));
		listType.add(new ProductType(2120, "Blazers", "Top wear"));
		
		listType.add(new ProductType(1705, "Bottom wear", "Clothing"));
		listType.add(new ProductType(2200, "Jeans", "Bottom wear"));
		listType.add(new ProductType(2205, "Trouser", "Bottom wear"));
		listType.add(new ProductType(2210, "Track Pants", "Bottom wear"));
		listType.add(new ProductType(2215, "Shorts 3/4", "Bottom wear"));
		listType.add(new ProductType(2220, "Cargo", "Bottom wear"));
		listType.add(new ProductType(2225, "Pyjama", "Bottom wear"));
		
		listType.add(new ProductType(1710, "Winter wear", "Clothing"));
		listType.add(new ProductType(2300, "Sweaters", "Winter wear"));
		listType.add(new ProductType(2305, "Jackets", "Winter wear"));
		listType.add(new ProductType(2310, "Sweateshirts", "Winter wear"));
		listType.add(new ProductType(2315, "Thermals", "Winter wear"));
		
		listType.add(new ProductType(1715, "Sports wear", "Clothing"));
		listType.add(new ProductType(1720, "Innerwear", "Clothing"));
		listType.add(new ProductType(1725, "Swim & Beachwear", "Clothing"));
		listType.add(new ProductType(1730, "Sleeperwear", "Clothing"));
		listType.add(new ProductType(1735, "Ethnicwear", "Clothing"));
		listType.add(new ProductType(1740, "Babyclothing", "Clothing"));
		listType.add(new ProductType(1745, "Kidsclothing", "Clothing"));
		
		listType.add(new ProductType(1510, "Watches", "Fashion"));
		listType.add(new ProductType(1515, "Accessorices", "Fashion"));
		listType.add(new ProductType(1520, "Jewellery", "Fashion"));
		listType.add(new ProductType(1525, "Beauty & Grooming", "Fashion"));
		listType.add(new ProductType(2600, "Deodorants", "Beauty & Grooming"));
		listType.add(new ProductType(2605, "Perfume", "Beauty & Grooming"));
		listType.add(new ProductType(2610, "Shaving & Aftershave", "Beauty & Grooming"));
		listType.add(new ProductType(2615, "Make up", "Beauty & Grooming"));
		listType.add(new ProductType(2620, "Skin care", "Beauty & Grooming"));
		listType.add(new ProductType(2625, "Hair care", "Beauty & Grooming"));
		listType.add(new ProductType(2630, "Bath & Spa", "Beauty & Grooming"));
		
		listType.add(new ProductType(1530, "Toys", "Fashion"));
		listType.add(new ProductType(2800, "Remote control", "Toys"));
		listType.add(new ProductType(2805, "Educational", "Toys"));
		listType.add(new ProductType(2810, "Soft", "Toys"));
		listType.add(new ProductType(2815, "Dolls", "Toys"));
		
		
		listType.add(new ProductType(1535, "Babycare", "Fashion"));
		listType.add(new ProductType(2700, "Diapers", "Babycare"));
		listType.add(new ProductType(2700, "Wipes", "Babycare"));
		*/
		
		 Collections.sort(listType, new Comparator<ProductType>() {

			@Override
			public int compare(ProductType o1, ProductType o2) {
				// TODO Auto-generated method stub
				return o1.getType().compareToIgnoreCase(o2.getType());
			}
		});//close the anonmous class
		 listType.forEach(System.out::println);
		 repoType.saveAll(listType).forEach(System.out::println);
		return null;
	}
	
	@Override
	public List<ProductType> search() {
		// TODO Auto-generated method stub
		//repoType.search().forEach(System.out::println);
		/*System.out.println(repoType.count());;
		Optional<List<ProductType>> op = repoType.search();
		if(op.isPresent()) {
			//op.get().forEach(System.out::println);
		}*/
		//repoType.search().forEach(System.out::println);
		System.out.println(repoType.search("Toys").toString());
		return null;
	}

}
