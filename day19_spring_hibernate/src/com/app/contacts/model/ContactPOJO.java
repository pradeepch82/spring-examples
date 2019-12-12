package com.app.contacts.model;

import java.util.Date;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "dac1_contacts")
public class ContactPOJO {

	private Integer id;
	// email --required, email valid format , 6 --11
	@NotEmpty
	@Email
	@Length(min = 6, max = 20)
	private String email;
	// pass -- reqd, "a--z,A--Z,digit,@$#, min 5 10
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[@#$%]).{5,10})")
	private String password;
	// not null , 300--3000
	@NotNull
	@Range(min = 300, max = 3000)
	private double regAmount;
	@NotNull
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date regDate;
	@NotEmpty
	private String role;

	public ContactPOJO() {
		System.out.println("contact pojo constr");
		email = "valid email";
		regAmount = 500;
	}

	public ContactPOJO(String email, String password, double regAmount,
			Date regDate, String role) {
		super();
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	@Column(length = 20, unique = true)
	public String getEmail() {
		System.out.println("in get email");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("in set email");
		this.email = email;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Id
	@SequenceGenerator(name = "my_gen", sequenceName = "my_seq")
	@GeneratedValue(generator = "my_gen")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Contact Details id=" + id + ", email=" + email + ", password="
				+ password + ", regAmount=" + regAmount + ", regDate="
				+ regDate + ", role=" + role;
	}

}
