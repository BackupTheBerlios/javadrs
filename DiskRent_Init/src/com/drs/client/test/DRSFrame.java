package com.drs.client.test;

import java.util.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.table.*;
/**
 * There is another option: run the app as a plugin of eclipse or netbeans.
 * 
 * Here we want to use a separate simple custom UI as the main UI Frame.
 *  
 * Menu:
 * Toolbar: or rebar...
 * Client Area.
 * 
 * @author mzx0cd
 *
 */
public class DRSFrame extends JFrame {
	
	private JTextField qt;
	private DiskTable table;
	private DiskTableModel dtm;
	
	public DRSFrame()
	{
		setupFrame();
		setJMenuBar(setupMenu());
		
		/**
		 * Add a Toolbar.
		 * 
		 */
		
		this.add(setupToolBar(),BorderLayout.NORTH);
				
		/**
		 * Add Content Panel. 
		 * 
		 */
		
		/**
		 * compose the function.
		 *  qt and table are all initialized.
		 */
		dtm = new DiskTableModel();
		java.util.List<DiskInfo> list = 
			DiskInfoTest.createTestData();
		dtm.setData(list);
		
		table = new DiskTable(this,dtm);
		
	
		
//		getContentPane().add(controlPanel, BorderLayout.NORTH);				
		getContentPane().add(initContentPanel(), BorderLayout.CENTER);
		
		
		setupQueryAction();
		
		
		pack();		
		
	
	}
	
	/**
	 * When the text of qt changed,
	 * the contents of the table will 
	 * change accordingly.
	 *
	 */
	
	private void setupQueryAction(){
		
		qt.getDocument().addDocumentListener( new DocumentListener(){

		
			public void changedUpdate(DocumentEvent e) {
				
				onQuery(qt.getText());
			}

			public void insertUpdate(DocumentEvent e) {
				onQuery(qt.getText());
				
			}

			public void removeUpdate(DocumentEvent e) {
				onQuery(qt.getText());
				
			}
			
			
		});
	}
	
	/**
	 *  Get Data from Data Source according to the condition "c",
	 *  and then update the data model of the displaying table.
	 * 
	 * 
	 * @param c
	 */
	private void onQuery(String c){
	
		dtm.setData(DiskInfoTest.filter(DiskInfoTest.createTestData(),c));
		
		

	}
	
	
	
	
	private void setupFrame(){
//		TODO: This is improper!!! we will have to check if there is anything unsaved.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 		
		
		//this.setSize(this.getMaximumSize());
		setBounds(calculateDefaultBounds());
		setTitle("DRS System"); //TODO: needs to be i18ned.
	}
	
	private Component initContentPanel(){
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setAutoscrolls(true);
		
		table.setBorder(BorderFactory.createLoweredBevelBorder());
		table.setPreferredSize(new Dimension(1024,768));
		
		table.setRowMargin(5);
		table.setRowHeight(30);
		table.setRowHeight(0, 60);
		
		
		
		return scrollPane;
	}
	
	/**
	 * 
	 * @return
	 */
	private Rectangle calculateDefaultBounds(){
		Rectangle rect = new Rectangle();
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// left -top 
		rect.x = 10;
		rect.y = 10;
		rect.width = Double.valueOf(scrSize.width * 0.9).intValue();
		rect.height =Double.valueOf( scrSize.height * 0.9).intValue();
		
		return rect;		
	}
	
	/**
	 * Setup the menu of the system.
	 *  
	 *  
	 * 
	 * 
	 * 
	 * @return
	 */
	
	private JMenuBar setupMenu(){
		JMenuBar menubar = new JMenuBar();
		
		JMenu sysConfig = new JMenu("Sys Config"); //TODO: i18n. 
		
		setupMenuSysConfig(sysConfig);
		
		JMenu diskMng   = new JMenu("Disk Manager"); //TODO: i18n.
		setupMenuDiskMng(diskMng);
		JMenu dataMng   = new JMenu("Data Manager");
		setupMenuDataMng(dataMng);
		JMenu help      = new JMenu("Help");
		setupMenuHelp(help);
		menubar.add(sysConfig);
		menubar.add(diskMng);
		menubar.add(dataMng);
		menubar.add(help);
				
		return menubar;
	}
	
	private void setupMenuSysConfig(JMenu menu){
		
	}
	
	private void setupMenuDiskMng(JMenu menu){
		
	}
	
	private void setupMenuDataMng(JMenu menu){
		
	}
	
	private void setupMenuHelp(JMenu menu){
		
	}
	
	private JToolBar setupToolBar(){
		JToolBar bar= new JToolBar();
		bar.setFloatable(false);
		bar.setBackground(Color.blue);
		
		qt = new JTextField();
		qt.setPreferredSize(new Dimension(80,20));
		qt.setMaximumSize(new Dimension(200,25));
		JButton b1 = new JButton("Register New Disk");
		JButton b2 = new JButton("Collect Old Disks");
		
		bar.addSeparator(new Dimension(5,20));
		bar.add(qt);
		bar.addSeparator(new Dimension(5,20));
		bar.add(b1);
		bar.addSeparator(new Dimension(5,20));
		bar.add(b2);
		
		return bar;
		
	}
		
}

