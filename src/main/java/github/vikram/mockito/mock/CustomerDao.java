package github.vikram.mockito.mock;

import github.vikram.mockito.model.Customer;
import github.vikram.mockito.model.CustomerManager;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.lang.exception.ExceptionUtils;

public class CustomerDao {
	
	private static Logger logger = Logger.getLogger("CustomerDao");
	
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	private static EntityTransaction tx = null;
	private static CustomerManager cManager = null;
	private static String persistenceType = "persistence-memory";
	
	public Customer findCustomerByFirstName(String customerName) {
		
		Customer c = null;
		
		try{
			emf = Persistence.createEntityManagerFactory(persistenceType);
			em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName='"+customerName+"'");
			c = (Customer) query.getSingleResult();
			
		} catch(Exception e) {
			logger.info("Error trying to fetch customer record");
			logger.info(ExceptionUtils.getFullStackTrace(e));
		}finally {
		
			if (em != null) {
				em.close();
				emf.close();
			}
			
		}
		
		return c;
		
	}
	
	
	public Customer findCustomerByLastName(String customerName) {
		
		Customer c = null;
		
		try{
			emf = Persistence.createEntityManagerFactory(persistenceType);
			em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT c FROM Customer c WHERE c.lastName='"+customerName+"'");
			c = (Customer) query.getSingleResult();
			
		} catch(Exception e) {
			logger.info("Error trying to fetch customer record");
			//logger.info(ExceptionUtils.getFullStackTrace(e));
		}finally {
		
			if (em != null) {
				em.close();
				emf.close();
			}
			
		}
		
		return c;
		
	}
	
	
	public List<Customer> findAllCustomers() {
		
		List<Customer> customers = null;
		
		try{
			emf = Persistence.createEntityManagerFactory(persistenceType);
			em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT c FROM Customer c");
			customers = query.getResultList();
			
		} catch(Exception e) {
			logger.info("Error trying to fetch customer record");
			//logger.info(ExceptionUtils.getFullStackTrace(e));
		}finally {
		
			if (em != null) {
				em.close();
				emf.close();
			}
			
		}
		
		return customers;
		
	}
	
	public static Customer getCustomerByFirstName(String customerName){
		Customer c = null;
		
		try{
			emf = Persistence.createEntityManagerFactory(persistenceType);
			em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName='"+customerName+"'");
			c = (Customer) query.getSingleResult();
			
		} catch(Exception e) {
			logger.info("Error trying to fetch customer record");
			//logger.info(ExceptionUtils.getFullStackTrace(e));
		}finally {
		
			if (em != null) {
				em.close();
				emf.close();
			}
			
		}
		
		return c;
	}
	


}
