package org.sdet40.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


public class DatabaseUtility {
	Connection connection;
	public List<String> getDataFromDatabase(String query, String  ColumnName) throws SQLException
	{
	 Statement statement = connection.createStatement();	
	  ResultSet result = statement.executeQuery(query);
	  List<String> list = new ArrayList<>();
	  while(result.next())
	  {
		  list.add(result.getString(ColumnName));
	  }
	return list;
	}


public void openDBConnection(String dbURL, String dbUserName, String dbPassword)  {
		 Driver dbdriver = null;
		try {
			dbdriver = new Driver();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	try {
		DriverManager.registerDriver(dbdriver);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	try {
		connection= DriverManager.getConnection(dbURL, dbUserName, dbPassword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}