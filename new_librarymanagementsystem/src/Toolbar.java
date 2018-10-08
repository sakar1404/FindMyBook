
//import the packages for using the classes in them into the program

import javax.swing.*;

public class Toolbar extends JToolBar {
    
	//for creating the buttons to use them in ToolBar
	public JButton[] btn;
	//for creating the name of the image file 24*24
	public String[] imgName5 = {"images/f.gif", "images/a.gif","images/aa.gif","images/b.gif","images/i.gif","images/g.gif",  "images/c.gif",                                                                  
	                               "images/d.gif",
	                               "images/x.gif"};
	//for creating the tipText for the toolbar
	public String[] tipText = {"Add Books To Lend","Add Books To Sell", "Borrow Books", "Buy Books", "List Books", "List Books to Sell"                         
	                           , "Search","Return Books","Exit"};
	public Toolbar() {
		btn = new JButton[19];
		for (int i = 0; i < imgName5.length; i++) {
			if (i == 2||i==4 || i == 5|| i==6)
			//for adding separator to the toolBar
				addSeparator();
			//for adding the buttons to toolBar
			add(btn[i] = new JButton(new ImageIcon(ClassLoader.getSystemResource(imgName5[i]))));
			//for setting the ToolTipText to the button
			btn[i].setToolTipText(tipText[i]);
		}
	}
}