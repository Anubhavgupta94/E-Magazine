import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.sql.*;
public class NoticeAddType extends HttpServlet
{
 
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
		doPost(req,res);
		
		}
		
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
		
		{
		
  PrintWriter pw=res.getWriter();
  HttpSession session=req.getSession();
		  String id3=(String) session.getAttribute("ID3");
		  String user3=(String) session.getAttribute("user3");
		  String pass3=(String) session.getAttribute("pass3");
		 
		String othertype=req.getParameter("othertype");
	  
	  
	  String query1="insert into noticetype values(?)";
		Connection con=DBInfo.getConnection();
		try{
		PreparedStatement ps1=con.prepareStatement(query1);
		ps1.setString(1,othertype);
		ps1.executeUpdate();
		  res.sendRedirect("PostNotice");
		}
		catch(Exception e)
		 {
		 e.printStackTrace();
		 }
		 
	
	  }
	  
  
  
}