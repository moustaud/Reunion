
import java.sql.*;
import java.sql.DriverManager;

public class EmployeeService {
 
    @SuppressWarnings("finally")
	public boolean verifyEmployee (String url, String db_login, 
    		String db_mdp, String equivalent_userName, String equivalent_mdp, 
    		String userName, String mdp)
    throws SQLException, ClassNotFoundException{
    	   	
    	
    	Connection cn=null;
    	Statement st=null;
    	ResultSet rs=null;
    	boolean result=false;
    	
     	
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		cn = DriverManager.getConnection(url,db_login,db_mdp);
    		st = cn.createStatement();
    		String sql = "SELECT * FROM Employee WHERE Employee."+equivalent_userName+"="+userName;
    		rs = st.executeQuery(sql);
    		String found_mdp=rs.getString("mdp");
    		if (rs!=null)
    		{
    			if (found_mdp==mdp){
    				result=true;
    			}
    		}   			
    	}
    	
    	catch (SQLException |ClassNotFoundException e){ System.out.println(e);}
    	
    	finally{
    		return result;
    	}
    }  
}
