package com.drs.client.test;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

import java.awt.*;
import java.util.*;
import static java.lang.System.out;
/**
 * Construct a Popup test program.
 * 
 * 
 * @author mzx0cd
 *
 */
public class PopupTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Runnable doRun = new Runnable(){
			public void run(){
				MyFrame frame = new MyFrame();
				MyMagicDialog dlg = new MyMagicDialog(frame);
				KeyListener kl = new KeyMagicListener(dlg);
				frame.addKeyListener(kl);
				frame.setVisible(true);
			}
			
		};
		
		SwingUtilities.invokeLater(doRun);
		
		
	}

}


class MyFrame extends JFrame {
	
	MyFrame(){
		this.setTitle("¼üÅÌ¾«ÁéÄ£Äâ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setSize(300, 400);
				
		
	}
	
	
	
	
}

class KeyMagicListener extends KeyAdapter {

	private boolean dialogShown = false;
	private MyMagicDialog dialog;
	KeyMagicListener(MyMagicDialog dialog ){
		
		this.dialog = dialog;
	}

	public void keyTyped(KeyEvent e) {
		char ch = e.getKeyChar();
		out.printf("Key Typed:%s%n", ch);	
		
		if( !dialogShown){
			
			
			// show the dialog.
			/* and the input focus should be transferred
			 * to that dialog.
			*/
			
			// adjust the place of the dialog.
			JFrame owner = (JFrame)dialog.getOwner();
			
			out.println("The class of object 'owner':" + owner.getClass().getName());
			// pass the key char to the dialog input text field.
			dialog.setFilterText(ch);
			
			// set the location of the dialog.
			// get the right-bottom point of the parent's client area.
			
			Rectangle rect1 = owner.getBounds(); // the rect of the owner.
			
			
			Point p = new Point();
			p.x = rect1.x + rect1.width - dialog.getWidth() - 10;
			p.y = rect1.y + rect1.height - dialog.getHeight() - 10;
			
			out.printf("Dialog Location:[%d,%d]%n", p.x, p.y );
			dialog.setLocation(p);
				
			// make sure the input focus is on the input field
			// every time it is visible.
		
			dialog.pack();
			dialog.setVisible(true);
			
			//dialogShown = true;
			
		}else {
			// the focus should be on the input text field of the pop up.
			
		}
		
	
	}
	
	
	
	
}

class MyMagicDialog extends JDialog {
	
	private JTextField input;
	private JList    list;
	private MyListModel listModel;
	
	MyMagicDialog(Frame owner){
		super(owner, true);
		this.setTitle("¼üÅÌÐ¡¾«Áé");
		// init the components on this dialog.
		initComponents();
		
		// ensure the input textfield gains the focus whenever the window gains th focus.
		this.addWindowFocusListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				list.transferFocus();
				MyMagicDialog.this.dispose();
			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
				// start filter here.
				
				filterByCode(input.getText());
			}
			
			
		
		});
		
	}
	
	private void initComponents(){
		input = new JTextField();
		
		input.getDocument().addDocumentListener(new DocumentListener(){

			public void changedUpdate(DocumentEvent e) {
				
				filterByCode(input.getText());
			}

			public void insertUpdate(DocumentEvent e) {
				changedUpdate(e);
			}

			public void removeUpdate(DocumentEvent e) {
				changedUpdate(e);
			}
			
		});
		
		list  = new JList(listModel);

		add(input, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
				
		this.pack(); // This is very important call. It "realizes" the window related OS resources.
	}
	
	
	public void setFilterText(char ch){
		this.input.setText(String.valueOf(ch));
		// request focus for this control.
		
		
		this.input.requestFocusInWindow();
		// cause the input key event.
	
	}
	
	/**
	 * filter the list data by the code input.
	 * @param code
	 */
	private void filterByCode(String code){
		out.printf("filter using [%s]%n", code);
		// update the list data... list model.
	}
	
}


/**
 * The data of this list can be from database.
 * 
 * Here we just mock some data.
 * 
 * Since the input text will be used to filter the data
 * in the list, we will change the model frequently.
 * 
 * 
 * 
 * @author mzx0cd
 *
 */
class MyListModel extends AbstractListModel {

	
	
	
// Methods required by the interface.	
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
// Methods for my app.
	
	
}

