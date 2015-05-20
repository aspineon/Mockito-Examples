package github.vikram.mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import github.vikram.mockito.model.Customer;
import github.vikram.mockito.model.CustomerManager;
import github.vikram.mockito.model.CustomerSummary;

import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReservationManagerTest {
	
	private static Logger logger = null;
	
	private static String TEST_CUSTOMER_NAME = "Ram";
	private CustomerManager cManager = null;
	
	
	/*
	 * You can @Mock annotation to define a mock.
	 * The following statement creates a mock of type
	 * CustomerDao.class. Another way to defining a mock
	 * is shown in testMockitoChaining()
	 *
	 */
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
	
	
	//Define mockito to return dummyObjects instead of making calls to DB
	@Before
	public void initManager() {
		
		
		/* 
		 * Create a new instance of CustomerManager. The constructor in 
		 * CustomerManager is made private so the only way to init is to
		 * use the createInstance method(). This method ensures a single
		 * instance of CustomerManager is used for the entire application
		 * i.e, Singleton pattern
		 */
		cManager = CustomerManager.createInstance();
		
		
		/*
		 * Set the mock object to the instance of CustomerManager we created
		 */
		cManager.setCustomerDao(daoMock);
		
		
		
		/*
		 * Create 2 dummy objects that are used by our mock
		 * as return objects for different sets of input params
		 */
		dummyRam = new Customer();
		dummyRam.setFirstName("Mock-Ram");
		dummyRam.setLicenseNumber("Mock-Ram-License");
		
		dummyMurali = new Customer();
		dummyMurali.setFirstName("Mock-Murali");
		dummyMurali.setLicenseNumber("Mock-Murali-License");
		
	}
	
	@After
	public void destroyManager() {
		daoMock = null;
	}
	
	
	/*
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 */
	@Test
	public void testMockitoToMockGivenInputArgument() {
		
		
		/*							SETUP
		 * You need to specify the mock action for each unique input
		 * For example, below mocks the stub to return object dummyRam only if
		 * the argument passed is "Ram". 
		 * 
		 * As you can see, mockito follows a when/then pattern that is easy to read
		 * 
		 */
		Mockito.when(daoMock.findCustomerByFirstName("Ram")).thenReturn(dummyRam);
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("Ram");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);
		logger.info("Customer Summary:" + cs);
		
		
	}
	
	/*
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 */
	@Test
	public void testMockitoToMockADifferentInputArgument() {
		
		
		/*							SETUP
		 * The above call, defines the mock behavior ONLY if the input
		 * passed to findCustomerById() method is "Ram".
		 * 
		 * If you want to mock for another input argument, say, "Murali",
		 * then you need to define another mock action as shown below
		 */
		Mockito.when(daoMock.findCustomerByFirstName("Murali")).thenReturn(dummyMurali);
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("Murali");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);
		assertEquals(cs.getFirstName(), dummyMurali.getFirstName());
		logger.info("Customer Summary:" + cs);
		
		
	}
	
	
	/*
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 */
	@Test
	public void testMockitoForWideRangeOfInput() {
		
		
		/*							SETUP
		 * If you want to specify a single mock action for a wide range of inputs,
		 * you can use Matchers to match a given range of input params.
		 * You can use Matchers.any(ABC.class) to match any object of class ABC
		 * 
		 * Or you can specific a collection of a given type. Such as
		 * 		Set<ABC>Matchers.anySet() or
		 * 		Matchers.anySetOf(ABC.class)
		 * 
		 * You can also specify a regex in the Matchers argument
		 */
		Mockito.when(daoMock.findCustomerByFirstName(Matchers.anyString())).thenReturn(dummyMurali);
		
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("RandomString");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);
		assertEquals(cs.getFirstName(), dummyMurali.getFirstName());
		logger.info("Customer Summary:" + cs);
		
		
	}
	
	
	/*
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 */
	@Test
	public void testMockitoPartialMock() {
		
		
		/*							SETUP
		 * Sometimes, you only may need to mock for a specific input param,
		 * and for another input param, you may want to call the actual implemenation
		 * instead of the mocked implementation. In that case you can call
		 * thenCallRealMethod() as shown below
		 */
		Mockito.when(daoMock.findCustomerByFirstName("Ram")).thenReturn(dummyRam);
		Mockito.when(daoMock.findCustomerByFirstName("Murali")).thenCallRealMethod();
		
		
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("Ram");
		CustomerSummary cs2 = cManager.getCustomerSummary("Murali");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);		
		assertEquals(cs.getFirstName(), dummyRam.getFirstName());
		logger.info("Customer Summary:" + cs2);
		
		/*
		 * Real implementation would return customer name as "Murali"
		 * and not "Mock-Murali"
		 */
		assertEquals(cs2.getFirstName(), "Murali");
		assertNotNull(cs2);
		logger.info("Customer Summary:" + cs2);
		
	}
	
	
	/*
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 */
	@Test
	public void testMockitoVerifyMock() {
		
		
		/*							SETUP
		 * Define the mock
		 */
		Mockito.when(daoMock.findCustomerByFirstName(Matchers.anyString())).thenReturn(dummyMurali);
		
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("RandomString");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);
		assertEquals(cs.getFirstName(), dummyMurali.getFirstName());
		logger.info("Customer Summary:" + cs);
		
		/*
		 * After you have defined your mocks, your mock may or may not be invoked
		 * depending on the codeflow. To check how many times your mock action
		 * was triggered you can use the Mockito.verify method as shown below
		 */
		
		Mockito.verify(daoMock, Mockito.times(1)).findCustomerByFirstName("RandomString");
		
		
	}

	/*
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 */
	@Test
	public void testMockitoSpy() {
		
		
		/*							SETUP
		 * Spy Test. Mockito.spy() can be used to wrap a real object.
		 * Unless otherwise specified, every call is delegated to the real object.
		 */
		List<Customer> list = cManager.listCustomers();
		List<Customer> spy = Mockito.spy(list);
		Mockito.doReturn(dummyRam).when(spy).get(0);
			
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		logger.info(spy.get(0).toString());
		logger.info(spy.get(1).toString());
		logger.info(spy.get(2).toString());
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(spy.get(0));
		assertEquals(spy.get(0).getFirstName(), dummyRam.getFirstName());
		logger.info("Customer:" + spy.get(0));
		

		
	}
	
	
	
	/*
	 * All test cases must follow this convention of
	 * 			Setup
	 * 			Execution
	 * 			Verification
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testMockitoException() {
		
		
		/*							SETUP
		 * Mocks can be defined to throw specific exceptions 
		 * for your test cases. The mock defined below will throw
		 * an IllegalArgumentException for any input string passed to
		 * findCustomerByFirstName() method
		 */
		Mockito.when(daoMock.findCustomerByFirstName(Matchers.any(String.class)))
		.thenThrow(IllegalArgumentException.class);
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		try {
			CustomerSummary cs = cManager.getCustomerSummary("RandomString");
		} catch (IllegalArgumentException e) {
			logger.info("Got IllegalArgumentException");
			throw e;
		}
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		logger.info("This line should not be printed");
		
		/*
		 * You can use JUnit construct "fail()" to make the test
		 * fail() at any point.
		 */
		fail();
		
	}
	
	
	
	/*
	 * 				When Mockito is not enough
	 * Mockito does not have the ability to mock 
	 * 		private methods
	 * 		static methods (Used by most Utils classes)
	 * 		final methods
	 * 
	 * Mockito does not provide the capability to mock objects
	 * that are not passed in through arguments or constructors
	 * 
	 * In the example we discussed, CustomerDao is set via a setter
	 * 
	 * What if CustomerDao is not accessible via arguments or setters?
	 * 
	 * For these advanced features, you can use PowerMock.
	 * While mockito uses a proxy-based approach to intercept calls
	 * and return values, PowerMock uses a custom class loader
	 * and manipulates the byte code.
	 * 
	 * You can use Mockito and PowerMock in conjuction making Mockito
	 * your default choice of mock behavior and only using PowerMock 
	 * in exceptional needs. That said, there is nothing preventing you
	 * to use PowerMock directly for all operations. PowerMock byt deafult,
	 * will delegate all the operations to Mockito if Mockito is capable 
	 * of handling it.
	 */

	
	

}
