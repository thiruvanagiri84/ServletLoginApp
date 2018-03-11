package java4s;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OnServletLogin extends HttpServlet  
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		/*String user=req.getParameter("userName");
		String pass=req.getParameter("userPassword");
		
		String uname = getServletConfig().getInitParameter("santosh");
		String contextuname = getServletContext().getInitParameter("kumar");
		
		pw.print("<font face='verdana'>");

	        //if(user.equals("java4s")&&pass.equals("java4s"))
			if(user.equalsIgnoreCase(contextuname))
			pw.println("Login Success using servlet config parameters...!");
			else
			//pw.println("Login Failed...!");
				//req.getRequestDispatcher("error.jsp").forward(req, res);
	        	res.sendRedirect("error.jsp");
*/	        
		
		 // JDBC driver name and database URL
	    final String DB_URL = "jdbc:derby://localhost:1527/sample;create=true";
	     //  Database credentials
	    String USER = "user";
	    String PASS = "app";
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("org.apache.derby.jdbc.ClientDriver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT prof_id, profname, profemail FROM professional";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      ArrayList<ProfessionalBean> list = new ArrayList<ProfessionalBean>();
		      
		      while(rs.next()){

		         System.out.println("ID: " + rs.getInt("prof_id"));
		         System.out.println("Name: " + rs.getString("profname"));
		         System.out.println("Email: " + rs.getString("profemail"));
		      
		         ProfessionalBean profBean = new ProfessionalBean();
		         
		         profBean.setProfId(rs.getInt("prof_id"));
		         profBean.setProfName(rs.getString("profname"));
		         profBean.setProfEmail(rs.getString("profemail"));
		         
		         list.add(profBean);
		         
		        /* 
		         pw.write(" ID: " + id);
		         pw.write("<br/>");
		         pw.write(" Name: " + profName);
		         pw.write("<br/>");
		         pw.write(" Email: " + ProfEmail);
		         pw.write("<br/>");*/
		      }
		      
		      System.out.println("List Size:: "+list.size());
		      req.setAttribute("profbeanlist", list);
		      
		      req.getRequestDispatcher("showvalues.jsp").forward(req, res);
		      
		   }catch(Exception sqle){
			   sqle.printStackTrace();
		   }
}
}
