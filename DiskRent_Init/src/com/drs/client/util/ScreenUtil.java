package com.drs.client.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.Rectangle;

import javax.swing.*;

/**
 * some utility functions for Swing screen operations.
 * 
 * 
 * @author mzx0cd
 * 
 */
public class ScreenUtil {

	public static void setSimpleSizes(int w, int h, Component... comps) {
		Dimension d = new Dimension(w, h);
		for (Component c : comps) {
			c.setPreferredSize(d);
			c.setMinimumSize(d);
		}
	}

	public static void addToContainer(Container container,
			Component... components) {
		for (Component component : components) {
			container.add(component);
		}
	}

	public static JComboBox createComboBox(String... values) {
		JComboBox cb = new JComboBox(values);
		return cb;
	}

	/**
	 * move the component to the center of the frame. frame and component can't
	 * be null.
	 * 
	 * @param frame
	 * @param component
	 * @return
	 */
	public static void center(Window window, Component component) {
		Dimension ps = window.getSize(); // parent size.
		Dimension cs  = component.getSize(); // child size.
		
		int x =  ps.width/2 - cs.width/2;
		int y =  ps.height/2 - cs.height/2;
		
		component.setLocation(x, y);

	}

}
