package com.drs.biz;

import com.drs.model.DiskInfo;
import com.drs.model.RentInfo;

/**
 * DepositService provides functions for
 * deposit calculation and management services.
 * 
 * @author James Wang
 *
 */
public class DepositService {

	/**
	 * Calculate default deposit amount according to
	 * disk info and renting info.
	 * 
	 * @param diskInfo
	 * @param rentInfo
	 * @return
	 */
	public static void calculateDefaultDeposit(DiskInfo diskInfo, RentInfo rentInfo ){
		
		//TODO: more elaborate deposit calculation.
		
		// Simple case.
		String diskNum = rentInfo.get(RentInfo.KEY_DISKNUM);
		
		int n = Integer.valueOf(diskNum);
		
		rentInfo.set(RentInfo.KEY_DEPOSIT, String.valueOf(10*n));
		
	}
}
