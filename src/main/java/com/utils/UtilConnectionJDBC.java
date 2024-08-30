package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilConnectionJDBC {
	private static final String URL = "jdbc:mysql://localhost:3306/estate";
    private static final String USER = "root";
    private static final String PASSWORD = "Phuc06032004@";
    public static Connection getConnection() {
    	Connection conn = null ; 
    	try{
    		conn = DriverManager.getConnection(URL, USER, PASSWORD) ; 
    		return conn ; 
    	}catch (Exception e) {
            e.printStackTrace();
    	}
    	return conn ; 
    }
}
