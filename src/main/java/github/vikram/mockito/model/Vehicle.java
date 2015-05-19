package github.vikram.mockito.model;

public class Vehicle {
	
	private String vehicleId;
	
	private double price;
	
	private String make;
	
	private String model;
	
	private int miles;
	
	

	public Vehicle(String vehicleId, double price, String make,
			String model, int miles) {
		this.vehicleId = vehicleId;
		this.price = price;
		this.make = make;
		this.model = model;
		this.miles = miles;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	@Override
	public String toString() {
		return "Vehicle [\n\tVehicleId = " + vehicleId + ", \n\tPrice = $" + price
				+ ", \n\tMake = " + make + ", \n\tModel = " + model + ", \n\tMiles = " + miles
				+ "\n\t]";
	}
	
	
	
	
	

}
