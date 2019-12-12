package com.app.contacts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "dac1_adr")
public class Address {

	private Long addressId;
	@NotEmpty
	private String street;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String zipcode;

	public Address() {
		System.out.println("in adr constr");
	}

	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Id
	@SequenceGenerator(name = "my_gen", sequenceName = "my_seq")
	@GeneratedValue(generator = "my_gen")

	@Column(name = "ADDRESS_ID")
	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	@Column(name = "ADDRESS_STREET", nullable = false, length=20)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "ADDRESS_CITY", nullable = false, length=20)
	public String getCity() {
		System.out.println("in get city");
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "ADDRESS_STATE", nullable = false, length=20)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ADDRESS_ZIPCODE", nullable = false, length=10)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		System.out.println("in zip code");
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "\n Address ID "+addressId+" "+" street=" + street + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode ;
	}
	

}