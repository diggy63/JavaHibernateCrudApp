package com.diggy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/javaspring";
		String user = "danielkanczugowski";
		String pass = "";
		String QUERY = "SELECT id, first_name, last_name, email FROM student";
		
		
		try {
			System.out.println("connecting to psql db");
			Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("connected to db");
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}