import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.sql.*;
public class OthersSection extends HttpServlet
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

pw.println("<title>Others Section</title>");
pw.println("<meta name=\"keywords\" content=\"\" />");
pw.println("<meta name=\"description\" content=\"\" />");
pw.println("<link href=\"../tooplate_style.css\" rel=\"stylesheet\" type=\"text/css\" />");

pw.println("<link rel=\"stylesheet\" href=\"../css/coda-slider.css\" type=\"text/css\" charset=\"utf-8\" />");


pw.println("</head>");
pw.println("<body>");
	
pw.println("<div id=\"slider\">");
	pw.println("<div id=\"tooplate_wrapper\">");
        RequestDispatcher rd=req.getRequestDispatcher("../Sidebar.html");
	   rd.include(req,res);
        
       pw.println("<div id=\"content\">");
     pw.println("<div class=\"scroll\">");
           pw.println(" <div class=\"scrollContainer\">");
          
		  
		  
		  
		  pw.println("<table width=\"496\" height=\"315\" border=\"0\" align=\"center\">");
			pw.println("<tr>");
			pw.println(" <td width=\"490\" height=\"75\" align=\"center\"><h1>OTHERS SECTION</h1></td>");
		  pw.println("</tr>");
			

			 pw.println("<tr>");
			pw.println(" <td height=\"40\"><a href=\"PostArticleOthers\">Post an Article</a></td>");
			pw.println(" </tr>");
			pw.println("<tr>");
			pw.println(" <td height=\"41\"><a href=\"AllArticleNew\">View/Search an Article</a></td>");
		  pw.println("</tr>");
			pw.println("<tr>");
			pw.println(" <td height=\"41\"><a href=\"AllArticleNew\">Like an Article</a></td>");
		 pw.println(" </tr>");
         pw.println(" <tr>");
			pw.println(" <td height=\"41\"><a href=\"../ConfirmAccount.html\">Write a Notice</a></td>");
		  pw.println("</tr>");
          pw.println(" <tr>");
			pw.println(" <td height=\"41\"><a href=\"AllNoticeNew\">View/Search a Notice</a></td>");
		  pw.println("</tr>");
			pw.println("<tr>");
			pw.println(" <td height=\"34\"><a href=\"../Feedback.html\">Feedback</a></td>");
			pw.println("</tr>");
			//pw.println("<tr>");
			// pw.println("<td height=\"34\"><a href=\"UpdateOthersInfo\">Update Profile</a></td>");
			//pw.println("</tr>");
			pw.println("<tr>");
			pw.println("  <td height=\"34\"><a href=\"Logout\">Log Out</a></td>");
		  pw.println("</tr>");
pw.println("</table>");
			  
      pw.println("</div><!--end of scroll container-->");
         pw.println("</div><!-- end of scroll -->");
		pw.println("</div>");
		
		
		
    pw.println("</div> <!-- end of content -->");
pw.println("</div> <!-- end of toolplate-wrapper-->");


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
  
}}