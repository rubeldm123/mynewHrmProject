package stepDef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class mysqlconnection {

	public static void main(String[] args) throws SQLException {
		
		//jdbc:mysql://"+host+":"+port+"/databasename";
		String host= "localhost";
		String port="3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+ "/OrangHRM", "root", "November786110");
		Statement s=con.createStatement();
		//s.executeQuery("select *from admincri where UserName='Admin'");
		ResultSet rc= 	s.executeQuery("select *from admincri where UserName='Admin'");
		rc.next();
		rc.getString("UserName");
		System.out.println(rc.getString("UserName"));
	}
}
