package com.drs.gui.action;

import static com.drs.client.util.ScreenUtil.center;
import static com.drs.client.util.ScreenUtil.createComboBox;

import java.awt.Frame;

import javax.swing.*;

import com.drs.gui.CollectionPanel;
import com.drs.model.DiskInfo;
import com.drs.model.DiskTag;

public abstract class AbstractDRSDialog extends JDialog{

	protected DiskInfo data;
	
	
	protected JTextField diskIdField, diskName;
	protected JComboBox diskTypeComboBox;
	protected CollectionPanel actors, tags;
	
	protected JLabel idLabel = new JLabel("ID:");
	protected JLabel nameLabel = new JLabel("name:");
	protected JLabel diskTypeLabel = new JLabel("Disk Type:");
	
	
	
	/**
	 * Pass in the DiskInfo to this Dialog for display.
	 * 
	 * @param di
	 */
	public void setData(DiskInfo di){
		this.data = di;
		populateData();
	}
	
	/**
	 * The default implementation populates the data of DiskInfo.
	 * 
	 *
	 */
	protected  void populateData(){
		this.diskIdField.setText(data.getId());		
		this.diskName.setText(data.getName());
		this.diskTypeComboBox.setSelectedItem(data.getDiskType().toString());
		
		this.tags.setCollection(data.getDiskTagSet().toArray(new DiskTag[0]));
		this.actors.setCollection(data.getActors().toArray(new String[0]));
		
	}
	
	public AbstractDRSDialog(Frame frame, String title){
		super(frame, title, true);
		
		diskIdField 		= new JTextField();
		diskName 		= new JTextField();
		diskTypeComboBox 	= createComboBox("VCD","DVD");
		actors              = new CollectionPanel();
		tags                = new CollectionPanel();
		
		actors.setTitle("Actors");
		tags.setTitle("Tags");
		
		
		
		drsInitDialog();
	}
	
	
	
	protected abstract void drsInitDialog();
	
	public void showAtCenter(){
		pack();
		center(this.getOwner(), this);
		setVisible(true);
	}
	
}
