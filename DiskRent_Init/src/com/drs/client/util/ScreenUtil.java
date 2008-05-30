package com.drs.client.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;
/**
 * some utility functions for Swing screen 
 * operations.
 * 
 * 
 * @author mzx0cd
 *
 */
public class ScreenUtil {

	public static  void setSimpleSizes(int w, int h, Component... comps){
		Dimension d = new Dimension(w,h);
		for(Component c: comps){
			c.setPreferredSize(d);
			c.setMinimumSize(d);
		}
	}
	
	public static void addToContainer(Container container, Component...components ){
		for(Component component:components){
			container.add(component);
		}
	}
	
	public static JComboBox createComboBox(String... values){
		JComboBox cb = new JComboBox(values);
		return cb;
	}
	
	
	
	
}
