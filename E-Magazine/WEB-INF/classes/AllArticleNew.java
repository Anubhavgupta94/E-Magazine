import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.sql.*;
public class AllArticleNew extends HttpServlet
{
 
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
  PrintWriter pw=res.getWriter();
 
  
		
			pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
pw.println("<head>");
pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");

pw.println("<title>All Articles</title>");
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
          
		  pw.println(" <table align=\"center\" width=\"444\" border=\"0\">");
                 pw.println(" <tr>");
                   pw.println(" <td align=\"center\" colspan=\"3\"><h1><strong>ALL ARTICLES</strong></h1></td>");
                  pw.println("</tr>");
		  pw.println("<table>");
		  Connection con=DBInfo.getConnection();
		   String query="select * from articleinfo";
		   
		   
		   try{
		   PreparedStatement ps=con.prepareStatement(query);
		   ResultSet rs=ps.executeQuery();
		   
		 while(rs.next())
		 {
		 String no=rs.getString(1);
		 String class1=rs.getString(2);
			String category=rs.getString(3);
			String type=rs.getString(4);
			String date=rs.getString(5);
			String description=rs.getString(6);

			
             pw.println(" <form id=\"form1\" method=\"post\" >");
               pw.println(" <table align=\"center\" width=\"444\" border=\"0\">");
                 //pw.println(" <tr>");
                  // pw.println(" <td align=\"center\" colspan=\"3\"><h1>ALL ARTICLES</h1></td>");
                 // pw.println("</tr>");
				   pw.println("<hr size=\"4\" color=\"#000000\" />");
                  pw.println("<tr>");
                   pw.println(" <td width=\"136\"><strong>Number</strong></td>");
                    pw.println("<td colspan=\"2\"><label for=\"no\"></label>");
                   // pw.println("<input type=\"text\" name=\"no\" id=\"no\" readonly=\"readonly\" value="+no+" /></td>");
                  pw.println(no);
				  pw.println("</td>");
				  pw.println("</tr>");
                  pw.println("<tr>");
                    pw.println("<td><strong>Class</strong></td>");
                    pw.println("<td colspan=\"2\"><label for=\"class\"></label>");
                   // pw.println("<input type=\"text\" readonly=\"readonly\" name=\"class\" id=\"class\" value="+class1+" /></td>");
				   pw.println(class1);
				  pw.println("</td>");
                  pw.println("</tr>");
                  pw.println("<tr>");
                    pw.println("<td><strong>Category</strong></td>");
                    pw.println("<td colspan=\"2\"><label for=\"category\"></label>");
                   //pw.println(" <input type=\"text\" readonly=\"readonly\" name=\"category\" id=\"category\" value="+category+" /></td>");
				   pw.println(category);
				  pw.println("</td>");
                 pw.println(" </tr>");
                  pw.println("<tr>");
                   pw.println(" <td><strong>Type</strong></td>");
                    pw.println("<td colspan=\"2\"><label for='\"type\"'></label>");
                    //pw.println("<input type=\"text\" readonly=\"readonly\" name=\"type\" id=\"type\" value="+type+" /></td>");
					pw.println(type);
				  pw.println("</td>");
                  pw.println("</tr>");
                 pw.println(" <tr>");
                    pw.println("<td><strong>Date</strong></td>");
                   pw.println(" <td colspan=\"2\"><label for=\"date\"></label>");
                  // pw.println(" <input type=\"text\" readonly=\"readonly\" name=\"date\" id=\"date\" value="+date+" /></td>");
				  pw.println(date);
				  pw.println("</td>");
                  pw.println("</tr>");
                  pw.println("<tr>");
                    pw.println("<td valign=\"top\"><strong>Description</strong></td>");
                    pw.println("<td colspan=\"2\"><label for=\"description\"></label>");
                  // pw.println(" <textarea readonly=\"readonly\" name=\"description2\" id=\"description\" cols=\"45\" rows=\"15\"> "+description+" </textarea></td>");
				  pw.println(description);
				  pw.println("</td>");
                  pw.println("</tr>");
                  
				  
				  	pw.println("<tr>");
                    pw.println("<td colspan=\"4\" align=\"center\" bgcolor=\"#D6D6D6\"><strong>All Comments</strong></td>");
                    pw.println("</tr>");

                    
					String query1="select * from commentinfo where articleno="+no+"";
					try{
		   PreparedStatement ps1=con.prepareStatement(query1);
		   ResultSet rs1=ps1.executeQuery();
		   
		 while(rs1.next())
		 {
		 String userid=rs1.getString(2);
		 String uname=rs1.getString(5);
		 String usertype=rs1.getString(3);
			String comment=rs1.getString(4);
			pw.println("<tr>");
                    pw.println("<td colspan=\"3\" ><hr /></td>");
                    pw.println("</tr>");
					pw.println("<tr>");
                    pw.println("<td colspan=\"3\" valign=\"top\"><label for=\"comment\"></label>");
                    pw.println("<div class=\"scroll_n\">");
					pw.println("<div class=\"scrollContainer_n\">");
                    pw.println("<table width=\"444\" border=\"0\">");
							
		                         pw.println(" <td width=\"92\"><strong>Username</strong></td>");
		                          pw.println("<td width=\"128\">"+uname+"</td>");
		                          pw.println("<td width=\"80\"><strong>Usertype</strong></td>");
		                          pw.println("<td width=\"126\">"+usertype+"</td>");
		                    pw.println("</tr>");
		                    pw.println("<tr>");
		                         pw.println(" <td valign=\"top\"><strong>Comment</strong></td>");
		                         pw.println(" <td colspan=\"3\"> "+comment+" </td>");
		                    pw.println("</tr>");
		                        //pw.println("<hr />");
		                      pw.println("</table>");
							  
							   pw.println("</div><!--ScrollContainer_n-->");
		                     pw.println("</div><!--Scroll_n-->");
		                     pw.println("</td>");
							 pw.println("</tr>");
							 
							  }
			  }
			  
			  catch(Exception e)
			  {
			  e.printStackTrace();
			  }
		                    
		                  
				  
				   pw.println("<tr>");
                   pw.println("<td height=\"171\" align=\"center\"><a href=\"#\"><img src=\"../images/like2.png\" width=\"136\" height=\"136\"  /></a></td>");
                   pw.println("<td width=\"137\" align=\"center\"><a href=\"#\"><img src=\"../images/dislike2.png\" width=\"136\" height=\"135\"  /></a></td>");
                   pw.println("<td width=\"157\" align=\"center\"><a href=ConfirmAccountComment?no="+no+"><img src=\"../images/comment.png\" width=\"148\" height=\"150\"  /></a></td>");
                  
                pw.println("</table>");
              pw.println("</form>");
			  
			   pw.println("<hr size=\"4\" color=\"#000000\" />");

			  }
			  }
			  
			  catch(Exception e)
			  {
			  e.printStackTrace();
			  }
			  
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
  
}