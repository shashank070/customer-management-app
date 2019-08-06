package com.crm.app.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.crm.app.controller.Request;

@Configuration
@PropertySource("classpath:application.properties")
public class DbConnectionManager {

	private static final Logger logger = LoggerFactory.getLogger(DbConnectionManager.class);
	
	@Value("${dbUrl}")
	private String dbUrl;
	
	@Value("${dbDriver}")
	private String dbDriver;
	
	@Value("${dbUserId}")
	private String dbUserId;
	
	@Value("${dbPassword}")
	private String dbPassword;
	
	
	private Connection conn=null;

	  public DbConnectionManager() {

	    }

	    @PostConstruct
	    public void init() {
	        System.out.println("================== " + dbDriver + "================== ");
	    }
	  
	public Connection getDbConnection()
	{
		try {
			if(conn!=null && !conn.isClosed()) {
				logger.info("Returning same connection");
				return conn;
			}
			logger.info("Creating new connection");
			Class.forName(dbDriver);
			conn=DriverManager.getConnection(dbUrl,dbUserId,dbPassword); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	
		return conn;
	}
	
	public static void closeStmRs(Statement stm, ResultSet rs)
	{
		try {
		if(rs!=null)
		{
			
				rs.close();
			
		}
		if(stm!=null)
		{
			stm.close();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeStm(Statement stm)
	{
		try {
		
		if(stm!=null)
		{
			stm.close();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
