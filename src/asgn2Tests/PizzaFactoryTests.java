package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	Pizza margheritaPizza;
	Pizza meatLoversPizza;
	Pizza vegetarianPizza;
	
	@Test
	public void TestPizzaFactory() throws PizzaException {
		margheritaPizza = PizzaFactory.getPizza("PZM", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		meatLoversPizza = PizzaFactory.getPizza("PZL", 1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		vegetarianPizza = PizzaFactory.getPizza("PZV", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestIncorrectPizzaCodes() throws PizzaException {
		margheritaPizza = PizzaFactory.getPizza("ASD", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		meatLoversPizza = PizzaFactory.getPizza("RTY", 1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		vegetarianPizza = PizzaFactory.getPizza("YUI", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestShortPizzaCodes() throws PizzaException {
		margheritaPizza = PizzaFactory.getPizza("P", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		meatLoversPizza = PizzaFactory.getPizza("Z", 1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		vegetarianPizza = PizzaFactory.getPizza("Z", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestLongPizzaCodes() throws PizzaException {
		margheritaPizza = PizzaFactory.getPizza("PZMM", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		meatLoversPizza = PizzaFactory.getPizza("PZLL", 1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		vegetarianPizza = PizzaFactory.getPizza("PZVV", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestEmptyPizzaCodes() throws PizzaException {
		margheritaPizza = PizzaFactory.getPizza("", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		meatLoversPizza = PizzaFactory.getPizza("", 1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		vegetarianPizza = PizzaFactory.getPizza("", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
}
