package io.github.noahzu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static String dbUrl="jdbc:mysql://localhost:3306/smartrebot?useUnicode=true&characterEncoding=utf8";
	private static String dbUserName="root";
	private static String dbPassword="admin";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	private static MySqlConnection mysqlConnection = new MySqlConnection();
	private MySqlConnection(){
		
	}
	public static MySqlConnection getInstance(){
		return mysqlConnection;
	}
	public static Connection getCon() throws Exception{
		Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
	}
	
	public static void closeCon(Connection con) throws SQLException{
		if(con != null){
			con.close();
		}
	}
}
