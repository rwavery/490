
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBTest
{

	public static void main(String[] args)
	{
		Connection con = null;
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/490project", "root", "");
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CCUID, studentName, email, phone FROM students");
			
			while (rs.next()) {
				int x = rs.getInt("CCUID");
				String s = rs.getString("studentName");
				String e = rs.getString("email");
				String p = rs.getString("phone");

				System.out.println("CCUID: " +x+ ", Name: "+s + ", Email: "+e + ", Phone: "+p);
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException se){
			se.printStackTrace();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{ 
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2){
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
		}
			
	}

}
