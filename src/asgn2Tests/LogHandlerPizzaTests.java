package asgn2Tests;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Restaurant.LogHandler;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;


/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	
	@Test
	public void TestCreatePizza() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}

	@Test (expected = LogHandlerException.class)
	public void TestCreatePizzaTooManyParameters() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2,1,5,3,2,12");
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestCreatePizzaTooFewParameters() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones");
	}

	@Test (expected = PizzaException.class)
	public void TestCreatePizzaInvalidOrderTime() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("16:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestCreatePizzaInvalidTimeFormat() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19,25:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
	}
	
	@Test (expected = PizzaException.class)
	public void TestCreatePizzaInvalidCode() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZZV,2");
	}
	
	@Test (expected = PizzaException.class)
	public void TestCreatePizzaInvalidQuantity() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,100");
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestCreatePizzaQuantityStringInput() throws PizzaException, LogHandlerException {
		LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,AB");
	}
	
	@Test
	public void TestPopulatePizzaDataset() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset("logs/20170101.txt");
		LogHandler.populatePizzaDataset("logs/20170102.txt");
		LogHandler.populatePizzaDataset("logs/20170103.txt");
	}
	
	@Test (expected = PizzaException.class)
	public void TestPopulatePizzaDatasetInvalidDataSemantics() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset("logs/PizzaDatasetTestLog1.txt");
	}
	
	
	@Test (expected = LogHandlerException.class)
	public void TestPopulatePizzaDatasetInvalidLogStructure() throws PizzaException, LogHandlerException {
		LogHandler.populatePizzaDataset("logs/PizzaDatasetTestLog2.txt");
	}
}
