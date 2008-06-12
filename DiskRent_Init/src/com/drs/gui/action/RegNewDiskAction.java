package com.drs.gui.action;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.drs.client.util.ScreenUtil;



public class RegNewDiskAction extends AbstractAction {

	// private DiskTable table;
	private RegDiskDialog dialog;

	public static String name = "登记新碟";

	public RegNewDiskAction(Frame frame) {
		super(name);
		dialog = new RegDiskDialog(frame, name);
	}

	public void actionPerformed(ActionEvent ae) {
		dialog.showAtCenter();
	}
}

class RegDiskDialog extends AbstractDRSDialog {

	private JButton ok, cancel;

	public RegDiskDialog(Frame frame, String title) {
		super(frame, title);

	}

	@Override
	protected void drsInitDialog() {

		// Use a two-column grid layout.

		// GridBag.
		GridBagLayout layout = new GridBagLayout();

		GridBagConstraints constraints = new GridBagConstraints();

		// constraints.anchor = GridBagConstraints.LINE_START;
		// constraints.

		JPanel fieldsPanel = new JPanel();

		fieldsPanel.setLayout(layout);

		// constraints.gridwidth = 2;

		constraints.gridx = 1;
		constraints.gridy = 1;
		fieldsPanel.add(this.idLabel, constraints);

		constraints.gridx = 5;
		constraints.gridy = 1;

		fieldsPanel.add(this.diskIdField, constraints);

		constraints.gridx = 1;
		constraints.gridy = 3;
		fieldsPanel.add(this.nameLabel, constraints);

		constraints.gridx = 5;
		constraints.gridy = 3;
		fieldsPanel.add(this.diskName, constraints);

		ScreenUtil.setSimpleSizes(100, 20, idLabel, nameLabel);
		ScreenUtil.setSimpleSizes(200, 20, diskIdField, diskName);

		// add the panel to the parent panel.

		this.add(fieldsPanel, BorderLayout.CENTER);

		// commands -- OK, Cancel.

		ok = new JButton(new AbstractAction("保存") {

			public void actionPerformed(ActionEvent ae) {
				doSave();
			}
		});

		cancel = new JButton(new AbstractAction("取消") {
			public void actionPerformed(ActionEvent ae) {
				doCancel();
			}
		});
		
		JPanel cmds = new JPanel();
		cmds.add(ok);
		cmds.add(cancel);
		
		this.add(cmds, BorderLayout.SOUTH);

	}

	private void doSave() {
		JOptionPane.showMessageDialog(null, "doSave");

	}

	private void doCancel() {
		this.dispose();

	}

}
