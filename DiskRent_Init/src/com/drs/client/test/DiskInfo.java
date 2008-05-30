package com.drs.client.test;

import java.util.*;


public class DiskInfo {
	
	private String id;
	private String name;
	
	/**
	 * Disk Type. π‚≈Ã¿‡–Õ (VCD, DVD) 
	 */
	private DiskType diskType;
	
	public static enum DiskType{
		VCD, DVD
	}
	
	/**
	 * a set of disk tags.
	 */
	private Set<DiskTag> diskTagSet;
	
	/**
	 * when the disk/film was issued.
	 */
	private Date issueDate;
	
	/**
	 * when the disk is purchased and in stock.
	 * 
	 */
	private Date inStockDate;
	
	
	
	
	/**
	 * actors of this movie.
	 */
	private Set<String> actors;
	
	/**
	 * Disk Content Description
	 * 
	 * 
	 */
	private String contentDesc;
	
	
	/**
	 * 
	 * @param id
	 * @param desc
	 */
	
	public DiskInfo(String id, String desc){
		this.id = id;
		this.name = desc;
	}
	
	public String getId(){
		return id;
	}
		
	
	public String getName(){
		return name;
	}
	
	/**
	 * Mask for allowed operations.
	 * 
	 */
	
	public static  enum Mask {
		SHOW_DETAIL,
		RENT,
		RETURNED
	};
	
	public Mask [] getAllowedOperation(){
		
		//TODO: needs to add logic to decide the mask.
		return new Mask []{Mask.SHOW_DETAIL, Mask.RENT};
	}
		
}
