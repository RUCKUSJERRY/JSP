package com.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	public static Connection getConnection() {
		
		try {
		// 1 . driver 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println("1. Driver 연결");
			
		// 2 . 계정 연결
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("2. 계정 연결");
		
		return con;
		
	}
	
	public static boolean isConnection(Connection con) {
		boolean pass = true;
		
		try {
			if (con == null || con.isClosed()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pass;
	}
	
	
	public static void close(Connection con) {
		if (isConnection(con)) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
			
		
	}
	
	public static void close(ResultSet rs) {
		
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
	}
	
	public static void close(Statement stmt) {
		
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	

		
	}
	
	public static void commit(Connection con) {
		
		if (isConnection(con)) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
	}
	
	public static void rollback(Connection con) {
		
		if (isConnection(con)) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	
	

	
	
	
}
