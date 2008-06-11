package com.drs.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * RentInfo.
 * renting transaction related data.
 * 
 * @author James Wang
 *
 */
public class RentInfo {
	
	// Descriptions.
	public static final String KEY_TXDATE="txDate", KEY_DISKNUM="diskNum",
	KEY_DEPOSIT="deposit";
	
	static public Properties fieldDescs = new Properties();
	public Map<String, String> values = new HashMap<String, String>();
	
	static {
		fieldDescs.setProperty(KEY_TXDATE, "借出日期");
		fieldDescs.setProperty(KEY_DISKNUM, "碟片数量");
		fieldDescs.setProperty(KEY_DEPOSIT, "押金");
		
	}
	
	
	
	/**
	 * 
	 * @param key Must be one of the consts prefixed with KEY_ in this class.
	 * @return
	 */
	public String get(String key){
		return values.get(key);
	}
	
	/**
	 * 
	 * @param key refer to {@link #get(String)}
	 * @param value
	 */
	public void set(String key, String value){
		values.put(key, value);
	}
		
}
