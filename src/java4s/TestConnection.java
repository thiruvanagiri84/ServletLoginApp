package java4s;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
	public static void main(String a[]){

		 // JDBC driver name and database URL
		    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		    final String DB_URL = "jdbc:derby://localhost:1527/sample;create=true";

		   //  Database credentials
		    String USER = "user";
		    String PASS = "app";
		   
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("org.apache.derby.jdbc.ClientDriver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      /*sql = "SELECT id, first, last, age FROM Employees";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
*/		   }catch(Exception sqle){
			   sqle.printStackTrace();
		   }

	}
}
