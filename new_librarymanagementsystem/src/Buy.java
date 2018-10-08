
import java.sql.*;

public class Buy {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private int bookID;
	private int memberID;
	private Date dayOfBuyed;//dayofBorrowed
	//private Date dayOfReturn;
	//private String URL = "jdbc:mysql://localhost:3306/library\",\"root\",\"root\"";

	public Buy() {
	}

	public int getBookID() {
		return bookID;
	}

	public int getMemberID() {
		return memberID;
	}

	public Date getDayOfBuyed() {
		return dayOfBuyed;
	}

	/*public Date getDayOfReturn() {
		return dayOfReturn;
	}*/

	public void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Buy.java\n" + cnfe.toString());
		}
		catch (Exception e) {
			System.out.println("Buy.java\n" + e.toString());
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM buys");
			while (resultSet.next()) {
				bookID = resultSet.getInt(1);
				memberID = resultSet.getInt(2);
				dayOfBuyed = resultSet.getDate(3);
				//dayOfReturn = resultSet.getDate(4);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch (SQLException SQLe) {
			System.out.println("Buy.java\n" + SQLe.toString());
		}
	}

	public void update(String Query) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Buy.java\n" + cnfe.toString());
		}
		catch (Exception e) {
			System.out.println("Buy.java\n" + e.toString());
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			statement = connection.createStatement();
			statement.executeUpdate(Query);
			statement.close();
			connection.close();
		}
		catch (SQLException SQLe) {
			System.out.println("Buy.java\n" + SQLe.toString());
		}
	}
}