package github.vikram.mockito.model;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerManager {
	
	private static Logger logger = Logger.getLogger("CustomerManager");
	
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	private static EntityTransaction tx = null;
	

	private CustomerManager() {
		
	}
	
	public static Customer getCustomer(String customerName) {
		
		Customer c = null;
		
		try{
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName='"+customerName+"'");
			c = (Customer) query.getSingleResult();
			
		} catch(Exception e) {
			logger.info("Error trying to fetch customer record");
		}finally {
		
			em.close();
			emf.close();
			
		}
		
		return c;
		
	}
	
	public static CustomerSummary getCustomerSummary(String customerName) {
		
		CustomerSummary cs = new CustomerSummary();
		
		Customer c = CustomerManager.getCustomer(customerName);
		
		cs.setFirstName(c.getFirstName());
		cs.setLicenseNumber(c.getLicenseNumber());
		
		return cs;
		
	}
	
	
	

}
