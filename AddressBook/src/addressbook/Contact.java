package addressbook;

public class Contact {

	String firstName;
	String lastName;
	String dateOfBirth;
	String phoneNumber;
	String street;
	String postalCode;
	String city;

	public Contact(String firstName, String lastName, String dateOfBirth, String phoneNumber, String street, String postalCode, String city) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName + " " + dateOfBirth + " " + phoneNumber + " " + street + " " + postalCode + " " + city + "\n";
	}
}
