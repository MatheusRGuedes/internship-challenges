package com.matheus.mestra.model;

import java.io.Serializable;
import java.math.BigDecimal;

//@XmlRootElement // anotação para poder enviar em xml, fazendo a converção
public class Product implements Serializable {

	//versão de serialização para o estado dos objtos n se perderem
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long supplierId;
	private Long categoryId;
	private String qnttPerUnit;   // quantity per unit
	private BigDecimal unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
	private Integer reorderLevel;
	private Integer discontinued; // 0 or 1 
	
	public Product() {}
	
	public Product(Long id, String name, Long supplierId, Long categoryId,
			String qnttPerUnit, BigDecimal unitPrice, Integer unitsInStock,
			Integer unitsOnOrder, Integer reorderLevel, Integer discontinued) {
		super();
		this.id = id;
		this.name = name;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.qnttPerUnit = qnttPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getQnttPerUnit() {
		return qnttPerUnit;
	}
	public void setQnttPerUnit(String qnttPerUnit) {
		this.qnttPerUnit = qnttPerUnit;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}
	public void setUnitsOnOrder(Integer unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Integer getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(Integer discontinued) {
		this.discontinued = discontinued;
	}
}