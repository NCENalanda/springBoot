package com.jpa.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.NONE)
public class CustomSort implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 17879686L;
	private String direction ;
	private List<String> properties = new ArrayList<String>();
	
	
	public CustomSort() {
		// TODO Auto-generated constructor stub
	}


	public CustomSort(String direction, List<String> properties) {
		super();
		this.direction = direction;
		this.properties = properties;
	}


	public String getDirection() {
		return direction;
	}


	public List<String> getProperties() {
		return properties;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public void setProperties(List<String> properties) {
		this.properties = properties;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomSort [direction=").append(direction).append(", properties=").append(properties)
				.append("]");
		return builder.toString();
	}
	
	
}
