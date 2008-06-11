package com.drs.model;

import com.drs.client.test.PricePolicy;

public class DiskTag {
	
	public DiskTag(int id, String shortName, String name){
		this.id =id;
		this.shortName = shortName;
		this.name = name;
		
	}
	
	private int id;
	
	/**
	 * 
	 */
	private String shortName; 
	private String name;
	
	private boolean priceRelated;
	
	private PricePolicy pricePolicy;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public PricePolicy getPricePolicy() {
		return pricePolicy;
	}



	public void setPricePolicy(PricePolicy pricePolicy) {
		this.pricePolicy = pricePolicy;
	}



	public boolean isPriceRelated() {
		return priceRelated;
	}



	public void setPriceRelated(boolean priceRelated) {
		this.priceRelated = priceRelated;
	}



	public String getShortName() {
		return shortName;
	}



	public void setShortName(String shortName) {
		this.shortName = shortName;
	}



	@Override
	public String toString(){
		return "DiskTag:" + name;
	}
	
}
