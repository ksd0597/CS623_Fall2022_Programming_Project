package cs623_fall2022_project_team2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectTeam2 {
	public static void main(String args[]) throws SQLException, IOException, 
	ClassNotFoundException {

		System.out.println("Beginning");
		
		// Load the MySQL driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Connect to the default database with credentials
		// Change the port number and database name for MySQL
		String url = "jdbc:mysql://localhost:3306/cs623project";
				
		// MySQL root and password
		String root = "root";
		String password = "cs623";
		Connection connect = DriverManager.getConnection(url, root, password);

		// For atomicity
		connect.setAutoCommit(false);

		// For isolation
		connect.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

		Statement stmtObj = null;
		try {
			// Create statement object to send SQL queries
			stmtObj = connect.createStatement();
			
			// The depot d1 is deleted from Depot and Stock.
			// We have to delete depid d1 from stock and depot.
			// As the depid is foreign key in stock table, we have to perform
			// delete operation on stock table first
			// After that we will perform delete operation on depot table
			
			stmtObj.executeUpdate("DELETE FROM stock WHERE depid='d1'");
			stmtObj.executeUpdate("DELETE FROM depot WHERE depid='d1'");
			
			System.out.println("The depot d1 is deleted from Depot and Stock.");
			
		} catch (SQLException e) {
			System.out.println("An exception was thrown");
			e.printStackTrace();
			
			// For atomicity
			connect.rollback();
			stmtObj.close();
			connect.close();
			return;
		}
		
		// Since autocommit is disabled, we have to manually commit the changes
		connect.commit();
		stmtObj.close();
		connect.close();
		System.out.println("End");
	}
}
