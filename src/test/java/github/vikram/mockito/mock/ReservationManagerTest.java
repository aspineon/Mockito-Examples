package github.vikram.mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import github.vikram.mockito.model.Customer;
import github.vikram.mockito.model.CustomerDao;
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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/*
 * Annotate the class with @RunWith(MockitoJUnitRunner.class)
 * if you intend to use @Mock to create mock instances
 */
@RunWith(MockitoJUnitRunner.class)
public class ReservationManagerTest {
	
	private static Logger logger = null;
	
	private CustomerManager cManager = null;
	
	
	/*
	 * You can use @Mock annotation to define a mock.
	 * The following statement creates a mock of type
	 * CustomerDao.class. Another way to defining a mock
	 * is by doing
	 * 
	 * 	CustomerDao daoMock = Mockito.mock(CustomerDao.class);
	 *
	 */
	@Mock
	private CustomerDao daoMock = null;
	private static Customer dummyAlice = null; 
	private static Customer dummyBob = null; 
	
	
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
	 * use this section to destory or clear any resources
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
		
		/*
		 * This is optional if you hav already annotated
		 * this class with @RunWith(MockitoJUnitRunner.class) 
		 */
		MockitoAnnotations.initMocks(this);
		
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
		dummyAlice = new Customer();
		dummyAlice.setFirstName("Mock-Alice");
		dummyAlice.setLicenseNumber("Mock-Alice-License");
		
		dummyBob = new Customer();
		dummyBob.setFirstName("Mock-Bob");
		dummyBob.setLicenseNumber("Mock-Bob-License");
		
	}
	
	/*
	 * @After us run after EVERY test case is executed.
	 * Use this section to destory or clear our objects
	 * that you inited in the @Before section
	 */
	@After
	public void destroyManager() {
		daoMock = null;
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
	//@Ignore
	public void testMockitoToMockGivenInputArgument() {
		
		
		/*							SETUP
		 * You need to specify the mock action for each unique input
		 * For example, below mocks the stub to return object dummyAlice only if
		 * the argument passed is "Alice". 
		 * 
		 * As you can see, mockito follows a when/then pattern that is easy to read
		 * 
		 */
		Mockito.when(daoMock.findCustomerByFirstName("Alice")).thenReturn(dummyAlice);
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("Alice");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);
		logger.info("Customer Summary:" + cs);
		
		
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
	//@Ignore
	public void testMockitoToMockADifferentInputArgument() {
		
		
		/*							SETUP
		 * The above call, defines the mock behavior ONLY if the input
		 * passed to findCustomerById() method is "Alice".
		 * 
		 * If you want to mock for another input argument, say, "Bob",
		 * then you need to define another mock action as shown below
		 */
		Mockito.when(daoMock.findCustomerByFirstName("Bob")).thenReturn(dummyBob);
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("Bob");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);
		assertEquals(cs.getFirstName(), dummyBob.getFirstName());
		logger.info("Customer Summary:" + cs);
		
		
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
	//@Ignore
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
		Mockito.when(daoMock.findCustomerByFirstName(Matchers.anyString())).thenReturn(dummyBob);
		
		
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
		assertEquals(cs.getFirstName(), dummyBob.getFirstName());
		logger.info("Customer Summary:" + cs);
		
		
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
	//@Ignore
	public void testMockitoPartialMock() {
		
		
		/*							SETUP
		 * Sometimes, you only may need to mock for a specific input param,
		 * and for another input param, you may want to call the actual implemenation
		 * instead of the mocked implementation. In that case you can call
		 * thenCallRealMethod() as shown below
		 */
		Mockito.when(daoMock.findCustomerByFirstName("Alice")).thenReturn(dummyAlice);
		Mockito.when(daoMock.findCustomerByFirstName("Bob")).thenCallRealMethod();
		
		
		
		/*
		 * 							EXECUTION
		 * Invoke the method for which you defined the mock behavior and 
		 * pass in the appropriate arguments
		 */
		CustomerSummary cs = cManager.getCustomerSummary("Alice");
		CustomerSummary cs2 = cManager.getCustomerSummary("Bob");
		
		
		/*							VERIFICATION
		 * This is where you use the result returned by the execution step
		 * and perform valiation operations on it.
		 * 
		 */
		assertNotNull(cs);		
		assertEquals(cs.getFirstName(), dummyAlice.getFirstName());
		logger.info("Customer Summary:" + cs2);
		
		/*
		 * Real implementation would return customer name as "Bob"
		 * and not "Mock-Bob"
		 */
		assertEquals(cs2.getFirstName(), "Bob");
		assertNotNull(cs2);
		logger.info("Customer Summary 2:" + cs2);
		
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
	//@Ignore
	public void testMockitoVerifyMock() {
		
		
		/*							SETUP
		 * Define the mock
		 */
		Mockito.when(daoMock.findCustomerByFirstName(Matchers.anyString())).thenReturn(dummyBob);
		
		
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
		assertEquals(cs.getFirstName(), dummyBob.getFirstName());
		logger.info("Customer Summary:" + cs);
		
		/*
		 * After you have defined your mocks, your mock may or may not be invoked
		 * depending on the codeflow. To check how many times your mock action
		 * was triggered you can use the Mockito.verify method as shown below
		 */
		
		Mockito.verify(daoMock, Mockito.times(1)).findCustomerByFirstName("RandomString");
		
		
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
	//@Ignore
	public void testMockitoSpy() {
		
		
		/*							SETUP
		 * Spy Test. Mockito.spy() can be used to wrap a real object.
		 * Unless otherwise specified, every call is delegated to the real object.
		 */
		List<Customer> list = cManager.listCustomers();
		List<Customer> spy = Mockito.spy(list);
		Mockito.doReturn(dummyAlice).when(spy).get(0);
			
		
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
		assertEquals(spy.get(0).getFirstName(), dummyAlice.getFirstName());
		logger.info("Customer:" + spy.get(0));
		

		
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
	//@Ignore
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
			
			logger.info("This line should not be printed");
			
			/*
			 * You can use JUnit construct "fail()" to make the test
			 * fail() at any point.
			 */
			fail();
			
			
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
	 * For these advanced features, you can use PowerMockito or PowerMock.
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
