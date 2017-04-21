import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.sql.*;
public class PostArticleFaculty extends HttpServlet
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

			pw.println("<title>Post Article Page</title>");
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
         pw.println("<table align=\"center\" width=\"497\" border=\"0\">");
           pw.println("<tr>");
             pw.println("<td align=\"center\" colspan=\"4\"><h1>FILL ARTICLE INFORMATION</h1></td>");
           pw.println("</tr>");
		   
		    ArrayList<String> obj=GetArticleClass.getType();
           pw.println("<tr>");
            pw.println(" <td width=\"81\">Class</td>");
             pw.println("<td width=\"236\"><select name=\"class\">");
			 
			 for(String s:obj)
			 {
              pw.println("<option value="+s+">"+s+"</option>");
			 }
             pw.println("</select></td>");
             
			 pw.println(" <td colspan=\"2\"><a href=\"../ArticleAddClassFaculty.html\">if other</a>");
            pw.println(" <label for=\"otherclass\"></label></td>");
			 
           pw.println("</tr>");
		   
		   ArrayList<String> obj1=GetArticleCategory.getType();
           pw.println("<tr>");
            pw.println(" <td>Category</td>");
             pw.println("<td><select name=\"category\">");
              for(String s1:obj1)
						 {
			             pw.println("<option value="+s1+">"+s1+"</option>");
						 }
             pw.println("</select></td>");
			 
             pw.println("<td colspan=\"2\"><a href=\"../ArticleAddCategoryFaculty.html\">if other</a>");
             pw.println("<label for=\"othercategory\"></label></td>");
			 
           pw.println("</tr>");
		   
		   ArrayList<String> obj2=GetArticleType.getType();
           pw.println("<tr>");
             pw.println("<td>Type</td>");
             pw.println("<td><select name=\"type\">");
			 	 for(String s2:obj2)
						 {
			              pw.println(" <option value="+s2+">"+s2+"</option>");
			             }
			pw.println(" </select></td>");
            
			pw.println("<td colspan=\"2\"><a href=\"../ArticleAddTypeFaculty.html\">if other</a>");
             pw.println("<label for=\"othertype\"></label></td>");
			
          pw.println(" </tr>");
		  
		  
            pw.println("<tr>");
             pw.println("<td>Date</td>");
             pw.println("<td colspan=\"3\"><label for=\"date\"></label>");
             pw.println("<input type=\"date\" name=\"date\" id=\"date\" /></td>");
           pw.println("</tr>");
		   
		   
           pw.println("<tr>");
            pw.println(" <td valign=\"top\">Description</td>");
             pw.println("<td colspan=\"3\"><label for=\"description\"></label>");
             pw.println("<textarea name=\"description\" id=\"description\" cols=\"50\" rows=\"15\"></textarea></td>");
          pw.println(" </tr>");
		  
		  pw.println("<tr>");
             pw.println("<td width=\"81\">&nbsp;</td>");
             pw.println("<td width=\"236\">&nbsp;</td>");
             pw.println("<td width=\"1\">&nbsp;</td>");
             pw.println("<td width=\"161\">");
           pw.println("</tr>");
           pw.println("<tr align=\"center\">");
            pw.println(" <td colspan=\"4\"><input type=\"image\" name=\"submit\" id=\"submit\" src=\"../images/New folder/submit.jpg\" width=\"130\" height=\"40\" alt=\"submit\" /></td>");
          pw.println(" </tr>");
		  
         pw.println("</table>");
       pw.println("</form>");
	   pw.println("<BR><a href=FacultySection>BACK</a>");
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
					
					pw.println("Copyright � 2015<a href=\"http://www.ratindia.com/\"> Road Ahead Technologies</a><br />");
					pw.println("Designed by <a href=\"../Anubhav.html\">Anubhav Gupta</a><br />");
			       
			   pw.println(" </div>");
				
			    
			pw.println("</div><!--end of footer-->");

			pw.println("</body>");
			pw.println("</html>");

  }}
  
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
  {	
		PrintWriter pw=res.getWriter();
		  String no="";
		  for(int i=0;i<5;i++)
		  {
		   no+=(int)(Math.random()*9)+1;
		  }
		  String class1=req.getParameter("class");
		  String category=req.getParameter("category");
		  String type=req.getParameter("type");
		  String date=req.getParameter("date");
		  String description=req.getParameter("description");
		  
		  String query="insert into articleinfo values(?,?,?,?,?,?)";
		  Connection con=DBInfo.getConnection();
		  
		  try
		  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1,no);
		  ps.setString(2,class1);
		  ps.setString(3,category);
		  ps.setString(4,type);
		  ps.setString(5,date);
		  ps.setString(6,description);
		  ps.executeUpdate();
	}  
		  catch(Exception e)
		  {
		  e.printStackTrace();
		  }
		res.sendRedirect("PostArticleFaculty");
}
}