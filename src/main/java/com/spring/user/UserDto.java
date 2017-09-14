package com.spring.user;

public class UserDto {

    private Integer id;
    private String firstName;
    private String secondName;
    private String email;

    public UserDto(Integer id, String firstName, String secondName, String email) {
	this.id = id;
	this.firstName = firstName;
	this.secondName = secondName;
	this.email = email;
    }

    public UserDto() {
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

    @Override
    public String toString() {
	return "UserDto [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", email=" + email
		+ "]";
    }

}
