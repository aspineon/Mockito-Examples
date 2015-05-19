package github.vikram.mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import github.vikram.mockito.model.CustomerManager;
import github.vikram.mockito.model.CustomerSummary;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReservationManagerTest {
	
	private static Logger logger = null;
	
	private ReservationManager rManager = null;
	private String TEST_CUSTOMER_NAME = "Ram";
	
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
		rManager = new ReservationManager();
	}
	
	@After
	public void destroyManager() {
		rManager = null;
	}
	
	@Test
	public void testNullCustomerLookupMustThrowException() {
		rManager.getCustomerReservation(TEST_CUSTOMER_NAME);
	}
	
	@Test
	public void testValidCustomerNameShouldGenerateValidCustomerSummary() {
		
		CustomerSummary cs = CustomerManager.getCustomerSummary(TEST_CUSTOMER_NAME);
		logger.info("Customer Summary: " + cs);
		
		assertNotNull(cs);
		assertEquals(cs.getFirstName(), TEST_CUSTOMER_NAME);
		
	}

	
	

}
