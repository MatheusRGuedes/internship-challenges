package com.matheus.mestra.dbconection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.matheus.mestra.model.Product;

public class SqlServerConnection {

	private static String driverName 	= "net.sourceforge.jtds.jdbc.Driver"; //driver do sqlserver + performático que o da microsoft
	private static String serverName 	= "192.100.100.127:1433";			  //porta padrão
	private static String myDatabase 	= "sqlserver";
	private static String databaseName 	= "treinamento_java";
	private static String userName 		= "java";
	private static String password 		= "java@123";
	
	private static Connection conn;
	
	
	public SqlServerConnection() {}
	
	
	public static Connection getConnection() {
		conn = null;
		String url = "jdbc:jtds:" + myDatabase + "://" + serverName + "/" + databaseName;
		
		try {
			//retorna a classe do driver
			Class.forName(driverName);
			System.out.println("Driver found.");
			
			//configuring database connection
			conn = DriverManager.getConnection(url, userName, password);
			
			if (conn != null) {
				System.out.println("Conection made with success.");
			} else {
				System.out.println("No Conection.");
			}
			
		} catch(ClassNotFoundException ex1) { //driver não encontrado
			System.out.println("O driver não foi encrontrado.");
			return null;
			
		} catch (SQLException ex2) {
			System.out.println("Não foi possível estabelecer uma conexão ao banco.");
			return null;
		}
		
		return conn;
	}
	
	public static boolean closeConnection() {
		try {
			conn.close();
			System.out.println("Connection Closed.");
			return true;
			
		} catch (SQLException e) {
			System.out.println("Connection can not be closed because ocurred errros.");
			return false;
		}
	}
	
	public static List<Product> getProductsList() {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Product> list = new ArrayList();
		
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				stmt.execute(" select * from Products ");
				rs = stmt.getResultSet();
				
				while(rs.next()) {
					Product p = new Product();
					p.setId(rs.getLong(1));
					p.setName(rs.getString("ProductName"));
					p.setSupplierId(rs.getLong("SupplierID"));
					p.setCategoryId(rs.getLong("CategoryID"));
					p.setQnttPerUnit(rs.getString("QuantityPerUnit"));
					p.setUnitPrice(rs.getBigDecimal("UnitPrice"));
					p.setUnitsInStock(rs.getInt("UnitsInStock"));
					p.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
					p.setReorderLevel(rs.getInt("ReorderLevel"));
					p.setDiscontinued(rs.getInt("Discontinued"));
					list.add(p);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (list.isEmpty() || list == null) {
			return new ArrayList<Product>();
		}
		
		return list;
	}
}