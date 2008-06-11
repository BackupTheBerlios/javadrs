package com.drs.model;

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

	public Set<String> getActors() {
		return actors;
	}

	public void setActors(Set<String> actors) {
		this.actors = actors;
	}

	public String getContentDesc() {
		return contentDesc;
	}

	public void setContentDesc(String contentDesc) {
		this.contentDesc = contentDesc;
	}

	public Set<DiskTag> getDiskTagSet() {
		return diskTagSet;
	}

	public void setDiskTagSet(Set<DiskTag> diskTagSet) {
		this.diskTagSet = diskTagSet;
	}

	public DiskType getDiskType() {
		return diskType;
	}

	public void setDiskType(DiskType diskType) {
		this.diskType = diskType;
	}

	public Date getInStockDate() {
		return inStockDate;
	}

	public void setInStockDate(Date inStockDate) {
		this.inStockDate = inStockDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
