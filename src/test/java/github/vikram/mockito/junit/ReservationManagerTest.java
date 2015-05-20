package github.vikram.mockito.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import github.vikram.mockito.model.Car;
import github.vikram.mockito.model.Customer;
import github.vikram.mockito.model.PickupTruck;
import github.vikram.mockito.model.Van;
import github.vikram.mockito.model.Vehicle;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ReservationManagerTest {
	
	private static Logger logger = null;
	private ReservationManager rManager = null;
	private String TEST_CUSTOMER_NAME = "Alice";
	
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
		rManager = new ReservationManager();
		loadManagerData(rManager);
		
	}
	
	/*
	 * @After us run after EVERY test case is executed.
	 * Use this section to destory or clear our objects
	 * that you inited in the @Before section
	 */
	@After
	public void destroyManager() {
		rManager = null;
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
	public void testVehicleLookUp(){
		
		/*
		 * 			SETUP
		 * All data is setup in @Before. Nothing specific to set here
		 */
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		Vehicle v = rManager.getCustomerReservation(TEST_CUSTOMER_NAME);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("Reservation for " + TEST_CUSTOMER_NAME + " -->\n" + v );
		assertEquals("Audi", v.getMake());
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
	 * You can specify if a particular test must expect a
	 * specific exception. Use the 'expected' parameter of
	 * @Test to specify the Exception class that is expected
	 * The test will fail if that Exception is not thrown
	 * 
	 * These types of methods are usually to test null parameters
	 * or special cases where you need the method to throw 
	 * and exception for a given input
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNullArgumentsShouldThrowException(){
		
		/*
		 * 			SETUP
		 * All data is setup in @Before. Nothing specific to set here
		 */
		
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test. Notice that the below execution
		 * is done within a try/catch block. This allows extra verification
		 * to be done in catch block once the required exception is caught
		 */
		try {
			rManager.makeReservation(null, null);
			
			logger.info("This line should not be printed");
			/*
			 * You can use the JUnit construct fail() to make a test fail
			 * when you know a specific line of code should not be reached.
			 */
			fail();
		} catch (IllegalArgumentException e) {
			logger.info("Caught IllegalArgumentException");
			throw e;
		}
		
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("This line should not be printed");
		fail();
		
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
	 * You can specify if a particular test must expect a
	 * specific exception. Use the 'expected' parameter of
	 * @Test to specify the Exception class that is expected
	 * The test will fail if that Exception is not thrown
	 * 
	 * These types of methods are usually to test null parameters
	 * or special cases where you need the method to throw 
	 * and exception for a given input
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNullCustomerLookupMustThrowException() {
		
		/*
		 * 			SETUP
		 * All data is setup in @Before. Nothing specific to set here
		 */
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test. Notice that the below execution
		 * is done within a try/catch block. This allows extra verification
		 * to be done in catch block once the required exception is caught
		 */	
		try {
			rManager.getCustomerReservation(null);
			
			logger.info("This line should not be printed");
			/*
			 * You can use the JUnit construct fail() to make a test fail
			 * when you know a specific line of code should not be reached.
			 */
			fail();
			
			
		} catch (IllegalArgumentException e) {
			logger.info("Caught IllegalArgumentException");
			throw e;
		}
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("This line should not be printed");
		fail();
		
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
	 * Sometimes you may need to ignore an existing test case
	 * or you may not want a test case to run. To make JUnit not run
	 * this test, annotate your @Test method with @Ignore
	 * 
	 */
	@Test
	@Ignore
	public void testIgnoreTestCase() {
		
		
		/*
		 * 			SETUP
		 * All data is setup in @Before. Nothing specific to set here
		 */
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test.
		 */ 
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("This line should not be printed");
		fail();
	}
	
	/*
	 * Methods that are not annotated with @Test are not 
	 * treated as test cases. They are just regular functions
	 * that may be called by your test cases. Use this section
	 * when there is a lot of initialization to do for a specific
	 * object and you want it to be part of a separate function
	 */
	public void loadManagerData(ReservationManager rManager) {
		
		//Create Vehicles
		Vehicle audi = new Car("Audi", "A5", 42000, "1234-456", 47500.00);
		Vehicle chevy = new Van("Chevy", "E250", 18000, "ABCD-1234", 16000.00);
		Vehicle ford = new PickupTruck("Ford", "F150", 5000, "AOJH-6676", 22500.00);
		
		rManager.getVehicles().add(audi);
		rManager.getVehicles().add(chevy);
		rManager.getVehicles().add(ford);	
		
		//Create Customers
		Customer alice = new Customer(1000L, "Alice", "B", "100 San Francisco Rd", "4XER132");
		Customer bob = new Customer(1001L, "Bob", "D", "101 New York Rd", "6RCC215");
		Customer charlie = new Customer(1002L, "Charlie", "A", "102 Austin Rd", "9CZW481");
		
		//Create Reservations
		rManager.makeReservation(alice, audi);
		rManager.makeReservation(bob, chevy);
		rManager.makeReservation(charlie, ford);
		
		
	}
	

}
