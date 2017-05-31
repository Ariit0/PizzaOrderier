package asgn2Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
PizzaRestaurant pizzaRestaurant;
	
	@Before
	public void Init() throws CustomerException, PizzaException, LogHandlerException {
		pizzaRestaurant = new PizzaRestaurant();
		pizzaRestaurant.processLog(".//logs/20170101.txt");
	}
	
	@Test
	public void TestProcessLog() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(pizzaRestaurant.processLog(".//logs/20170102.txt") == true);
		assertTrue(pizzaRestaurant.processLog(".//logs/20170103.txt") == true);
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestProcessLogThrowsLogHandlerException() throws CustomerException, PizzaException, LogHandlerException {
		pizzaRestaurant.processLog(".//logs/CustomerDatasetTestLog1.txt");
	}
	
	@Test (expected = CustomerException.class)
	public void TestProcessLogThrowsCustomerException() throws CustomerException, PizzaException, LogHandlerException {
		pizzaRestaurant.processLog(".//logs/CustomerDatasetTestLog2.txt");
	}
	
	@Test
	public void TestGetNumCustomerOrders() {
		assertTrue(pizzaRestaurant.getNumCustomerOrders() == 3);
	}
	
/* -------------- testing line in log 20170101: 19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2 -------------- */
	@Test
	public void TestGetCustomerByIndex() throws CustomerException {
		assertTrue(pizzaRestaurant.getCustomerByIndex(0).getCustomerType().equals("Driver Delivery"));
		assertTrue(pizzaRestaurant.getCustomerByIndex(0).getName().equals("Casey Jones"));
		assertTrue(pizzaRestaurant.getCustomerByIndex(0).getLocationX() == 5);
		assertTrue(pizzaRestaurant.getCustomerByIndex(0).getLocationY() == 5);
		assertTrue(pizzaRestaurant.getCustomerByIndex(0).getMobileNumber().equals("0123456789"));
		assertTrue(pizzaRestaurant.getCustomerByIndex(0).getDeliveryDistance() == 10);
	}
	
	@Test (expected = CustomerException.class)
	public void TestGetCustomerByInvalidIndex() throws CustomerException {
		pizzaRestaurant.getCustomerByIndex(3).getCustomerType().equals("Driver Delivery");
	}

	@Test
	public void TestGetTotalDeliveryDistance() throws CustomerException {
		double totalDistance = 0;
		for (int i = 0; i < pizzaRestaurant.getNumCustomerOrders(); i++) {
			totalDistance += pizzaRestaurant.getCustomerByIndex(i).getDeliveryDistance();
		}
		assertTrue(pizzaRestaurant.getTotalDeliveryDistance() == totalDistance);
	}
	
	@Test
	public void TestResetDetails() {
		pizzaRestaurant.resetDetails();
		assertTrue(pizzaRestaurant.getNumCustomerOrders() == 0);
	}
}
