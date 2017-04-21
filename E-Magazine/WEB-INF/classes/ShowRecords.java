import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ShowRecords extends HttpServlet
{
 
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
  PrintWriter pw=res.getWriter();
  
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


pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			pw.println("<head>");
			pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");

			pw.println("<title>Show All Records</title>");
			pw.println("<meta name=\"keywords\" content=\"\" />");
			pw.println("<meta name=\"description\" content=\"\" />");
			pw.println("<link href=\"../tooplate_style.css\" rel=\"stylesheet\" type=\"text/css\" />");

			pw.println("<link rel=\"stylesheet\" href=\"../css/coda-slider.css\" type=\"text/css\" charset=\"utf-8\" />");
			pw.println("<script type=\"text/javascript\">");
			pw.println("function MM_jumpMenu(targ,selObj,restore){ //v3.0");
			  pw.println("eval(targ+\".location='\"+selObj.options[selObj.selectedIndex].value+\"'\");");
			  pw.println("if (restore) selObj.selectedIndex=0;");
			pw.println("}");
			pw.println("</script>");
			
			/* pw.println("<style type=\"text/css\">");
  pw.println("body {");
			
			 pw.println("text-align: center;");
 pw.println("}");
 pw.println("</style>");*/
			pw.println("</head>");
			pw.println("<body>");
				

				pw.println("<div id=\"tooplate_wrapper\">");
			       RequestDispatcher rd=req.getRequestDispatcher("../Sidebar.html");
	   rd.include(req,res);
			        
			        
			       pw.println("<div id=\"content\">");
 
 pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

 pw.println("<center>");
pw.println("<h1>ALL RECORDS</h1>");
 pw.println("<form>");
		   pw.println("<table width=\"200\" border=\"1\" align=\"center\">");
		   pw.println("<tr>");
		     pw.println("<th>id</th>");
		     pw.println("<th>Username</th>");
		     pw.println("<th>Password</th>");
		     pw.println("<th>Usertype</th>");
		     pw.println("<th>Delete</th>");
		     pw.println("<th>Update</th>");
		   pw.println("</tr>");

		   Connection con=DBInfo.getConnection();
		   String query="select * from login";
		   
		   try{
		   PreparedStatement ps=con.prepareStatement(query);
		   ResultSet rs=ps.executeQuery();
		   
		   while(rs.next())
		   {
			String id=rs.getString(1);
			String name=rs.getString(2);
			String pass=rs.getString(3);
			String utype=rs.getString(4);
			
			pw.println("<tr>");
	 pw.println("<td>"+id+"</td>");
	 pw.println("<td>"+name+"</td>");
	 pw.println("<td>"+pass+"</td>");
	 pw.println("<td>"+utype+"</td>");
	 pw.println("<td><a href=Delete?id="+id+">Delete</a></td>");
	 pw.println("<td><a href=Update?id="+id+">Update</a></td>");	 
	 pw.println("</tr>");
			
			
		   }
		   
		   }
		   
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   }
		   
		   
		   
		   
 pw.println("</table>");
 pw.println("</form>");
 pw.println("<BR><a href=AdminSection>BACK</a>");
 pw.println("</center>");
 pw.println("</div>");
			      
			      pw.println("<!--end of content-->");

			pw.println("</div><!-- end of toolplate-wrapper--> ");


			pw.println("<div id=\"footer\">");
			    
				pw.println("<div id=\"social_box\">");
					pw.println("<a href=\"#\"><img src=\"../images/facebook.png\" alt=\"facebook\" /></a>");
			       pw.println(" <a href=\"#\"><img src=\"../images/flickr.png\" alt=\"flickr\" /></a>");
			        pw.println("<a href=\"#\"><img src=\"../images/myspace.png\" alt=\"myspace\" /></a>");
			        pw.println("<a href=\"#\"><img src=\"../images/twitter.png\" alt=\"twitter\" /></a>");
			        pw.println("<a href=\"#\"><img src=\"../images/youtube.png\" alt=\"youtube\" /></a>");
			    pw.println("</div>");
			    
			    pw.println("<div id=\"footer_left\">");
					
					pw.println("Copyright © 2015<a href=\"http://www.ratindia.com/\"> Road Ahead Technologies</a><br />");
					pw.println("Designed by <a href=\"../Anubhav.html\">Anubhav Gupta</a><br />");
			       
			   pw.println(" </div>");
				
			    
			pw.println("</div><!--end of footer-->");

			pw.println("</body>");
			pw.println("</html>");

  }
  }
}