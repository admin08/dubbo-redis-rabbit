package com.xlf.entity;

import java.io.Serializable;

public class GoodsType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3866620211345256527L;	
	private String  name;
	private String id;

	public GoodsType() {
		super();
	}


	public GoodsType(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
}
