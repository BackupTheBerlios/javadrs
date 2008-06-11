package com.drs.gui.action;

import static com.drs.client.util.ScreenUtil.addToContainer;
import static com.drs.client.util.ScreenUtil.setSimpleSizes;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * a Dialog Window for displaying the
 * details of DiskInfo.
 * 
 * 
 * 
 * @author James Wang
 *
 */
public class DiskInfoDialog extends AbstractDRSDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane;
	
	
	public DiskInfoDialog(Frame frame, String title){
		super(frame, title);
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
	protected void drsInitDialog(){
		
		
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
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		cmdPanel.add(closeButton, BorderLayout.EAST);

		getContentPane().add(cmdPanel, BorderLayout.SOUTH);	
		
	}
	
	private void initTabbedPane(){
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		generalPanel = createGeneralPanel();
//		rentPanel    = createRentPanel();
//		morePanel    = createMorePanel();
//		
		jTabbedPane.addTab(TAB_GENERAL, generalPanel);
//		jTabbedPane.addTab(TAB_RENT, rentPanel);
//		jTabbedPane.addTab(TAB_MORE, morePanel);
			
	}
	
	
	
	
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
		
		
		
		
		
		
		// Set a preferred size of the fields.
		setSimpleSizes(200, 25, 
				idLabel, diskIdField, 
				nameLabel,diskName, 
				diskTypeLabel,diskTypeComboBox
				
		);
		
		// add to the panel.
		addToContainer(basicInfo,idLabel, diskIdField, 
				nameLabel,diskName, 
				diskTypeLabel,diskTypeComboBox
				);
	
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
		
}
