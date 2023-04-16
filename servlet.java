import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class servlet implements Servlet{
	public void init(ServletConfig h){}
	public void service(ServletRequest req,ServletResponse res)throws ServletException, IOException{
	
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter("fullname");
	String name=req.getParameter("usrname");
	String name=req.getParameter("emailid");
	String name=req.getParameter("mobilenumber");
	String name=req.getParameter("passw");
        String name=req.getParameter("confirmpass");
	try{ 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,username);
		ps.setString(3,email id);
		ps.setString(4,mobile number);
		ps.setString(5,password);
		ps.setString(6,confirm password);
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.include(req,res);
		pw.println("<br> Hey "+name+" you are registered successfully");
	   }
	   catch(Exception e){
      		System.out.println(e);
		}
	   pw.close();
 }
  public void destroy(){}
  
   public String getServletInfo()
   {
	return(null);
   }
   public ServletConfig getServletConfig()
     {
	return(null);
     }
}