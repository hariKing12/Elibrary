package com.sample.project.elibrary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {

	public static Connection getConnection(){
		Connection connection=null;
		try{
			Properties db=new Properties();
			FileReader fl=new FileReader("C:/Users/harish botlagunta/Desktop/config.properties");
			BufferedReader bf=new BufferedReader(fl);
			if(bf!=null){
				try{
				db.load(bf);
				//System.out.println("file loaded successfully");
			}catch(FileNotFoundException e){
			   System.out.println("problem occured while loading the file");	
			}
		}
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    String url=db.getProperty("URL");
		    String username=db.getProperty("USER");
		    String password=db.getProperty("PASSWORD");
		    connection=DriverManager.getConnection(url, username, password);
		    //System.out.println("connected successfully");
		
		
	}catch(IOException e){
		System.out.println(e.getMessage());
	} catch (ClassNotFoundException e) {
		System.out.println("problem occured while reading the file"+e.getMessage());
		
	} catch (SQLException e) {
		System.out.println("problem occured while getting the connection"+e.getMessage());
	}
		return connection;
	}
}
