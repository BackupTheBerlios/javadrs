package com.drs.client.test;

import java.util.*;

public class DiskInfoTest {
	
	
	
	public static List<DiskInfo> 
	createTestData(){
		List<DiskInfo> data = new LinkedList<DiskInfo>();
		
		DiskInfo di1 = new DiskInfo("aqdky","爱情大考验");
		DiskInfo di2 = new DiskInfo("gjbz","国家宝藏");
		DiskInfo di3 = new DiskInfo("ymxcl","亚马逊丛林");
		DiskInfo di4 = new DiskInfo("ymxkl","亚马逊恐龙");
				
		data.add(di1);
		data.add(di2);
		data.add(di3);
		data.add(di4);
		
		return data;
	}
	
	public static List<DiskInfo>  filter(List<DiskInfo> data,String qt){
		
Iterator<DiskInfo> i = data.iterator();
		
		while( i.hasNext()){
			DiskInfo di = i.next();
			if( !di.getId().startsWith(qt)){
				i.remove();
			}
		}
		
		
		
		Collections.sort(data, new Comparator<DiskInfo>(){
		
			/**
			 * The most matching object should be placed first.
			 * 
			 * @param o1
			 * @param o2
			 * @return
			 */
			
			public int compare(DiskInfo o1, DiskInfo o2) {
				
				
				return o1.getId().compareTo(o2.getId());
			}
			
			
		});
		
		return data;
	}
	
	
	
	

}
