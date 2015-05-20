package github.vikram.mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import github.vikram.mockito.junit.Calculator;

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

/*
 * Annotate the class with @RunWith(MockitoJUnitRunner.class)
 * if you intend to use @Mock to create mock instances
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {
	
	private static Logger logger = null;
	
	/*
	 * You can use @Mock annotation to define a mock.
	 * The following statement creates a mock of type
	 * Calculator.class. 
	 * 
	 *  If you use annotations, you must initialize this mock objects with a MockitoAnnotations.initMocks(this) 
	 *  method call or annotate your class with the @RunWith(MockitoJUnitRunner.class) annotation 
	 *  to use the Mockito test runner.
	 * 
	 * Another way to defining a mock
	 * is by doing
	 * 
	 * 	Calculator mockCalc = Mockito.mock(Calculator.class);
	 *
	 */
	@Mock
	private Calculator mockCalc = null;
	
	private Calculator realCalc = null;
	
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
		/*
		 * This is optional if you hav already annotated
		 * this class with @RunWith(MockitoJUnitRunner.class) 
		 */
		MockitoAnnotations.initMocks(this);
		
		realCalc = new Calculator();
	}
	
	/*
	 * @After us run after EVERY test case is executed.
	 * Use this section to destory or clear our objects
	 * that you inited in the @Before section
	 */
	@After
	public void destroyCalculator() {
		mockCalc = null;
		realCalc = null;
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
	public void testMockAdditionOfTwoIntsToReturnResultOfMultiply(){
		
		/*
		 * 			SETUP
		 * Use this section to setup input params specific to this test.
		 * We already defined myCalc in the @Before section
		 */
		int a = 2;
		int b = 3;
		Mockito.when(mockCalc.add(a, b)).thenReturn(realCalc.multiply(a, b));
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		int result = mockCalc.add(a, b);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("Result is " +result);
		
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
	public void testMockSubtractionOfTwoIntsToReturnResultODivision(){
		
		/*
		 * 			SETUP
		 * Use this section to setup input params specific to this test.
		 * We already defined myCalc in the @Before section
		 */
		int a = 10;
		int b = 2;
		Mockito.when(mockCalc.subtract(a, b)).thenReturn((a/b));
		
		
		/*
		 * 			EXECUTION
		 * Execute the method under test
		 */	
		int result = mockCalc.subtract(a, b);
		
		
		/*			VERIFICATION
		 * Verify the result returned by the above invocation
		 * 
		 */	
		logger.info("Result is " +result);
		
		assertNotNull(result);
		assertEquals(5, result);
	}
	
	
	
	
	

}
