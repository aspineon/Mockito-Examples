package github.vikram.mockito.tdd;

import github.vikram.mockito.model.Customer;
import github.vikram.mockito.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationManager {
	
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private Map<String, Vehicle> reservations = new HashMap<String, Vehicle>();
	

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void makeReservation(Customer c, Vehicle v) {
		if(c == null || v == null) {
			throw(new IllegalArgumentException("Arguments can not be null"));
		}
		
		reservations.put(c.getFirstName(), v);	
	}
	
	public Vehicle getCustomerReservation(String customerName) {
		if(customerName == null) {
			throw(new IllegalArgumentException("Argument can not be null"));
		}
		
		return null;
		
	}
	
	
	
	

}
