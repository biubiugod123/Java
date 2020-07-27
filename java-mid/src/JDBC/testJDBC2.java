package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class testJDBC2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
		            Statement s = c.createStatement();) {
			 c.setAutoCommit(false);
			 // 加血的SQL
	            String sql1 = "update hero set hp = hp +1 where id = 22";
	            s.execute(sql1);
	  
	            // 减血的SQL
	            // 不小心写错写成了 updata(而非update)
	  
	            String sql2 = "update hero set hp = hp -1 where id = 22";
	            s.execute(sql2);
	  
	            // 手动提交
	            c.commit();
		  
			
		} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		 
		
				
				
				
	}

}
