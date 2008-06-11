package com.drs.client.test;

import javax.swing.*;
import com.drs.gui.DRSFrame;

public class DRSApp {
	public static void main(String [] args){
		
		Runnable doRun = new Runnable(){
			public void run(){
				DRSFrame f = 
				new DRSFrame();
				
				f.setSize(1024, 768);
				
				f.setVisible(true);
			}
		};
		
		SwingUtilities.invokeLater(doRun);
		
	}

}
