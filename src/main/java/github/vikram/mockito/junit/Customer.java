package github.vikram.mockito.junit;

public class Customer {
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String licenseNumber;

	public Customer(String firstName, String lastName, String address,
			String licenseNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.licenseNumber = licenseNumber;
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

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	
	
	

}
