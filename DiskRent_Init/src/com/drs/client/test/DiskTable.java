package com.drs.client.test;

import java.awt.Point;
import java.awt.event.*;


import java.awt.*;


import javax.swing.*;
import javax.swing.event.*;

public class DiskTable extends JTable {
	private Frame frame;
	public DiskTable(Frame frame,DiskTableModel model){
		super(model);
		this.frame = frame;
		initDiskTable();
	}
	
	private void initDiskTable(){
		this.addMouseMotionListener( new MouseMotionListener (){

			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseMoved(MouseEvent e) {
				
				Point p = e.getPoint();
				// select the row containing this point.				
				int rowIndex = DiskTable.this.rowAtPoint(p);
				//TODO: don't move:)
				//DiskTable.this.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
			}
			
			
		});
		
		
		this.addMouseListener( new DiskTableMouseListener(this));
		
	
		this.setComponentPopupMenu(new DiskTablePopupMenu(this));
		
		// add input enter 
		this.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				// Ignored
				if( e.getKeyChar() == KeyEvent.VK_ENTER){
					showDetail();
					e.consume();
				}
			}

			public void keyReleased(KeyEvent e) {
				// Ignored
				
			}

			public void keyTyped(KeyEvent e) {
				
			}
			
			
		});
		
	}

	/**
	 * If then ENTER key is pressed,
	 * show the detail of the selected row.
	 * 
	 * @param e
	 */
	public void showDetail(){
		
		DiskInfoDialog dlg = new DiskInfoDialog(frame,"DiskInfo",true);
		//dlg.setPreferredSize(new Dimension(800,600));
		dlg.pack();
		dlg.setVisible(true);
	}

	/**
	 *  Get the DiskInfo at the specified row.
	 *  If the index is out of range ( <0 or >= size),
	 *  a null value will be returned.
	 * 
	 * @param index
	 * @return
	 */
	
	
	public DiskInfo getDiskInfo(int index){
		// Get Model First.
		DiskTableModel m = (DiskTableModel) this.getModel();
		return m.getDiskInfo(index);
	}
	public DiskInfo getDiskInfo(Point p){
		return this.getDiskInfo(this.rowAtPoint(p));
	}
	
	@Override
	public DiskTablePopupMenu getComponentPopupMenu(){
		return (DiskTablePopupMenu)super.getComponentPopupMenu();
	}
	
}


/**
 * A popup menu for the disk table.
 * 
 * 
 * @author James Wang
 *
 */

class DiskTablePopupMenu extends JPopupMenu {
	
	
	private DiskTable table;
	
	private JMenuItem showDetail;
	private JMenuItem rent;
	private JMenuItem returned;
	
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
		showDetail = new JMenuItem("Show Detail");
		rent       = new JMenuItem("Rent Out");		
		returned   = new JMenuItem("Returned");
		
		// add to the menu.
		add(showDetail);
		add(rent);		
		add(returned);
		
		// disable all the menu items.
		this.enableItems(false, showDetail, rent, returned);
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



/**
 *  When the mouse double-clicked on a row, we should open a dialog, showing 
 *  the details of that row.
 * 
 * 
 * @author James Wang
 *
 */

 class DiskTableMouseListener extends MouseAdapter {

	 private DiskTable table;
	 
	 public DiskTableMouseListener(DiskTable table){
		 this.table = table;
	 }
	 
	 
	public void mouseClicked(MouseEvent e) {
		int num = e.getClickCount();
	    
		
		if( num > 1){
			onDoubleClick(e);
			return;
		}
		
	}
	
	
	
	private void onDoubleClick(MouseEvent e){
		//Point p = e.getPoint();	
		//DiskInfo info = table.getDiskInfo(p);
		
		table.showDetail();
				
	}
	
	

 
}