import java.sql.*;
import java.util.ArrayList;
public class GetArticleCategory
{
   public static ArrayList<String> getType()
   {
   ArrayList<String> obj=new ArrayList<String>();
   Connection con=DBInfo.getConnection();
   String query="select category from articlecategory";
   try
   {
   PreparedStatement ps=con.prepareStatement(query);
   ResultSet res=ps.executeQuery();
	   while(res.next())
	   {
	     String s1=res.getString(1);
		 obj.add(s1);
	   }
   }
   catch(Exception e)
   {
   e.printStackTrace();
   }
   DBInfo.close();
   return obj;
   }
}

