import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBInfo 
{
  static Connection con=null;
   static
   {
	   //Drivers
		  try 
		  {
			Class.forName("com.mysql.jdbc.Driver");
		  }
		  catch (ClassNotFoundException e) 
		  {		
			e.printStackTrace();
		}
		  System.out.println("Driver loaded");
   }
   public static Connection getConnection()
   {
	   
	   String url="jdbc:mysql://localhost:3306/emagazine";
	   String username="root";
	   String password="rat";
	   try 
	   {
		con=DriverManager.getConnection(url,username,password);
	   }
	   catch (SQLException e) 
	   {
		e.printStackTrace();
	   }
	   return con;   
   }
   public static void close()
   {
	    try
	    {
		con.close();
	    } 
	    catch (SQLException e) 
	    {
		e.printStackTrace();
	    }
   }
}
