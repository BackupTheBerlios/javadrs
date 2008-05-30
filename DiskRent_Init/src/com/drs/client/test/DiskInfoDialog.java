package com.drs.client.test;

import javax.swing.*;
import java.awt.*;


import static com.drs.client.util.ScreenUtil.*;



/**
 * a Dialog Window for displaying the
 * details of DiskInfo.
 * 
 * 
 * 
 * @author James Wang
 *
 */
public class DiskInfoDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane;
	
	private DiskInfo data;
	
	
	public DiskInfoDialog(Frame frame, String title, boolean modal){
		super(frame, title, modal);
		initDiskInfoDialog();
	}
	
	
	private final String TAB_GENERAL="general";
	private final String TAB_RENT="rent";
	private final String TAB_MORE="more";
	
	private JPanel generalPanel, rentPanel, morePanel;
	
	private JButton closeButton;
	
	/**
	 * Init this dialog with DiskInfo.
	 *
	 */
	private void initDiskInfoDialog(){
		
		
		initTabbedPane();
		setLayout(new BorderLayout());
		getContentPane().add(jTabbedPane, BorderLayout.CENTER);	
		
		/**
		 * Adding other dialog-scope commands
		 * 
		 */
		JPanel cmdPanel = new JPanel();
		cmdPanel.setLayout(new BorderLayout());
		
		closeButton = new JButton("Close");
		cmdPanel.add(closeButton, BorderLayout.EAST);
		
		getContentPane().add(cmdPanel, BorderLayout.SOUTH);	
		
	}
	
	private void initTabbedPane(){
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		generalPanel = createGeneralPanel();
		rentPanel    = createRentPanel();
		morePanel    = createMorePanel();
		
		jTabbedPane.addTab(TAB_GENERAL, generalPanel);
		jTabbedPane.addTab(TAB_RENT, rentPanel);
		jTabbedPane.addTab(TAB_MORE, morePanel);
			
	}
	
	
	private JTextField idField, nameField;
	private JComboBox diskTypeComboBox;
	private CollectionPanel actors, tags;
	
	
	private JPanel createGeneralPanel(){
		JPanel panel = new JPanel();	
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panel.setLayout(new GridLayout(0,1));
		
		/**
		 * Basic Info Panel.
		 */
		JPanel basicInfo = new JPanel();
		
		basicInfo.setLayout(new GridLayout(0,2));
		
		basicInfo.setBorder(BorderFactory.createTitledBorder("Basic Info")); //TODO: i18n.
		
		JLabel idLabel = new JLabel("ID:");
		JLabel nameLabel = new JLabel("name:");
		JLabel diskTypeLabel = new JLabel("Disk Type:");
		
		idField 		= new JTextField();
		nameField 		= new JTextField();
		diskTypeComboBox 	= createComboBox("VCD","DVD");
		actors              = new CollectionPanel();
		tags                = new CollectionPanel();
		
		actors.setTitle("Actors");
		tags.setTitle("Tags");
		
		
		
		
		
		// Set a preferred size of the fields.
		setSimpleSizes(200, 25, 
				idLabel, idField, 
				nameLabel,nameField, 
				diskTypeLabel,diskTypeComboBox
				
		);
		
		// add to the panel.
		addToContainer(basicInfo,idLabel, idField, 
				nameLabel,nameField, 
				diskTypeLabel,diskTypeComboBox
				);
		
		
		/**
		 * 
		 * 
		 */
		
		
		// add to the general panel.
		addToContainer(panel, basicInfo, actors, tags);
	
		
		return panel;
	}
	
	
	
	
	private JPanel createRentPanel(){
		
		JPanel panel = new JPanel();		
		return panel;
		
	}
	
	private JPanel createMorePanel(){
		JPanel panel = new JPanel();
		
		return panel;
	}
	
	/**
	 * Pass in the DiskInfo to this Dialog for display.
	 * 
	 * @param di
	 */
	public void setData(DiskInfo di){
		this.data = di;
		this.fireDiskInfoUpdated();
	}
	
	
	
	
	/**
	 * Display the updated DiskInfo on the component (dialog). 
	 *
	 */
	private void fireDiskInfoUpdated(){
		
		this.idField.setText(data.getId());
		this.nameField.setText(data.getName());
		//TODO: not finished.
		
	}
	
	
	
}
