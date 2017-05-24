package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	PizzaRestaurant pizzaRestaurant;
	
	@Before
	public void Init() throws CustomerException, PizzaException, LogHandlerException {
		pizzaRestaurant = new PizzaRestaurant();
		pizzaRestaurant.processLog("logs/20170101.txt");
	}
	
	@Test
	public void TestProcessLog() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(pizzaRestaurant.processLog("logs/20170102.txt") == true);
		assertTrue(pizzaRestaurant.processLog("logs/20170103.txt") == true);
	}
	
	@Test
	public void TestProcessLogFail() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(pizzaRestaurant.processLog("logs/PizzaDatasetTestLog1.txt") == false);
	}
	
	@Test
	public void TestGetNumPizzaOrders() {
		assertTrue(pizzaRestaurant.getNumPizzaOrders() == 3);
	}
	
/* -------------- testing line in log 20170101: 19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2 -------------- */
	@Test
	public void TestGetPizzaByIndex() throws PizzaException {
		assertTrue(pizzaRestaurant.getPizzaByIndex(0).getPizzaType().equals("Vegetarian"));
		assertTrue(pizzaRestaurant.getPizzaByIndex(0).getQuantity() == 2);
		assertTrue(pizzaRestaurant.getPizzaByIndex(0).getOrderPrice() == 20.0);
		assertTrue(pizzaRestaurant.getPizzaByIndex(0).getPricePerPizza() == 10.0);
	}
	
	@Test
	public void TestGetTotalProfit() throws PizzaException {
		double totalProfit = 0;
		for (int i = 0; i < pizzaRestaurant.getNumPizzaOrders(); i++) {
			totalProfit += pizzaRestaurant.getPizzaByIndex(i).getOrderProfit();
		}
		
		assertTrue(pizzaRestaurant.getTotalProfit() == totalProfit);
	}
	
	@Test
	public void TestResetDetails() {
		pizzaRestaurant.resetDetails();
		assertTrue(pizzaRestaurant.getNumPizzaOrders() == 0);
	}
}
