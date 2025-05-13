package com.ui.pojo;

public class AddressPOJO {
	
	private String companyName;
	private String AddressLine1;
	private String AddressLine2;
	private String city;
	private String postCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String aditionalInformation;
	private String addressTitle;
	private String state;
	public AddressPOJO(String companyName, String addressLine1, String addressLine2, String city, String postCode,
			String homePhoneNumber, String mobileNumber, String aditionalInformation, String addressTitle,
			String state) {
		super();
		this.companyName = companyName;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.aditionalInformation = aditionalInformation;
		this.addressTitle = addressTitle;
		this.state = state;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getAditionalInformation() {
		return aditionalInformation;
	}
	public String getAddressTitle() {
		return addressTitle;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "AddressPOJO [companyName=" + companyName + ", AddressLine1=" + AddressLine1 + ", AddressLine2="
				+ AddressLine2 + ", city=" + city + ", postCode=" + postCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", aditionalInformation=" + aditionalInformation
				+ ", addressTitle=" + addressTitle + ", state=" + state + "]";
	}

}
