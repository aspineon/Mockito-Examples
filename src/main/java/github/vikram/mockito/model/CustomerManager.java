package github.vikram.mockito.model;

import github.vikram.mockito.mock.CustomerDao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerManager {
	
	private static Logger logger = Logger.getLogger("CustomerManager");
	private CustomerDao customerDao = null;
	private static CustomerManager cManager = null;
	
	
	
	public CustomerManager() {
		
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

	
	
	
	

}