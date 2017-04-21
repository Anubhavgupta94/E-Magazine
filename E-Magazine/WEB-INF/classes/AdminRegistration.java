import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class AdminRegistration extends HttpServlet
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
		  String id="";
		  for(int i=0;i<9;i++)
		  {
		   id+=(int)(Math.random()*9)+1;
		  }
		  System.out.println(id);
				
		String name=req.getParameter("name");
		String uname=req.getParameter("uname");
		String pass1=req.getParameter("pass");
		String repass=req.getParameter("repass");
		String email=req.getParameter("email");
		String dob=req.getParameter("dob");
		String occupation=req.getParameter("occupation");
		
		String prinum=req.getParameter("prinum");
		String secnum=req.getParameter("secnum");
		String add=req.getParameter("add");
		
		String query="insert into adminrecord values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection con=DBInfo.getConnection();
		try{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,id);
			ps.setString(3,pass1);
			ps.setString(4,repass);
			ps.setString(5,email);
			ps.setString(6,dob);
			ps.setString(7,occupation);
			ps.setString(8,prinum);
			ps.setString(9,secnum);
			ps.setString(10,add);
			ps.setString(11,uname);
			ps.executeUpdate();
		
			res.sendRedirect("../RegistrationDoneAdmin.html");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String utype="Admin";
		String query2="insert into login values(?,?,?,?)";
		try
		  {
		  PreparedStatement ps=con.prepareStatement(query2);
		  ps.setString(1,id);
		  ps.setString(2,uname);
		  ps.setString(3,pass1);
		  ps.setString(4,utype);
		  ps.executeUpdate();
		  }
		catch(Exception e)
		  {
		  e.printStackTrace();
		  }
	}

	}
}
