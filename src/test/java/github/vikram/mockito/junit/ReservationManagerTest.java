package github.vikram.mockito.junit;

import static org.junit.Assert.assertEquals;

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
		loadManagerData(rManager);
		
	}
	
	public void loadManagerData(ReservationManager rManager) {
		
		//Create Vehicles
		Vehicle audi = new Car("Audi", "A5", 42000, "1234-456", 47500.00);
		Vehicle chevy = new Van("Chevy", "E250", 18000, "ABCD-1234", 16000.00);
		Vehicle ford = new PickupTruck("Ford", "F150", 5000, "AOJH-6676", 22500.00);
		
		rManager.getVehicles().add(audi);
		rManager.getVehicles().add(chevy);
		rManager.getVehicles().add(ford);	
		
		//Create Customers
		Customer murali = new Customer("Murali", "Anantha", "San Francisco", "4XER132");
		Customer sajjad = new Customer("Sajjad", "Raza", "Fremont", "6RCC215");
		Customer ram = new Customer("Ram", "Kuchimanchi", "Austin", "9CZW481");
		
		//Create Reservations
		rManager.makeReservation(murali, audi);
		rManager.makeReservation(sajjad, chevy);
		rManager.makeReservation(ram, ford);
		
		
	}
	
	@After
	public void destroyManager() {
		rManager = null;
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullArgumentsShouldThrowException(){
		rManager.makeReservation(null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullCustomerLookupMustThrowException() {
		rManager.getCustomerReservation(null);
		
	}
	
	@Test
	public void testVehicleLookUp(){
		Vehicle v = rManager.getCustomerReservation(TEST_CUSTOMER_NAME);
		logger.info("Reservation for " + TEST_CUSTOMER_NAME + " -->\n" + v );
		assertEquals("Ford", v.getMake());
	}
	
	@Test
	@Ignore
	public void testIgnoreTestCase() {
		logger.info("This line will not be printed");
	}
	
	
	

}
