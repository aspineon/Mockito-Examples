package github.vikram.mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import github.vikram.mockito.model.Customer;
import github.vikram.mockito.model.CustomerManager;
import github.vikram.mockito.model.CustomerSummary;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReservationManagerTest {
	
	private static Logger logger = null;
	
	private static String TEST_CUSTOMER_NAME = "Ram";
	private CustomerManager cManager = null;
	
	
	@Mock
	private CustomerDao daoMock = null;
	private static Customer dummyRam = null; 
	private static Customer dummyMurali = null; 
	
	
	@BeforeClass
	public static void init() {
		logger = Logger.getLogger("Test logger");	
		
	}
	
	@AfterClass
	public static void destroy() {
		logger = null;
	}
	
	@Before
	public void initManager() {
		cManager = CustomerManager.createInstance();
		
		MockitoAnnotations.initMocks(this);		
		dummyRam = new Customer();
		dummyRam.setFirstName("Mock-Ram");
		dummyRam.setLicenseNumber("Mock-Ram-License");
		
		dummyMurali = new Customer();
		dummyMurali.setFirstName("Mock-Murali");
		dummyMurali.setLicenseNumber("Mock-Murali-License");
		
		Mockito.when(daoMock.findCustomerByFirstName("Ram")).thenReturn(dummyRam);
		Mockito.when(daoMock.findCustomerByFirstName("Murali")).thenReturn(dummyMurali);
		
		cManager.setCustomerDao(daoMock);
		
		
	}
	
	@After
	public void destroyManager() {
		daoMock = null;
	}
	
	@Test
	public void testValidCustomerNameShouldGenerateValidCustomerSummary() {
		
		CustomerSummary cs = cManager.getCustomerSummary("Ram");
		
		assertNotNull(cs);
		logger.info("Customer Summary:" + cs);
		
		
	}

	
	

}
