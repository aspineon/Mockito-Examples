package github.vikram.mockito.model;

public class CustomerSummary {
	
	private String firstName;
	
	private String licenseNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@Override
	public String toString() {
		return "CustomerSummary [firstName=" + firstName + ", licenseNumber="
				+ licenseNumber + "]";
	}
	
	
	

}
