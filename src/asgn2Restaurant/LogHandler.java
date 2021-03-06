package asgn2Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author George Delosa (n9751696) and Ari Luangamath (n9446826)
 *
 */
public class LogHandler {
	
	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException {
		try {
			ArrayList<Customer> customer = new ArrayList<Customer>();
			BufferedReader file = new BufferedReader(new FileReader(filename));
	        String line = file.readLine();
			
	        while (line != null) {
		        customer.add(createCustomer(line));
		        line = file.readLine();
	        }

	        file.close(); // prevent resource leak
			return customer;
		} catch (CustomerException exception) {
			throw exception;
		} catch (LogHandlerException exception){
			throw exception;
		} catch (Exception exception){
			exception.getMessage();
			exception.printStackTrace();
			throw new LogHandlerException();
		}
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		
        try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			
			while(line != null){
				pizzas.add(createPizza(line));
				line = br.readLine();
			}
			
	        br.close(); // prevent resource leak
		} catch (PizzaException e) {
			throw e;
		} catch (LogHandlerException e){
			throw e;
		} catch (Exception e){
			throw new LogHandlerException();
		}
        
        return pizzas;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException {
		try {
			// create customer
			String[] data = line.split(","); 
			// validation
			if (data.length != 9) {
				throw new LogHandlerException();
			}
	        
			String customerName = data[2];
			String customerMobile = data[3];
			String customerCode = data[4];
			int customerXLocation = Integer.parseInt(data[5]);
			int customerYLocation = Integer.parseInt(data[6]);
	        
			return  CustomerFactory.getCustomer(customerCode, customerName, customerMobile, customerXLocation, customerYLocation);
		} catch (CustomerException exception) {
			throw exception;
		} catch (Exception exception){
			exception.getMessage();
			exception.printStackTrace();
			throw new LogHandlerException();
		}	
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		String[] data = line.split(",");
		if(data.length != 9){
			throw new LogHandlerException();
		}
		
		LocalTime orderTime;
		LocalTime deliveryTime;
		String pizzaCode;
		int quantity;
		try {
			orderTime = LocalTime.parse(data[0]);
			deliveryTime = LocalTime.parse(data[1]);
			pizzaCode = data[7];
			quantity = Integer.parseInt(data[8]);	
			
			return PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		} catch (PizzaException e) {
			throw e;
		} catch (Exception e){
			throw new LogHandlerException();
		}	
	}

}
