//this app is not using this 	

package com.pwskills.danish.utility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCUtil {
	private JDBCUtil() {}
	private static Properties properties = null;
	private static FileInputStream fis = null;
	//private static MysqlConnectionPoolDataSource dataSource = null;
	private static HikariDataSource hikariDataSource = null; 
	
	static {
		try {
			fis = new FileInputStream("/Users/danishfiroz/eclipse-workspace/20thApr_servPart9-Project/src/com/pwskills/danish/properties/database.properties");
			properties = new Properties();
			properties.load(fis);
			
			
//			dataSource = new MysqlConnectionPoolDataSource();
//			dataSource.setUrl("jdbc:mysql:///pwskills_octbatch");
//			dataSource.setUser("root");
//			dataSource.setPassword("Getttinnn12@@");
			
			//HikariConfig hikariConfig = new HikariConfig(properties);
//			//hikariDataSource = new HikariDataSource(hikariConfig);
			
			//alternative 2
			String fileInfo = "/Users/danishfiroz/eclipse-workspace/20thApr_servPart9-Project/src/com/pwskills/danish/properties/database.properties";
			HikariConfig hikariConfig = new HikariConfig(fileInfo);
			hikariDataSource = new HikariDataSource(hikariConfig);
			System.out.println(hikariDataSource.hashCode());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection()throws SQLException {
		return hikariDataSource.getConnection();
	}
	
	//5.close the resources/Connection to DB
	public static void cleanUpResources(ResultSet resultSet, Statement statement, Connection connection) {
		
		//Closing ResultSetll
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Closing Statement
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Closing Connection
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
