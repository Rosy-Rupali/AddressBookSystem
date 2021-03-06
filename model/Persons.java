/**************************************************
 * Purpose : It is a POJO concept program to store contact details
 * @author Rosy Rupali
 * @since 07-06-2021
 *
 *************************************************/
package model;

import java.util.Objects;

public class Persons {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String email;
	private int zip;
	private long phoneNumber;
	
	//Parameterized constructor
	public Persons(String firstName, String lastName, String address, String city, String state, String email, int zip,
			long phoneNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setEmail(email);
		setZip(zip);
		setPhoneNumber(phoneNumber);
	}
	

	public Persons() {
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Persons [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", email=" + email + ", zip=" + zip + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
