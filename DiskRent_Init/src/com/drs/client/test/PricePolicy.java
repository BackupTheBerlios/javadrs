package com.drs.client.test;

/**
 * PricePolicy defines the policy of pricing.
 * 
 * The PricePolicy will be applied to a set of disks tagged with a certain DiskTag.
 * 
 * 
 * 
 * @author mzx0cd
 *
 */
public interface PricePolicy {

	/**
	 *  adjust price according to DiskTag.
	 */
	public double adjust(double org, DiskTag tag);
	
	
	
}
