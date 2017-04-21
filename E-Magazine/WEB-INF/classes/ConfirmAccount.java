import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ConfirmAccount extends HttpServlet
{
  String usertype;
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
  PrintWriter pw=res.getWriter();
 

 pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			pw.println("<head>");
			pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");

			pw.println("<title>Confirm Account Page</title>");
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
			
			/*pw.println("<style type=\"text/css\">");
  pw.println("body {");
			
			 pw.println("text-align: center;");
 pw.println("}");
 pw.println("</style>");*/
 
			pw.println("</head>");
			pw.println("<body>");
				

				pw.println("<div id=\"tooplate_wrapper\">");
					RequestDispatcher rd = req.getRequestDispatcher("../Sidebar.html");
	   rd.include(req,res);
			        
			        
			       pw.println("<div id=\"content\">");
 
  String s1=req.getParameter("uname");
  String s2=req.getParameter("pass");

	  Connection con=DBInfo.getConnection();
	  String query="select * from login where username=? and password=?";
	  int flag=0;
		  try
		  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1,s1);
		  ps.setString(2,s2);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
		   flag=1;
		   usertype=rs.getString("usertype");
		  }
		 	
		 }
			catch(Exception e)
			{
			e.printStackTrace();
			}	
			
if(flag==1 && usertype.equalsIgnoreCase("admin"))
			  res.sendRedirect("PostNoticeAll");			  
if(flag==1 && usertype.equalsIgnoreCase("student"))
			 res.sendRedirect("PostNoticeAll");			  
if(flag==1 && usertype.equalsIgnoreCase("faculty"))
			  res.sendRedirect("PostNoticeAll");
if(flag==1 && usertype.equalsIgnoreCase("alumni"))
			  res.sendRedirect("PostNoticeAll");
if(flag==1 && usertype.equalsIgnoreCase("others"))
			  res.sendRedirect("PostNoticeAll");
			  
if(flag==0)
	res.sendRedirect("../ConfirmAccount.html");
	  
  
 
 
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
					
					pw.println("Copyright � 2015<a href=\"http://www.ratindia.com/\"> Road Ahead Technologies</a><br />");
					pw.println("Designed by <a href=\"../Anubhav.html\">Anubhav Gupta</a><br />");
			       
			   pw.println(" </div>");
				
			    
			pw.println("</div><!--end of footer-->");

			pw.println("</body>");
			pw.println("</html>");

  }
  
}