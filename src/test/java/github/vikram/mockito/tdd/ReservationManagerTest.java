package github.vikram.mockito.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import github.vikram.mockito.mock.CustomerDao;
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
	private String TEST_CUSTOMER_NAME = "Alice";
	private CustomerManager cManager = null;
	
	/*
	 * The @BeforeClass annotation is run ONCE before
	 * beginning to execute any of the test cases. You
	 * can use this section to define objects such as loggers
	 */
	@BeforeClass
	public static void init() {
		logger = Logger.getLogger("Test logger");
	}
	
	
	/*
	 * The @AfterClass annotation is run ONCE after
	 * all the tests have been executed. You can
	 * use this section to destroy or clear any resources
	 * you have allocated in the @BeforeClass section
	 */
	@AfterClass
	public static void destroy() {
		logger = null;
	}
	
	
	/*
	 * @Before section is run before EVERY test. Use this
	 * section to initialize objects that need to be inited
	 * for every run
	 */
	@Before
	public void initManager() {
		cManager = CustomerManager.createInstance();
		cManager.setCustomerDao(new CustomerDao());
		
	}
	
	
	/*
	 * @After us run after EVERY test case is executed.
	 * Use this section to destory or clear our objects
	 * that you inited in the @Before section
	 */
	@After
	public void destroyManager() {
		cManager = null;
	}
	
	
	/*
	 * Methods annotated with @Test signal JUnit to treat
	 * this as a test case. 
	 * 
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 *
	 */
	@Test
	public void testValidCustomerNameShouldGenerateValidCustomerSummary() {
		
		/*
		 * 			SETUP
		 * All data is setup in @Before. Nothing specific to set here
		 */
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		
		CustomerSummary cs = cManager.getCustomerSummary(TEST_CUSTOMER_NAME);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		assertNotNull(cs);
		assertEquals(cs.getFirstName(), TEST_CUSTOMER_NAME);
		logger.info("Customer Summary: " + cs);
		
		
	}

	
	

}
