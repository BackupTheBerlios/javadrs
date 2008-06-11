package com.drs.gui.action;

import static com.drs.client.util.ScreenUtil.addToContainer;
import static com.drs.model.RentInfo.KEY_DEPOSIT;
import static com.drs.model.RentInfo.KEY_DISKNUM;
import static com.drs.model.RentInfo.KEY_TXDATE;
import static com.drs.model.RentInfo.fieldDescs;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.drs.biz.DepositService;
import com.drs.gui.DiskTable;
import com.drs.model.DiskInfo;
import com.drs.model.RentInfo;

/**
 * The Rent Action encapsulates the Renting action, which will be used by popup
 * menus, toolbars, and menubars.
 * 
 * 
 * @author James Wang
 * 
 */
public class RentDiskAction extends AbstractAction {

	private RentDiskDialog dlg; // reference to the frame.

	private DiskTable table;

	public static String name="�����Ƭ";
	public RentDiskAction(DiskTable tb) {
		
		super(name);
		table = tb;
		dlg = new RentDiskDialog(table.getFrame(), name);
	}

	public void actionPerformed(ActionEvent e) {
		
		if( table.getSelectedRow() == -1 )
		{
			JOptionPane.showMessageDialog( (Component) e.getSource(), "����ѡ��һ����Ƭ", "����", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		
		dlg.setData(table.getSelectedDisk());
		dlg.showAtCenter();
	}

}

/**
 * This Dialog will be used by the RentDiskAction. It displays Disk-renting
 * information, input boxes, and commands.
 * 
 * 
 */
class RentDiskDialog extends AbstractDRSDialog {

	/**
	 * Panels for displaying Data in groups.
	 * 
	 */
	private JPanel relatedDiskInfoPanel; // RentDisk related disk info.

	private JPanel rentInfoPanel; // Rent Info.

	private JPanel commandsPanel; // commands.

	
	private RentInfo rentInfo = new RentInfo();
	/**
	 * Controls for showing/editing individual data items.
	 */

	/**
	 * 
	 * @param frame
	 * @param title
	 * @param modal
	 */

	RentDiskDialog(Frame frame, String title) {
		super(frame, title);
		
	}

	/**
	 * set the data into this dialog for displaying.
	 * 
	 * @param di
	 */
	@Override
	public void setData(DiskInfo di) {
		super.setData(di);

		// calculate default renting data and populate them.
		setDefaultRentingValues();
	}

	private void setDefaultRentingValues() {
		// TODO: calculate default renting values and display them.
		
		// Default Transaction Date (txDate): today.
		Date today = new Date();		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");		
		this.txDateField.setText(sdf.format(today));
		this.rentInfo.set(RentInfo.KEY_TXDATE, txDateField.getText());
		
		// Default Disk No.
		this.diskNumField.setText("2");
		rentInfo.set(RentInfo.KEY_DISKNUM, diskNumField.getText());
		this.diskNumField.requestFocusInWindow();
		
		
		// Default Deposit money.
		DepositService.calculateDefaultDeposit(data, rentInfo);
		
		this.depositField.setText(rentInfo.get(RentInfo.KEY_DEPOSIT));
	}

	/**
	 * create the rentDisk dialog.
	 * 
	 */
	@Override
	protected void drsInitDialog() {
		/**
		 * Init the 3 panels.
		 */
		relatedDiskInfoPanel = new JPanel();
		rentInfoPanel = new JPanel();
		commandsPanel = new JPanel();

		initRelatedDiskInfo();
		initRentInfo();
		initCommands();

		setLayout(new GridLayout(0, 1, 2, 2));
		addToContainer(this, relatedDiskInfoPanel, rentInfoPanel, commandsPanel);
	}

	/**
	 * Init rent related DiskInfo.
	 * 
	 */
	private void initRelatedDiskInfo() {

		GridLayout grid = new GridLayout(0, 2, 2, 2);
		relatedDiskInfoPanel.setLayout(grid);

		addToContainer(relatedDiskInfoPanel, this.idLabel, this.diskIdField,
				this.diskTypeLabel, this.diskTypeComboBox, this.nameLabel,
				this.diskName, new JLabel("Disk Tags:"), this.tags);

	}

	private void initRentInfo() {
		GridLayout grid = new GridLayout(0, 2, 2, 2);
		rentInfoPanel.setLayout(grid);

		txDateField = new JTextField();
		diskNumField = new JTextField();
		depositField = new JTextField();

		addToContainer(rentInfoPanel,
				new JLabel(fieldDescs.getProperty(KEY_TXDATE)), txDateField,
				new JLabel(fieldDescs.getProperty(KEY_DISKNUM)), diskNumField,
				new JLabel(fieldDescs.getProperty(KEY_DEPOSIT)), depositField

		);

	}

	private void initCommands() {

		JButton rentButton = new JButton("Rent");
		JButton exitButton = new JButton("Exit");

		addToContainer(commandsPanel, rentButton, exitButton);

		rentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				doRent();
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				doExit();
			}
		});

	}

	/**
	 * Rent related input fields.
	 */
	private JTextField txDateField, diskNumField, depositField;

	private JButton rentButton, exitButton;

	private void doRent() {
		JOptionPane.showMessageDialog(null, "Renting");
		// TODO: Actual Renting operation.
		
		// Begin Transaction.
		
		// Update DiskInfo.
		// Update RentInfo.
		
		// Persist Updates.
		
		
		// End Transaction
		
		// dialog disposed.
		this.dispose();
	}

	private void doExit() {
		// TODO: cancelled.

		this.dispose();
	}

}
