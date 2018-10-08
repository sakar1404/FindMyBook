
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class BuyBooks extends JInternalFrame {
	
	private JPanel northPanel = new JPanel();
	
	private JLabel title = new JLabel("BUY BOOK INFORMATION");

	
	private JPanel centerPanel = new JPanel();
	
	private JPanel informationPanel = new JPanel();
	
	private JLabel[] informationLabel = new JLabel[2];
	
	private String[] informationString = {"Enter Book ID:","Current Date:"};
	//for creating an array of JTextField
	private JTextField[] informationTextField = new JTextField[2];
	//for creating the date in the String
	private String date = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new java.util.Date());
	//for creating an array of string to store the data
	private String[] data;

	
	private JPanel buyButtonPanel = new JPanel();
	
	private JButton buyButton = new JButton("Buy");

	
	private JPanel southPanel = new JPanel();
	
	private JButton cancelButton = new JButton("Cancel");

	//for creating an object
	private SBooks book;
	private Members member;
	private Buy buy;

	//for checking the information from the text field
	public boolean isCorrect() {
		data = new String[2];
		for (int i = 0; i < informationLabel.length; i++) {
			if (!informationTextField[i].getText().equals(""))
				data[i] = informationTextField[i].getText();
			else
				return false;
		}
		return true;
	}

	//for setting the array of JTextField to null
	public void clearTextField() {
		for (int i = 0; i < informationTextField.length; i++)
			if (i != 2)
				informationTextField[i].setText(null);
	}

	
	public BuyBooks() {
		
		super("Buy Books", false, true, false, true);
		
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Export1.gif")));
		
		Container cp = getContentPane();

		
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		title.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		northPanel.add(title);
		
		cp.add("North", northPanel);

		
		centerPanel.setLayout(new BorderLayout());
		//for setting the layout for the internal panel
		informationPanel.setLayout(new GridLayout(2, 2, 1, 1));

		
		for (int i = 0; i < informationLabel.length; i++) {
			informationPanel.add(informationLabel[i] = new JLabel(informationString[i]));
			informationLabel[i].setFont(new Font("Tahoma", Font.BOLD, 11));
			if (i == 2) {
				informationPanel.add(informationTextField[i] = new JTextField(date));
				informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
				informationTextField[i].setEnabled(false);
			}
			else {
				informationPanel.add(informationTextField[i] = new JTextField());
				informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
		}
		centerPanel.add("Center", informationPanel);

		
		buyButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		buyButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		buyButtonPanel.add(buyButton);
		
		centerPanel.add("South", buyButtonPanel);
		
		centerPanel.setBorder(BorderFactory.createTitledBorder("Buy a book:"));
		
		cp.add("Center", centerPanel);

		
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		southPanel.add(cancelButton);
		
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		
		cp.add("South", southPanel);

		
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//for checking if there is a missing information
				if (isCorrect()) {
					Thread runner = new Thread() {
						public void run() {
							book = new SBooks();
							member = new Members();
							buy = new Buy();
							book.connection("SELECT * FROM books WHERE BookID = " + data[0]);
							member.Connection("SELECT * FROM members WHERE MemberID = " + data[1]);
							int numberOfAvailbleBooks = book.getNumberOfAvailbleBooks();
							int numberOfBuyedBooks = 1 + book.getNumberOfBuyedBooks();
							int numberOfBooks = 1 + member.getNumberOfBooks();
							//for checking if there is no same information in the database
							if (numberOfAvailbleBooks == 1) {
								numberOfAvailbleBooks -= 1;
								book.update("UPDATE books SET NumberOfAvailableBooks =" + numberOfAvailbleBooks +
								        ",NumberOfBuyedBooks =" + numberOfBuyedBooks + ",Available = false WHERE BookID =" + data[0]);
								member.update("UPDATE members SET NumberOfBooks = " + numberOfBooks + " WHERE MemberID = " + data[1]);
								buy.update("INSERT INTO buys (BookID, MemberID, DayOfBuy) VALUES (" +
								        data[0] + "," + data[1] + ",'" + data[2] + "')");
								//for setting the array of JTextField to null
								clearTextField();
							}
							else if (numberOfAvailbleBooks > 1) {
								numberOfAvailbleBooks -= 1;
								book.update("UPDATE books SET NumberOfAvailableBooks =" + numberOfAvailbleBooks +
								        ",NumberOfBuyedBooks =" + numberOfBuyedBooks + " WHERE BookID =" + data[0]);
								member.update("UPDATE members SET NumberOfBooks =" + numberOfBooks + " WHERE MemberID =" + data[1]);
								buy.update("INSERT INTO buys (BookID, MemberID, DayOfBuy) VALUES (" +
								        data[0] + "," + data[1]  + "')");
								//for setting the array of JTextField to null
								JOptionPane.showMessageDialog(null, "Purchase Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
								clearTextField();
							}
							else
								JOptionPane.showMessageDialog(null, "The book is Not Available", "Warning", JOptionPane.WARNING_MESSAGE);
						}
					};
					runner.start();
				}
				//if there is a missing data, then display Message Dialog
				else
					JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		//for adding the action listener for the button to dispose the frame
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		//for setting the visible to true
		setVisible(true);
		//show the internal frame
		pack();
	}
}