package com.matheus.mestra.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.matheus.mestra.model.Product;
import com.matheus.mestra.service.ProductService;

/*
 *  @produces para qual o formato/MediaType de resposta para o client, em get;
 *  @consumes para qual o formato de dados a ser entregue ao servidor no corpo de requisição (post, put, patch)
 *  
 *  @Inject --> O HK2 é uma estrutura de injeção de dependência, é chamado pelo jersey ao
 *  criar a instância e tentar encontrar todas as dependências pr o recurso;
 *  Ver: https://en.it1352.com/article/171f9d48604f49f3befc239b8f214918.html
 *       https://qastack.com.br/programming/16216759/dependency-injection-with-jersey-2-0
 *  
 *  APPLICATION_JSON --> para envio do json
 *  TEXT.XML		 --> para envio do xml
 * 
 * */

@Path("/products")
public class ProductController { 
	
	@Inject
	private ProductService service;
	
	@GET
	@Path("list/html")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlListOfProducts() {
		return "<html>"
				+ "<title>Product REST</title>"
				+ "<h1>Products List</h1>"
			 + "</html>";
	}

	//identar json
	//https://stackoverflow.com/questions/14515994/convert-json-string-to-pretty-print-json-output-using-jackson
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getListOfProductsJson() {
		return service.listProducts();
	}
}