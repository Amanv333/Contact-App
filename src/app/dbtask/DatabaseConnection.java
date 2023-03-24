package app.dbtask;

import java.sql.*;

public class DatabaseConnection {
	private static Connection con;
	
	public static Connection createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Create the object of Driver class
			//factory method-> is used to create the object of class 
			//Gang of 4 design pattern
			//factory design pattern -> known solution of known problem
			//singleton design pattern
			//decorator
			//adapter design pattern
			//MVC design
			//observer design
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_contacts","root","Amanv123@");
			//name or ip address of the machine where database has been installed
			//127.0.0.1->loop back address
			//port no -> logical  num where DB listen
			//connection String or connection url ->"jdbc:mysql://localhost:3306/mycontacts","root","Amanv123@"
		}
		catch(ClassNotFoundException|SQLException c) {
			c.printStackTrace();
		}
		return con;
		
	}
	
	public static void closeConnection() {
		if(con!=null) {
			try {
				con.close();
				System.out.println("connection is closed");
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	//for testing ---->>>
public static void main(String[] args) {
	Connection cn = createConnection();
	System.out.println(cn);
}
}
