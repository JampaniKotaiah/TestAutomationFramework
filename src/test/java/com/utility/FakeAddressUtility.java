package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	
	public static void main(String[] args) {
		
		getFakeAddress();
	}
	
	public static AddressPOJO getFakeAddress() {
		
		Faker faker = new Faker(Locale.US);
		
		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(),faker.address().buildingNumber(),faker.address().streetName(),faker.address().city(),faker.address().zipCode(),
					faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),faker.name().fullName(),"office addres","Texas");
		
		return addressPOJO;
		
	}

}
