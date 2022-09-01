package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelperFaker {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	
	public static DataHelperFaker getData() {
		return new DataHelperFaker();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getFullName() {
		return faker.name().fullName();
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	
	public String getCompanyName() {
		return faker.company().name();
	}
	
	public String getCity() {
		return faker.address().city();
	}
	
	public String getPhone() {	
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getAddress() {
		return faker.address().streetAddress();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
	
}
