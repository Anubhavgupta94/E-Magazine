import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Feedback extends HttpServlet
{
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		
			doPost(req,res);
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
		{
HttpSession session=req.getSession();
		  String id3=(String) session.getAttribute("ID3");
		  String user3=(String) session.getAttribute("user3");
		  String pass3=(String) session.getAttribute("pass3");
		  if(user3 == null || pass3 == null)
		  {
		  
		    res.sendRedirect("../index.html");
			}
			else
			
			{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String subject=req.getParameter("subject");
		String message=req.getParameter("message");
		
		
		String query="insert into feedback values(?,?,?,?)";
		Connection con=DBInfo.getConnection();
		try{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,subject);
			ps.setString(4,message);
			ps.executeUpdate();
			
			res.sendRedirect("../Feedback.html");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
}
