import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ConfirmAccountComment extends HttpServlet
{
  String usertype,id,username;
  
   static String num;
   
  
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
          PrintWriter pw=res.getWriter();
	      num =req.getParameter("no");
			System.out.println("Confirm post num is---- "+num);
			

			 
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
RequestDispatcher rd=req.getRequestDispatcher("../Sidebar.html");
	   rd.include(req,res);
			       pw.println("<div id=\"content\">");
 
 pw.println("<form method=post>");
pw.println("<table align=\"center\" width=\"539\" border=\"0\">");
  pw.println("<tr>");
    pw.println("<th colspan=\"2\"><strong><h1><strong>CONFIRMATION REQUIRED</strong></h1></strong></th>");
  pw.println("</tr>");

  pw.println("<tr>");
    pw.println("<td width=\"79\"><strong>Username</strong></td>");
   pw.println(" <td width=\"446\"><label for=\"uname\"></label>");
    pw.println("<input type=\"text\" name=\"uname\" id=\"uname\" /></td>");
  pw.println("</tr>");
  pw.println("<tr>");
    pw.println("<td><strong>Password</strong></td>");
    pw.println("<td><label for=\"pass\"></label>");
    pw.println("<input type=\"password\" name=\"pass\" id=\"pass\" /></td>");
  pw.println("</tr>");
  pw.println("<tr>");
    pw.println("<td colspan=\"2\">&nbsp;</td>");
  pw.println("</tr>");
  pw.println("<tr>");
  pw.println("<td align=\"center\" colspan=\"3\">");
    pw.println("<input type=\"image\" name=\"next\" id=\"next\" src=\"../images/New folder/next.jpg\" width=\"130\" height=\"40\" alt=\"submit\" />");
  pw.println("</td>");
   pw.println("</tr>");
   //pw.println("<input type=text name=idd value="+num+">");
  /*pw.println("<tr>");
    pw.println("<td align=\"center\" colspan=\"3\"><a href=WriteComment?no="+no+"><img src=\"../images/New folder/next.jpg\" width=\"130\" height=\"40\"  /></a>&nbsp;</td>");
    
  pw.println("</tr>");*/
pw.println("</table>");
pw.println("</form>");
 
 }
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
  {
          PrintWriter pw=res.getWriter();
 String uname=req.getParameter("uname");
  String pass=req.getParameter("pass");
  System.out.println("uname is:"+uname+":::::::"+pass);
  
	  Connection con=DBInfo.getConnection();
	  String query="select * from login where username=? and password=?";
	  int flag=0;
		  try
		  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1,uname);
		  ps.setString(2,pass);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
		   flag=1;
		   username=rs.getString(2);
		   usertype=rs.getString(4);
		   id=rs.getString(1);
		   break;
		  }
		 	
		 }
			catch(Exception e)
			{
			e.printStackTrace();
			}	
			System.out.println("value of flag is:"+flag);
			System.out.println("usertype is:"+usertype);
			System.out.println("value of article id is:"+num);
			System.out.println(id+":"+username+":"+usertype);
		
if(flag==1 && usertype.equalsIgnoreCase("admin"))
		{
				
			
			   
				res.sendRedirect("WriteComment?id="+id+"&usertype="+usertype+"&username="+username+"&articleid="+num);
		}
			 		  
if(flag==1 && usertype.equalsIgnoreCase("student"))
		{
				res.sendRedirect("WriteComment?id="+id+"&usertype="+usertype+"&username="+username+"&articleid="+num);
		}				
if(flag==1 && usertype.equalsIgnoreCase("faculty"))
		{
				res.sendRedirect("WriteComment?id="+id+"&usertype="+usertype+"&username="+username+"&articleid="+num);
		}
if(flag==1 && usertype.equalsIgnoreCase("alumni"))
			 
{			res.sendRedirect("WriteComment?id="+id+"&usertype="+usertype+"&username="+username+"&articleid="+num);
				}
if(flag==1 && usertype.equalsIgnoreCase("others"))
{
			res.sendRedirect("WriteComment?id="+id+"&usertype="+usertype+"&username="+username+"&articleid="+num);
			  }

	  
  
 
 
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