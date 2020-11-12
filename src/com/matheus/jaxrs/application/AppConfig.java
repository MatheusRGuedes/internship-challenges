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
 * Classe para configuração de recurso para configuração da aplicação web;
 * 
 * JacksonJaxbJsonProvider --> prover automaticamente conteúdo json, configurado para usar tanto jackson quant jxb;
 * ObjectMapper			   --> serializa e desserializa json;
 * DEFAULT_VIEW_INCLUSION  --> determina se propriedades que não tem um view(propriedade a ser de/serializada) sejam incluidas na
 * 							   serialização;
 * 
 * bind --> Comece a construir uma nova vinculação de serviço baseada em classes
 * to	--> Vincule um novo contrato a um serviço.
 * 
 * */

@ApplicationPath("/")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		
		setJsonProvider();

		register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				// expecifica como a injeção de dependência(@Inject) é feito, instanciando o .class usando a classe ProductService
				// aqui é injetado uma instancia da implementação no contrato(interface)
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
