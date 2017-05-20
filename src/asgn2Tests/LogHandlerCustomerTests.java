package asgn2Tests;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Restaurant.LogHandler;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	// TO DO
	Customer customer;
	
	@Before
	public void Init() throws CustomerException {
		customer = CustomerFactory.getCustomer("DVC", "Bobby", "0412345678", 2, 3);
	}
	
	@Test
	public void TestCreateCustomer() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestCreateCustomerTooManyParameters() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2,1,5,3,2,12");
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestCreateCustomerTooFewParameters() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones");
	}

	@Test (expected = CustomerException.class)
	public void TestCreateCustomerInvalidName() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00, ,0123456789,DVC,5,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void TestCreateCustomerInvalidMobileNumber() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789999999,DVC,5,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void TestCreateCustomerInvalidCode() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVVC,5,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void TestCreateCustomerInvalidXLocation() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,11,5,PZV,2");
	}
	
	@Test (expected = CustomerException.class)
	public void TestCreateCustomerInvalidYLocation() throws CustomerException, LogHandlerException {
		LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,-11,PZV,2");
	}
	
	@Test
	public void TestPopulateCustomerDataset() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset("logs/20170101.txt");
		LogHandler.populateCustomerDataset("logs/20170102.txt");
		LogHandler.populateCustomerDataset("logs/20170103.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestPopulateCustomerDatasetInvalidLogStructure() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset("logs/CustomerDatasetTestLog1.txt");
	}
	
	@Test (expected = CustomerException.class)
	public void TestPopulateCustomerDatasetInvalidDataSemantics() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset("logs/CustomerDatasetTestLog2.txt");
	}
}
