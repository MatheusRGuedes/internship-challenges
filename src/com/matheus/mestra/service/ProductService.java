package com.matheus.mestra.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.matheus.mestra.dao.ProductDao;
import com.matheus.mestra.model.Product;

/*
 * @Singleton --> Padrão de projeto q garante apenas uma instância de classe, mantendo um 
 * 				  ponto global d acesso;
 * @Resource  --> Anotação do Jax para definição de um resource que a aplicação precisa;
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
