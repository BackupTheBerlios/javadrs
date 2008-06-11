package com.drs.gui.action;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import com.drs.gui.DiskTable;

public class ShowDetailAction extends AbstractAction{

	private DiskInfoDialog dialog;
	private DiskTable table;
	public static String name="碟片详情";
	public ShowDetailAction(DiskTable table){
		super(name);
		this.table = table;
		dialog = new DiskInfoDialog(table.getFrame(),name);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if( table.getSelectedRow() == -1 )
		{
			JOptionPane.showMessageDialog( (Component) e.getSource(), "请先选择一个碟片", "提醒", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		dialog.setData(table.getSelectedDisk());
		dialog.showAtCenter();
		
		
	}
	
	
}


