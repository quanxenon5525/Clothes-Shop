package com.web.FinalProject.model;

import java.util.Date;

public class User {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id_User
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private Integer idUser;
	public User(Integer idUser, String username, String password, String phone, String email, String firstname,
			String lastname, Integer role) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}
	public User(String username, String password, Integer role, String phone, String email, String firstname, String lastname) {
		super();
		this.username =  username;
		this.password = password;
		this.role =  role;
		this.phone = phone;
		this.email =  email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.username
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.phone
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private String phone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.email
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.firstName
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private String firstname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.lastName
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private String lastname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.role
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	private Integer role;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id_User
	 * @return  the value of user.id_User
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id_User
	 * @param idUser  the value for user.id_User
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.username
	 * @return  the value of user.username
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.username
	 * @param username  the value for user.username
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.phone
	 * @return  the value of user.phone
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.phone
	 * @param phone  the value for user.phone
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.email
	 * @return  the value of user.email
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.email
	 * @param email  the value for user.email
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.firstName
	 * @return  the value of user.firstName
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.firstName
	 * @param firstname  the value for user.firstName
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.lastName
	 * @return  the value of user.lastName
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.lastName
	 * @param lastname  the value for user.lastName
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.role
	 * @return  the value of user.role
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public Integer getRole() {
		return role;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.role
	 * @param role  the value for user.role
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
}