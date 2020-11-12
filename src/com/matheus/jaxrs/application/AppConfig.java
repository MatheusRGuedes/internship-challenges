package com.matheus.jaxrs.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.matheus.mestra.dao.ProductDao;
import com.matheus.mestra.dao.ProductDaoImpl;
import com.matheus.mestra.service.ProductService;

/*
 * Classe para configura��o de recurso para configura��o da aplica��o web;
 * 
 * JacksonJaxbJsonProvider --> prover automaticamente conte�do json, configurado para usar tanto jackson quant jxb;
 * ObjectMapper			   --> serializa e desserializa json;
 * DEFAULT_VIEW_INCLUSION  --> determina se propriedades que n�o tem um view(propriedade a ser de/serializada) sejam incluidas na
 * 							   serializa��o;
 * 
 * bind --> Comece a construir uma nova vincula��o de servi�o baseada em classes
 * to	--> Vincule um novo contrato a um servi�o.
 * 
 * */

@ApplicationPath("/")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		
		setJsonProvider();

		register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				// expecifica como a inje��o de depend�ncia(@Inject) � feito, instanciando o .class usando a classe ProductService
				// aqui � injetado uma instancia da implementa��o no contrato(interface)
				bind(ProductService.class).to(ProductService.class); //.in(Singleton.class);
				bind(ProductDaoImpl.class).to(ProductDao.class);
			}
		});
		
		// define o pacote a ser encontrado a classe rest (ProductController)
		packages(true, "com.matheus.mestra.rest");
	}
	
	public void setJsonProvider() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		provider.setMapper(objectMapper);
		
		register(provider);
	}
}
