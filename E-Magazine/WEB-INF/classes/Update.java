import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Update extends HttpServlet
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

			pw.println("<title>Update User Account</title>");
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
			        
			        
			       pw.println("<div id=\"content\">");
  pw.println("<form method=\"post\">");
  
  String id=req.getParameter("id");
  
  try
  {
  Connection con=DBInfo.getConnection();
  String query="select * from login where id=?";
  
  PreparedStatement ps=con.prepareStatement(query);
  ps.setString(1,id);
  
  ResultSet rs=ps.executeQuery();
  while(rs.next())
  {
	String uname=rs.getString(2);
	String pass=rs.getString(3);
	String utype=rs.getString(4);
	
	 pw.println("<center>");
	 pw.println("<h1>UPDATE RECORD</h1>");
	 
    pw.println("<table width=\"346\" border=\"0\">");
      pw.println("<tr>");
        pw.println("<td width=\"130\">Your ID is</td>");
        pw.println("<td width=\"184\"><label for=\"id\"></label>");
        pw.println("<input type=\"text\" name=\"id\" id=\"id\" readonly=\"true\" value="+id+" /></td>");
      pw.println("</tr>");
     pw.println(" <tr>");
        pw.println("<td>Your Username is</td>");
       pw.println(" <td><label for=\"uname\"></label>");
       pw.println(" <input type=\"text\" name=\"uname\" id=\"uname\" readonly=\"true\" value="+uname+" /></td>");
      pw.println("</tr>");
      pw.println("<tr>");
        pw.println("<td>New Password is</td>");
        pw.println("<td><label for=\"pass\"></label>");
      pw.println("<input type=\"text\" name=\"pass\" id=\"pass\" value="+pass+" /></td></tr>");
      pw.println("<tr>");
       pw.println(" <td>New Usertype is</td>");
       pw.println(" <td><label for=\"utype\"></label>");
       pw.println(" <input type=\"text\" name=\"utype\" id=\"utype\" value="+utype+" /></td>");
      pw.println("</tr>");
	       pw.println("<tr>");
         pw.println("<td>&nbsp;</td>");
         pw.println("<td>&nbsp;</td>");
       pw.println("</tr>");
	}
	ps.close();
	con.close();
	DBInfo.close();
  }
 
		catch(Exception e)
		   {
		   e.printStackTrace();
		   }
		   
		     pw.println("  <tr>");
    pw.println(" <td align=\"center\" >");
    pw.println("<input type=\"image\" name=\"next\" id=\"next\" src=\"../images/New folder/update.jpg\" width=\"130\" height=\"40\" alt=\"submit\" />");
    pw.println("</td>");

    pw.println(" <td align=\"center\"><a href=\"ShowRecords\"><img src=\"../images/New folder/back.jpg\" width=\"130\" height=\"40\" /></a></td>");
    pw.println("</tr>");
	

    pw.println("</td>");
    pw.println("<td width=\"18\"></td>");
    pw.println(" </tr>");
	
    pw.println("</table>");
    pw.println("</center>");
    pw.println("</form>");
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
  
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
			PrintWriter pw=res.getWriter();
			 String id=req.getParameter("id");
  String uname=req.getParameter("uname");
  String pass=req.getParameter("pass");
  String utype=req.getParameter("utype");
  int flag=0;
  
   Connection con=DBInfo.getConnection();
  
   try
   {
	 
	  String query="update login set password=?,usertype=? where id=?";
	  
	  PreparedStatement ps=con.prepareStatement(query);
      ps.setString(1,pass);	  
	  ps.setString(2,utype);	  
	  ps.setString(3,id);	
      flag=ps.executeUpdate();	  
      ps.close();
	  con.close();
	DBInfo.close();
		 	
		 }
			catch(Exception e)
			{
			e.printStackTrace();
			}	
			
			
			
			
	pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			pw.println("<head>");
			pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");

			pw.println("<title>Update User Account</title>");
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
			        pw.println("<div id=\"tooplate_sidebar\">");

			            pw.println("<div id=\"menu\">");
			                pw.println("<ul class=\"navigation\">");
			                    
			                    
			                    
			                    
			                    pw.println("<li><a href=\"../ArticleOfMonth.html\" class=\"menu_05\">Article of the Month</a></li>");
			                    pw.println("<li><a href=\"../AllArticles.html\" class=\"menu_06\">All Articles</a></li>");
			                    
			                    
			                    
			                     RequestDispatcher rd=req.getRequestDispatcher("../Sidebar.html");
			                pw.println("</ul>");
			            pw.println("</div>");
					pw.println("</div> <!-- end of sidebar -->  ");
			        
			        
			       pw.println("<div id=\"content\">");
						
						if(flag!=0)
  {
  pw.println("<h1>RECORD UPDATED</h1>");
  pw.println("<BR><a href=ShowRecords>BACK</a>");
  }
  else
  {
  pw.println("<h1>Record Not Updated Due to some problem</h1>");
  pw.println("<BR><a href=ShowRecords>BACK</a>");
  }
		
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