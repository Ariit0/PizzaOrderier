package asgn2Tests;

import org.junit.Test;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;


/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author George Delosa
 *
 */
public class CustomerFactoryTests {
	//PUC, DNC, DVC
	Customer customer;
	
	@Test
	public void TestGetPickUpCustomer() throws CustomerException {
		customer = CustomerFactory.getCustomer("PUC", "Bobby", "0412345678", 0, 0);
	}
	
	@Test
	public void TestGetDriverDeliveryCustomer() throws CustomerException {
		customer = CustomerFactory.getCustomer("DVC", "Bobby", "0412345678", 2, 3);
	}
	
	@Test
	public void TestGetDroneDeliveryCustomer() throws CustomerException {
		customer = CustomerFactory.getCustomer("DNC", "Bobby", "0412345678", 7, -5);
	}
	
	@Test (expected = CustomerException.class)
	public void TestGetInvalidCodeCustomer() throws CustomerException {
		customer = CustomerFactory.getCustomer("DNCC", "Bobby", "0412345678", 7, -5);
	}
}
