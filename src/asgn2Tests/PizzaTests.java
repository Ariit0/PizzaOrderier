package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaTopping;
/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Ari Luangamath (n9446826)
 *
 */
public class PizzaTests {
	Pizza margheritaPizza;
	Pizza vegetarianPizza;
	Pizza meatLoversPizza;
	
	@Before
	public void Init() throws PizzaException {
		margheritaPizza = new MargheritaPizza(1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
		vegetarianPizza = new VegetarianPizza(2, LocalTime.parse("19:45:00"), LocalTime.parse("20:15:00"));
		meatLoversPizza = new MeatLoversPizza(3, LocalTime.parse("20:30:00"), LocalTime.parse("21:00:00"));
	}
	
	/*-------------------------- TESTS FOR MARGHERITA PIZZA CLASS ------------------------------------------*/
	@Test
	public void TestOrderMargheritaCostPerPizza() throws PizzaException {
		assertTrue(margheritaPizza.getCostPerPizza() == 1.50);
	}
	
	@Test
	public void TestMargheritaTopping() throws PizzaException {
		assertTrue(margheritaPizza.containsTopping(PizzaTopping.TOMATO));
		assertTrue(margheritaPizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	@Test
	public void TestMargheritaIncorrectToppings() throws PizzaException {
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.BACON));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.SALAMI));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.PEPPERONI));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.CAPSICUM));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.MUSHROOM));
		assertFalse(margheritaPizza.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	@Test
	public void TestMargheritaPizzaOrderCost() {
		assertTrue(margheritaPizza.getOrderCost() == 1.50);
	}
	
	@Test
	public void TestMargheritaPizzaOrderPrice() {
		assertTrue(margheritaPizza.getOrderPrice() == 8.0);
	}
	
	@Test
	public void TestMargheritaPizzaOrderProfit() {
		assertTrue(margheritaPizza.getOrderProfit() == 6.50);
	}
	
	@Test
	public void TestMargheritaPizzaType() {
		assertTrue(margheritaPizza.getPizzaType().equals("Margherita"));
	}
	
	@Test
	public void TestMargheritaPricePerPizzaOrder() {
		assertTrue(margheritaPizza.getPricePerPizza() == 8.0);
	}
	
	@Test
	public void TestMargheritaPizzaOrderQuantity() throws PizzaException {
		assertTrue(margheritaPizza.getQuantity() == 1);
	}
	
	@Test (expected = PizzaException.class)
	public void TestMargheritaPizzaOverOrderQuantity() throws PizzaException {
		margheritaPizza = new MargheritaPizza(12, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test
	public void TestMargheritaPizzaOrderQuantityLimitInclusive() throws PizzaException {
		margheritaPizza = new MargheritaPizza(10, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestMargheritaPizzaOrderQuantityNegative() throws PizzaException {
		margheritaPizza = new MargheritaPizza(-1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test
	public void TestMargheritaPizzaOrderQuantityMinimumInclusive() throws PizzaException {
		margheritaPizza = new MargheritaPizza(1, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestMargheritaPizzaOrderQuantityZero() throws PizzaException {
		margheritaPizza = new MargheritaPizza(0, LocalTime.parse("19:00:00"), LocalTime.parse("19:30:00"));
	}
		
	@Test (expected = PizzaException.class)
	public void TestMargheritaPizzaThrownOut() throws PizzaException {
		margheritaPizza = new MargheritaPizza(1, LocalTime.parse("19:00:00"), LocalTime.parse("22:00:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestUnRealisticOrderDeliveryTime() throws PizzaException {
		margheritaPizza = new MargheritaPizza(1, LocalTime.parse("20:00:00"), LocalTime.parse("19:30:00"));
	}
	
	@Test (expected = PizzaException.class)
	public void TestUnderCookedPizza() throws PizzaException {
		margheritaPizza = new MargheritaPizza(1, LocalTime.parse("19:07:00"), LocalTime.parse("19:10:00"));
	}
	// unsure due to specification
	@Test
    public void TestUnderCookedPizzaBoundaryTime() throws PizzaException {
        margheritaPizza = new MargheritaPizza(1, LocalTime.parse("19:00:00"), LocalTime.parse("19:10:00"));
    }
	
	/*-------------------------- TESTS FOR VEGETARIAN PIZZA CLASS ------------------------------------------*/
	@Test
	public void TestOrderVegetarianCostPerPizza() throws PizzaException {
		assertTrue(vegetarianPizza.getCostPerPizza() == 5.50);
	}
	
	@Test
	public void TestVegetarianTopping() throws PizzaException {
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.TOMATO));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.CHEESE));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.EGGPLANT));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.MUSHROOM));
		assertTrue(vegetarianPizza.containsTopping(PizzaTopping.CAPSICUM));
	}
	
	@Test
	public void TestVegetarianIncorrectToppings() throws PizzaException {
		assertFalse(vegetarianPizza.containsTopping(PizzaTopping.BACON));
		assertFalse(vegetarianPizza.containsTopping(PizzaTopping.SALAMI));
		assertFalse(vegetarianPizza.containsTopping(PizzaTopping.PEPPERONI));
	}
	
	@Test
	public void TestVegetarianPizzaOrderCost() {
		assertTrue(vegetarianPizza.getOrderCost() == 11.00);
	}
	
	@Test
	public void TestVegetarianPizzaOrderPrice() {
		assertTrue(vegetarianPizza.getOrderPrice() == 20.0);
	}
	
	@Test
	public void TestVegetarianPizzaOrderProfit() {
		assertTrue(vegetarianPizza.getOrderProfit() == 9.00);
	}
	
	@Test
	public void TestVegetarianPizzaType() {
		assertTrue(vegetarianPizza.getPizzaType().equals("Vegetarian"));
	}
	
	@Test
	public void TestVegetarianPricePerPizzaOrder() {
		assertTrue(vegetarianPizza.getPricePerPizza() == 10.0);
	}
	
	/*-------------------------- TESTS FOR MEATLOVERS PIZZA CLASS ------------------------------------------*/
	@Test
	public void TestOrderMeatLoversCostPerPizza() throws PizzaException {
		assertTrue(meatLoversPizza.getCostPerPizza() == 5.0);
	}
	
	@Test
	public void TestMeatLoversTopping() throws PizzaException {
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.TOMATO));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.CHEESE));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.BACON));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.PEPPERONI));
		assertTrue(meatLoversPizza.containsTopping(PizzaTopping.SALAMI));
	}
	
	@Test
	public void TestMeatLoversIncorrectToppings() throws PizzaException {
		assertFalse(meatLoversPizza.containsTopping(PizzaTopping.CAPSICUM));
		assertFalse(meatLoversPizza.containsTopping(PizzaTopping.MUSHROOM));
		assertFalse(meatLoversPizza.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	@Test
	public void TestMeatLoversPizzaOrderCost() {
		assertTrue(meatLoversPizza.getOrderCost() == 15.0);
	}
	
	@Test
	public void TestMeatLoversPizzaOrderPrice() {
		assertTrue(meatLoversPizza.getOrderPrice() == 36.0);
	}
	
	@Test
	public void TestMeatLoversPizzaOrderProfit() {
		assertTrue(meatLoversPizza.getOrderProfit() == 21.0);
	}
	
	@Test
	public void TestMeatLoversPizzaType() {
		assertTrue(meatLoversPizza.getPizzaType().equals("Meat Lovers"));
	}
	
	@Test
	public void TestMeatLoversPricePerPizzaOrder() {
		assertTrue(meatLoversPizza.getPricePerPizza() == 12.0);
	}
}
