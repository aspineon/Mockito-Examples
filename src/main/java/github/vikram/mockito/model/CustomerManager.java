package github.vikram.mockito.model;

import github.vikram.mockito.mock.CustomerDao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerManager {
	
	private static Logger logger = Logger.getLogger("CustomerManager");
	private CustomerDao customerDao = null;
	private static CustomerManager cManager = null;
	
	
	
	private CustomerManager() {
		
	}

	public static CustomerManager createInstance() {
		
		if(cManager == null) {
			cManager = new CustomerManager();
			cManager.setCustomerDao(new CustomerDao());
		}
		
		return cManager;
		
		
	}
	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public CustomerSummary getCustomerSummary(String customerName) {
		
		
		Customer c = customerDao.findCustomerByFirstName(customerName);
		
		CustomerSummary cs = generateCustomerSummary(c);
		
		return cs;
		
		
	}
	
	private CustomerSummary generateCustomerSummary(Customer c) {
		CustomerSummary cs = new CustomerSummary();
		
		cs.setFirstName(c.getFirstName());
		cs.setLicenseNumber(c.getLicenseNumber());
		
		return cs;
		
	}
	
	public Customer getCustomerByFirstName(String customerName) {
		return(customerDao.findCustomerByFirstName(customerName));
	}

	
	public List<Customer> listCustomers() {
		List<Customer> customers  = new ArrayList<Customer>();
		
		customers.add(new Customer(1L, "Ram", "K", "NY", "ABC123"));
		customers.add(new Customer(2L, "Murali", "A", "SF", "XYZ123"));
		customers.add(new Customer(3L, "Sajjad", "R", "FR", "123ABC"));
		
		
		return customers;
	}
	
	

}
