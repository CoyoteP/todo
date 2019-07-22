package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
public class Todo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todoid_seq")
    @SequenceGenerator(name = "todoid_seq", sequenceName = "todoid_seq	", allocationSize = 1)
	@Column(nullable = false)
	private Integer todoid;
	private String body = "";
	private String todoflg = "";
	private String userid = "";
	public Todo(Integer todoid, String body, String todoflg, String userid) {
		this.todoid = todoid;
		this.body = body;
		this.todoflg = todoflg;
		this.userid = userid;
	}
	public Todo() {
	}
	public Integer getTodoid() {
		return todoid;
	}
	public void setTodoid(Integer todoid) {
		this.todoid = todoid;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTodoflg() {
		return todoflg;
	}
	public void setTodoflg(String todoflg) {
		this.todoflg = todoflg;
	}
}
