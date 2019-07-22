package com.example.demo.model;

import java.io.Serializable;

public class TodoForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer[] list;

	public Integer[] getList() {
		return list;
	}

	public void setList(Integer[] list) {
		this.list = list;
	}



}
