package com.spring.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String secondName;
    private String email;

    public User() {
    }

    public User(Integer id, String firstName, String secondName, String email) {
	this.id = id;
	this.firstName = firstName;
	this.secondName = secondName;
	this.email = email;
    }

    public Integer getId() {
	return id;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getSecondName() {
	return secondName;
    }

    public String getEmail() {
	return email;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
	this.secondName = secondName;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
