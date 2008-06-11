package com.drs.gui.action;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


/**
 * 
 * 
 * @author James Wang
 *
 */
public class ReturnDiskAction extends AbstractAction {

	private ReturnDiskDialog dialog;
//	private
	public static String name = "¹é»¹µúÆ¬";
	public ReturnDiskAction(){
		super(name);
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
}


/**
 * 
 * 
 * @author James Wang
 *
 */
class ReturnDiskDialog extends AbstractDRSDialog {

	public ReturnDiskDialog(Frame frame, String title){
		super(frame, title);
	}
	
	@Override
	protected void drsInitDialog() {
		
		
	}
	
	
}
