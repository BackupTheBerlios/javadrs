package com.drs.client.test;

import javax.swing.table.AbstractTableModel;

import java.util.*;


public class DiskTableModel extends AbstractTableModel {

	
	/**
	 * Replace the column name.
	 */
	
	private String [] headers = new String [] {
			"ĞòºÅ",
			"¼òÒ×±àÂë",
			"ÃèÊö"
	};
	
	private List<DiskInfo> data;
	
	public DiskTableModel(){
		data = new LinkedList<DiskInfo>();
	}
	
	public void addData(List<DiskInfo> inc){
		data.addAll(inc);
	}
	
	public void setData(List<DiskInfo> update){
		data.clear();
		
		data.addAll(update);
		
		this.fireTableDataChanged();
	}
	
	
	
	@Override
	public String getColumnName(int column) {
		
			return headers[column];
		
			
			
	}

	public int getColumnCount() {
		
		return headers.length;
	}

	public int getRowCount() {
		
		return data.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		DiskInfo di = data.get(rowIndex);
		
		switch(columnIndex){
		case 0:
			return String.valueOf(rowIndex);
		case 1:
			return di.getId();
		case 2:
			return di.getName();
		default:
			return "Undefined";
				
		}
		
		
	}
	
	public DiskInfo getDiskInfo(int rowIndex){
		if( rowIndex >= getRowCount() || rowIndex < 0 ){
			return null;
		}
		
		return data.get(rowIndex);
		
	}

}
