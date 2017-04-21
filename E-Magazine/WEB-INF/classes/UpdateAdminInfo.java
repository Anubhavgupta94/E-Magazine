import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class UpdateAdminInfo extends HttpServlet
{
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
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

			pw.println("<title>All Notices</title>");
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
				   
				    pw.println("<form method=\"post\">");
					
					
					 try
  {
  Connection con=DBInfo.getConnection();
  String query="select * from adminrecord ";
  
  PreparedStatement ps=con.prepareStatement(query);
 
  
  ResultSet rs=ps.executeQuery();
  while(rs.next())
  { 
    String name=rs.getString(1);
	String id=rs.getString(2);
	String pass=rs.getString(3);
	String repass=rs.getString(4);
	String email=rs.getString(5);
	String dob=rs.getString(6);
	String occupation=rs.getString(7);
	String prinum=rs.getString(8);
	String secnum=rs.getString(9);
	String addr=rs.getString(10);
	String uname=rs.getString(11);
	System.out.println(id);
	
			pw.println("<center>");
			pw.println("<table align=\"center\" width=\"497\" border=\"0\">");
			pw.println(" <tr>");
			pw.println(" <th align=\"center\" colspan=\"2\"><h1>UPDATE INFORMATION</h1></th>");
			  pw.println("</tr>");
			  pw.println("<tr>");
			  pw.println("  <td colspan=\"2\">&nbsp;</td>");
			  pw.println("</tr>");
			  
			  pw.println("<tr>");
			  pw.println("  <td width=\"161\">Id</td>");
			   pw.println(" <td width=\"313\"><label for=\"Id\"></label>");
			   pw.println(" <input name=\"Id\" type=\"text\" id=\"Id\" size=\"41\" readonly=true required=\"required\" value="+id+" /></td>");
			  pw.println("</tr>");
			  
			  pw.println("<tr>");
			  pw.println("  <td width=\"161\">Name</td>");
			   pw.println(" <td width=\"313\"><label for=\"name\"></label>");
			   pw.println(" <input name=\"name\" type=\"text\" id=\"name\" size=\"41\" required=\"required\" value="+name+" /></td>");
			  pw.println("</tr>");
			  
              pw.println("<tr>");
			   pw.println(" <td width=\"161\">Username</td>");
			   pw.println(" <td width=\"313\"><label for=\"uname\"></label>");
			    pw.println("<input name=\"uname\" type=\"text\" id=\"uname\" readonly=\"true\" size=\"41\" required=\"required\" value="+uname+" /></td>");
			  pw.println("</tr>");
              
			  pw.println("<tr>");
			   pw.println(" <td>Password</td>");
			    pw.println("<td><label for=\"pass\"></label>");
			   pw.println(" <input name=\"pass\" type=\"text\" id=\"pass\" size=\"41\" required=\"required\" value="+pass+" /></td>");
			 pw.println(" </tr>");
			  pw.println("<tr>");
			   pw.println(" <td>Retype Password</td>");
			   pw.println(" <td><label for=\"repass\"></label>");
			   pw.println(" <input name=\"repass\" type=\"text\" id=\"repass\" size=\"41\" required=\"required\" value="+repass+" /></td>");
			 pw.println(" </tr>");
			  pw.println("<tr>");
			   pw.println(" <td>Email ID</td>");
			   pw.println(" <td><label for=\"email\"></label>");
			    pw.println("<input name=\"email\" type=\"text\" id=\"email\" size=\"41\" readonly=\"true\" required=\"required\" value="+email+" /></td>");
			  pw.println("</tr>");
			  pw.println("<tr>");
			  pw.println("  <td>Date of Birth</td>");
			    pw.println("<td><label for=\"dob\"></label>");
			   pw.println(" <input name=\"dob\" type=\"date\" id=\"dob\" size=\"41\" />"+dob+"</td>");
			  pw.println("</tr>");
			 
             pw.println("<tr>");
			    pw.println("<td>Occupation</td>");
			   pw.println(" <td><label for=\"occupation\"></label>");
			   pw.println(" <input name=\"occupation\" type=\"text\" id=\"occupation\" size=\"41\" required=\"required\" value="+occupation+" /></td>");
			  pw.println("</tr>");
             
		  pw.println("<tr>");
			    pw.println("<td>Primary Number</td>");
		    pw.println("<td><label for=\"prinum\"></label>");
			    pw.println("<input name=\"prinum\" type=\"text\" id=\"prinum\" size=\"41\" required=\"required\" value="+prinum+" /></td>");
			  pw.println("</tr>");
			  pw.println("<tr>");
			    pw.println("<td>Secondary Number</td>");
			    pw.println("<td><label for=\"secnum\"></label>");
			    pw.println("<input name=\"secnum\" type=\"text\" id=\"secnum\" size=\"41\" required=\"required\" value="+secnum+" /></td>");
			  pw.println("</tr>");
			  pw.println("<tr>");
			   pw.println("<td valign=\"top\">address</td>");
			    pw.println("<td><label for=\"addr\"></label>");
			   pw.println(" <textarea name=\"addr\" id=\"addr\" cols=\"44\" rows=\"5\" required=\"required\" readonly='true'>"+addr+"</textarea></td>");
			  pw.println("</tr>");
			  pw.println("<tr>");
			  
			  }
	ps.close();
	con.close();
	DBInfo.close();
  }
 
		catch(Exception e)
		   {
		   e.printStackTrace();
		   }
			   pw.println(" <td colspan=\"2\">&nbsp;</td>");
			  pw.println("</tr>");
			  pw.println("<tr align=\"center\">");
			  pw.println(" <td colspan=\"2\">");
			     pw.println(" <input type=\"image\" name=\"update\" id=\"update\" src=\"../images/New folder/update.jpg\" width=\"170\" height=\"52\" alt=\"submit\" />");
			      pw.println("    </td>");
			  pw.println("</tr>");
pw.println("</table>");
       pw.println(" </form>");
	   
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
			//doPost(req,res);
			pw.println("</body>");
			pw.println("</html>");
	}}

 public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
		PrintWriter pw=res.getWriter();
		HttpSession sess=req.getSession();
		String admin_id=(String)sess.getAttribute("ID3");
		//String admin_id=req.getParameter("id");
		String name=req.getParameter("name");
		String uname=req.getParameter("username");
		String pass=req.getParameter("pass");
		String repass=req.getParameter("repass");
		String email=req.getParameter("email");
		String dob=req.getParameter("dob");
		String occupation=req.getParameter("occupation");	
		String prinum=req.getParameter("prinum");
		String secnum=req.getParameter("secnum");
		String addr=req.getParameter("addr");
		System.out.println("Here::::"+admin_id);
		
		String query="update adminrecord set name=?,pass=?,repass=?,dob=?,occupation=?,prinum=?,secnum=? where admin_id=?";
		Connection con=DBInfo.getConnection();
		try{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setString(3,repass);
			ps.setString(4,dob);
			ps.setString(5,occupation);
			ps.setString(6,prinum);
			ps.setString(7,secnum);
			
			ps.setString(8,admin_id);
			
			ps.executeUpdate();
			ps.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/*String query2="upadte login set password=? where id=? ";
		try
		  {
		  PreparedStatement ps1=con.prepareStatement(query2);
		 // ps.setString(1,id);
		  //ps.setString(2,uname);
		  ps1.setString(1,pass);
		  ps1.setString(2,admin_id);
		  //ps.setString(4,utype);
		  ps1.executeUpdate();
		  
		  ps1.close();
	  con.close();
	  DBInfo.close();
		  }
		catch(Exception e)
		  {
		  e.printStackTrace();
		  }
*/		  
		  res.sendRedirect("UpdateAdminInfo");
	}

	
}
