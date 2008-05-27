package com.drs.client.test;

import javax.swing.*;
import java.awt.*;


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
	
	private JPanel createGeneralPanel(){
		JPanel panel = new JPanel();	
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
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
	
	
}
