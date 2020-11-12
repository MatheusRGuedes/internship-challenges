package com.matheus.mestra.dao;

import java.util.List;

import com.matheus.mestra.dbconection.SqlServerConnection;
import com.matheus.mestra.model.Product;

public class ProductDaoImpl extends SqlServerConnection implements ProductDao {

	@Override
	public List<Product> listProducts() {
		getConnection();
		
		List<Product> list = SqlServerConnection.getProductsList();
		
		closeConnection();
		
		return list;
		/*Product p1 = new Product(1L, "Chai", 1L, 1L, "boxes x 20 bags",	new BigDecimal(18.00), 39, 0, 10, 0);
		Product p2 = new Product(2L, "Teste", 2L, 1L, "24 - 12 oz bottles",	new BigDecimal(15.50), 80, 0, 10, 0);
		return Arrays.asList(p1, p2);*/
	}
}
