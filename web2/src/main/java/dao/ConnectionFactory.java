package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 public static Connection getConnection() {
	        Connection c = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibapst?useUnicode=true&characterEncoding=UTF-8", "root", "bb8c3po@kukulera");
	        } catch (ClassNotFoundException e) {
	            System.out.println("ClassNotFoundException " + e);
	        } catch (SQLException e) {
	            System.out.println("SQLException " + e);
	        }
	        return c;
	    }

}
