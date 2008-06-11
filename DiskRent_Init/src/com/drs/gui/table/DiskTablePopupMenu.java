package com.drs.gui.table;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;

import com.drs.model.*;
import com.drs.gui.*;
import com.drs.gui.action.*;
/**
 * A popup menu for the disk table.
 * 
 * 
 * @author James Wang
 *
 */

public class DiskTablePopupMenu extends JPopupMenu {
		
	private DiskTable table;
	private JMenuItem showDetail;
	private JMenuItem rent;
	private JMenuItem returned;
	
	/**
	 * 
	 * 
	 */
	private JMenuItem undo;
	
	
	/**
	 * 
	 * @param item
	 * @param enabled
	 */
	
	public void enableItem(JMenuItem item, boolean enabled){
		item.setEnabled(enabled);
		
	}
	
	public void enableItems( boolean enabled,JMenuItem... items){
		for(JMenuItem item: items){
			item.setEnabled(enabled);
		}
	}
	
	public void applyDiskInfoMask(DiskInfo di){
		
		
		enableItems(false, showDetail, rent, returned);
		
		if (di == null)
			return;
		
		DiskInfo.Mask [] masks = di.getAllowedOperation();
		
		for(DiskInfo.Mask m: masks){
			
			System.out.println(m.toString());
			switch(m){
			case SHOW_DETAIL:
				showDetail.setEnabled(true);
				break;
			case RENT:
				rent.setEnabled(true);
				break;
			case RETURNED:
				returned.setEnabled(true);
			}
		}
		
	}
	
	protected void initMenuItems(){
		Action showDetailAction = new ShowDetailAction(table);				
		showDetail = new JMenuItem(showDetailAction);
		Action rentAction = new RentDiskAction(table);
		
		rent       = new JMenuItem(rentAction);	
		
		returned   = new JMenuItem("Returned");
		
	
		
		// add to the menu.
		add(showDetail);
		add(rent);		
		add(returned);
		
		// disable all the menu items.
		this.enableItems(false, showDetail, rent, returned);
		
		/**
		 * Specify the actions for the menu items.
		 */
		
		
		
		
		
		
	}
	
	public DiskTablePopupMenu(DiskTable table){
		this.table = table;
		
		initMenuItems();
		this.addPopupMenuListener(new PopupMenuListener(){

			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				
				// set up popup context.
				setPopupContext();
								
				
			}
			
			
		});
		
	}
	
	
	
	private void setPopupContext(){
		
		
		DiskInfo di = table.getDiskInfo(table.getMousePosition());
		
		this.applyDiskInfoMask(di);
		
		
		
	}
}
