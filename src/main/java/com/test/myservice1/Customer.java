package com.test.myservice1;

public class Customer {
	private String idType;
	private String idNumber;
	private String firstName;
	private String secondName;
	private String firstSurame;
	private String secondSurname;
	private String phoneNumber;
	private String address;
	private String cityOfRes;
	
	public Customer() {}
	public Customer(String idType, String idNumber, String firstName, String secondName, String firstSurame,
			String secondSurname, String phoneNumber, String address, String cityOfRes) {
		super();
		this.idType = idType;
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.secondName = secondName;
		this.firstSurame = firstSurame;
		this.secondSurname = secondSurname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.cityOfRes = cityOfRes;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getFirstSurame() {
		return firstSurame;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public String getIdType() {
		return idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getCityOfRes() {
		return cityOfRes;
	}
	
	
	
	
}
