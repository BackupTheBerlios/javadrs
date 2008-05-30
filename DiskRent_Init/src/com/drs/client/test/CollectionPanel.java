package com.drs.client.test;

import javax.swing.*;

import java.awt.Component;

import java.util.*;

import static com.drs.client.util.ScreenUtil.*;

/**
 * The CollectionPanel is a swing panel used to display a collection (or a set)
 * of objects.
 * 
 * It's much better to implement a View-Model pattern from the perspective of
 * design. However, I'll only implment a simple one at the current phase.
 * 
 * 
 * @author mzx0cd
 * 
 */
public class CollectionPanel extends JPanel {

	public static enum Style {
		VERTICAL_LIST, HORIZONTAL_LIST
	}

	private Style style = Style.HORIZONTAL_LIST;

	private List data;

	//private Class<? extends Component> elementComponentClass;

	public CollectionPanel() {
		data = new ArrayList();
		initPanel();

	}
	
	public void setTitle(String title){
		this.setBorder(BorderFactory.createTitledBorder(title));
	}

	public CollectionPanel(Object... objects) {
		data = Arrays.asList(objects);
		initPanel();
	}

	/**
	 * Display the elements on the Panel.
	 * TODO: now we only use JLabel to show the elements, a better and 
	 * more flexible way should be achieved later.
	 * 
	 * 
	 */
	private void initPanel() {

		try {
			for (Object obj : data) {

				//Component p = elementComponentClass.newInstance();
				JLabel txt = new JLabel(obj.toString());
				add(txt);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
