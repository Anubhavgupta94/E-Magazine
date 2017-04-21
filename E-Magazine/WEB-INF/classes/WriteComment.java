import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.sql.*;
public class WriteComment extends HttpServlet
{
 
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
  PrintWriter pw=res.getWriter();
		HttpSession session=req.getSession();
		  String id3=(String) session.getAttribute("ID3");
		  String user3=(String) session.getAttribute("user3");
		  String pass3=(String) session.getAttribute("pass3");
		  
			
			
			 // String no=req.getParameter("idd");
			 // System.out.println("Write-------- "+no);

			//HttpSession session=req.getSession();
			//String no=(String)session.getAttribute("articleid");
			//String id=(String)session.getAttribute("id");
			//String username=(String)session.getAttribute("username");
			//String usertype=(String)session.getAttribute("usertype");
			String no=req.getParameter("articleid");
			String id=req.getParameter("id");
			String username=req.getParameter("username");
			String usertype=req.getParameter("usertype");
			System.out.println("articleid is"+no);
			System.out.println("Studentid is"+id);
			System.out.println("username is"+username);
			System.out.println("usertype is"+usertype);
			
			pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			pw.println("<head>");
			pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");

			pw.println("<title>Write Comment Page</title>");
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
			pw.println("</head>");
			pw.println("<body>");
				

				pw.println("<div id=\"tooplate_wrapper\">");
			       RequestDispatcher rd=req.getRequestDispatcher("../Sidebar.html");
	   rd.include(req,res);
			        
					
			       pw.println(" <div id=\"content\">");
				   pw.println("<center>");
      pw.println(" <form method=post>");
        
		 pw.println("<table align=\"center\" width=\"501\" border=\"0\">");
            pw.println("<tr>");
              pw.println("<td align=\"center\" colspan=\"4\"><h1>WRITE COMMENT</h1></td>");
           pw.println(" </tr>");
            pw.println("<tr>");
              pw.println("<td width=\"111\">Article Number</td>");
             pw.println("<td colspan=\"3\"><label for=\"no\"></label>");
              pw.println("<input type=\"text\" name=\"no\" id=\"no\" readonly=\"true\" value="+no+" /></td>");
            pw.println("</tr>");
            pw.println("<tr>");
              pw.println("<td>User ID</td>");
             pw.println(" <td colspan=\"3\"><label for=\"id\"></label>");
              pw.println("<input type=\"text\" name=\"id\" id=\"id\" readonly=\"true\" value="+id+" /></td>");
           pw.println(" </tr>");
		   
		   pw.println("<tr>");
             pw.println(" <td>Username</td>");
             pw.println(" <td colspan=\"3\"><label for=\"username\"></label>");
             pw.println(" <input type=\"text\" name=\"username\" id=\"usertype\" readonly=\"true\" value="+username+" /></td>");
          pw.println("  </tr>");
		   
            pw.println("<tr>");
             pw.println(" <td>Usertype</td>");
             pw.println(" <td colspan=\"3\"><label for=\"usertype\"></label>");
             pw.println(" <input type=\"text\" name=\"usertype\" id=\"usertype\" readonly=\"true\" value="+usertype+" /></td>");
          pw.println("  </tr>");
          
            pw.println("<tr>");
             pw.println(" <td valign=\"top\">Comment</td>");
              pw.println("<td colspan=\"3\"><label for=\"comment\"></label>");
              pw.println("<textarea name=\"comment\" id=\"comment\" cols=\"40\" rows=\"5\"></textarea></td>");
            pw.println("</tr>");
             pw.println("<tr>");
              pw.println("<td width=\"111\">&nbsp;</td>");
             pw.println(" <td width=\"314\">&nbsp;</td>");
             pw.println(" <td width=\"2\">&nbsp;</td>");
              pw.println("<td width=\"56\">");
            pw.println("<tr align=\"center\">");
              pw.println("<td colspan=\"4\"><input type=\"image\" name=\"login\" id=\"login\" src=\"../images/New folder/submit.jpg\" width=\"130\" height=\"40\" alt=\"submit\" /></td>");
           pw.println(" </tr>");
         pw.println(" </table>");
		
       pw.println("</form>");
	   pw.println("<BR><a href=AllArticleNew>BACK</a>");
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
  
  
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
  {	
		PrintWriter pw=res.getWriter();
		  
		  String articleno=req.getParameter("no");
		  String userid=req.getParameter("id");
		  String usertype=req.getParameter("usertype");
		  String username=req.getParameter("username");
		   String comment=req.getParameter("comment");
		  
		  String query="insert into commentinfo values(?,?,?,?,?)";
		  Connection con=DBInfo.getConnection();
		  
		  try
		  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1,articleno);
		  ps.setString(2,userid);
		  ps.setString(3,usertype);
		  ps.setString(4,comment);
		  ps.setString(5,username);
		  
		  ps.executeUpdate();
	}  
		  catch(Exception e)
		  {
		  e.printStackTrace();
		  }
  
		res.sendRedirect("AllArticleNew");
}
}