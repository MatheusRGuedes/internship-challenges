package com.matheus.mestra.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.matheus.mestra.dao.ProductDao;
import com.matheus.mestra.model.Product;

/*
 * @Singleton --> Padr�o de projeto q garante apenas uma inst�ncia de classe, mantendo um 
 * 				  ponto global d acesso;
 * @Resource  --> Anota��o do Jax para defini��o de um resource que a aplica��o precisa;
 * */

//@Singleton
@Resource
public class ProductService {

	@Inject
	private ProductDao dao;
	
	public List<Product> listProducts() {
		return dao.listProducts();
	}
}
