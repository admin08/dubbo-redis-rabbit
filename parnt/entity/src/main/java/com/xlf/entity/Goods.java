package com.xlf.entity;

import java.io.Serializable;

public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5346882710211407084L;
	private String name;
	private Long money;

	public Goods(String name, Long money, Integer count, String id, String typeId) {
		super();
		this.name = name;
		this.money = money;
		this.count = count;
		this.id = id;
		this.typeId = typeId;
	}

	public Goods() {
		super();
	}

	private Integer count;
	private String id;
	private String typeId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}
