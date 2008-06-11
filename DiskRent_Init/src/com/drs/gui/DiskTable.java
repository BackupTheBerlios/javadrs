package com.drs.gui;

import java.awt.Point;
import java.awt.event.*;


import java.awt.*;


import javax.swing.*;
import javax.swing.event.*;

import com.drs.model.DiskInfo;
import com.drs.gui.action.DiskInfoDialog;
import com.drs.gui.table.*;

public class DiskTable extends JTable {
	private Frame frame;
	public DiskTable(Frame frame,DiskTableModel model){
		super(model);
		this.frame = frame;
		initDiskTable();
	}
	
	/**
	 * Get Selected Disk.
	 * 
	 * @return DiskInfo
	 */
	public DiskInfo getSelectedDisk(){
		int index = this.getSelectedRow();
		
		
		
		return this.getDiskInfo(index);
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
					// get the selected row.
					int index = DiskTable.this.getSelectedRow();
					
					showDetail(DiskTable.this.getDiskInfo(index));
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
	public void showDetail(DiskInfo data){
		
		DiskInfoDialog dlg = new DiskInfoDialog(frame,"DiskInfo");
		dlg.setData(data);
		dlg.showAtCenter();
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
		int index = this.rowAtPoint(p);
		
		if( index == -1){
			// no row in range.
			return null;
		}else {
			// select that row.
			this.getSelectionModel().setSelectionInterval(index, index);
		}
		
		return this.getDiskInfo(index);
	}
	
	@Override
	public DiskTablePopupMenu getComponentPopupMenu(){
		return (DiskTablePopupMenu)super.getComponentPopupMenu();
	}
	
	public Frame getFrame(){
		return frame;
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
		Point p = e.getPoint();	
		DiskInfo info = table.getDiskInfo(p);
		
		table.showDetail(info);
				
	}
	
	

 
}