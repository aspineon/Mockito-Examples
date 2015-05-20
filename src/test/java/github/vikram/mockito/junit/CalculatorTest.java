package github.vikram.mockito.junit;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	private static Logger logger = null;
	private Calculator myCalc = null;
	
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
	public void initCalculator() {
		myCalc = new Calculator();
		
	}
	
	/*
	 * @After us run after EVERY test case is executed.
	 * Use this section to destory or clear our objects
	 * that you inited in the @Before section
	 */
	@After
	public void destroyCalculator() {
		myCalc = null;
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
	public void testAddTwoIntsMustReturnCorrectValue(){
		
		/*
		 * 			SETUP
		 * Use this section to setup input params specific to this test.
		 * We already defined myCalc in the @Before section
		 */
		int a = 2;
		int b = 3;
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		int result = myCalc.add(a, b);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("Result is " + result);
		
		assertNotNull(result);
		assertEquals(5, result);
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
	public void testSubtractTwoIntsMustReturnCorrectValue(){
		
		/*
		 * 			SETUP
		 * Use this section to setup input params specific to this test.
		 * We already defined myCalc in the @Before section
		 */
		int a = 3;
		int b = 2;
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		int result = myCalc.subtract(a, b);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("Result is " + result);
		
		assertNotNull(result);
		assertEquals(1, result);
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
	public void testMultiplyTwoIntsMustReturnCorrectValue(){
		
		/*
		 * 			SETUP
		 * Use this section to setup input params specific to this test.
		 * We already defined myCalc in the @Before section
		 */
		int a = 3;
		int b = 2;
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		int result = myCalc.multiply(a, b);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("Result is " + result);
		
		assertNotNull(result);
		assertEquals(6, result);
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
	public void testDivideTwoIntsMustReturnCorrectValue(){
		
		/*
		 * 			SETUP
		 * Use this section to setup input params specific to this test.
		 * We already defined myCalc in the @Before section
		 */
		int a = 3;
		int b = 2;
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		int result = myCalc.divide(a, b);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("Result is " + result);
		
		assertNotNull(result);
		assertEquals(1, result);
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
	@Test(expected=ArithmeticException.class)
	public void testDivideTwoByZeroMustThrowArithmeticException(){
		
		/*
		 * 			SETUP
		 * Use this section to setup input params specific to this test.
		 * We already defined myCalc in the @Before section
		 */
		int a = 3;
		int b = 0;
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		int result = 0;
		try {
			result = myCalc.divide(a, b);
			
			logger.info("This line should not be printed");
			fail();
			
		} catch (ArithmeticException e) {
			logger.info("Got IllegalArgumentException");
			throw e;
		}
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("This line should not be printed");
		fail();
	}
	
	

}
