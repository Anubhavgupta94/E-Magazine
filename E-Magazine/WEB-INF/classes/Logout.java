import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.sql.*;
public class Logout extends HttpServlet
{
 
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
		HttpSession session=req.getSession();
		String id=(String) session.getAttribute("ID");
		
		
        session.invalidate();
		res.sendRedirect("../index.html");
   }
}