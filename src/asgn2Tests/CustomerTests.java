package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;


/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	
	Customer droneDeliveryCustomer;
	Customer driverDeliveryCustomer;
	Customer pickUpCustomer;

	@Before
	public void Init() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", 2, 3);
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678", 2, 3);
		pickUpCustomer = new PickUpCustomer("Bobby", "0412345678", 0, 0);
	}

	@Test
	public void TestValidCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", 2, 3);
	}
	
	@Test
	public void TestMaxLengthCustomerNameLettersOnly() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("BobbyBobbyBobbyBobby", "0412345678", 2, 3);
	}
	
	@Test
	public void TestCustomerNameNumbersOnly() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("123456789", "0412345678", 0, 0);
	}

	@Test
	public void TestCustomerNameSpecialCharsOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("['=)>,~\\!@#$%^&*(", "0412345678", 2, 3);
	}

	@Test
	public void TestMinLengthCustomerName() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("a", "0412345678", 2, 3);
	}

	@Test (expected = CustomerException.class)
	public void TestEmptyCustomerName() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("", "0412345678", 0, 0);
	}
	
	@Test (expected = CustomerException.class)
	public void TestCustomerNameTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("ThisNameIsWayOver20CharactersForSure", "0412345678", 2, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void TestWhiteSpaceOnlyCustomerName() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("     ", "0412345678", 2, 3);
	}
	
	@Test 
	public void TestWhiteSpaceCustomerName() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("   Bobby   ", "0412345678", 0, 0);
	}
	
	@Test (expected = CustomerException.class)
	public void TestCustomerMobileNumberTooShort() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "04123", 2, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void TestCustomerMobileNumberTooLong() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678999999", 2, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void TestCustomerMobileNumberDoesntStartWith0() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("Bobby", "4123456789", 0, 0);
	}
	
	@Test
	public void TestValidLocationForPickUpCustomer() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("Bobby", "0412345678", 0, 0);
	}
	
	@Test
	public void TestValidLocationForDroneDeliveryCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", 2, 5);
	}
	
	@Test
	public void TestValidLocationForDriverDeliveryCustomer() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678", 2, 5);
	}
	
	@Test (expected = CustomerException.class)
	public void TestInvalidLocationForPickUpCustomer() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("Bobby", "0412345678", -2, 2);
	}
	
	@Test (expected = CustomerException.class)
	public void Test0_0LocationForDroneDeliveryCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", 0, 0);
	}
	
	@Test (expected = CustomerException.class)
	public void Test0_0LocationForDriverDeliveryCustomer() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678", 0, 0);
	}
	
	@Test (expected = CustomerException.class)
	public void TestFarAwayCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", -81, 97);
	}
	
	@Test
	public void TestBorderlineFarAwayDriverDeliveryCustomer() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678", 10, 10);
	}
	
	@Test 
	public void TestBorderlineFarAwayDroneDeliveryCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", -10, -10);
	}
	
	@Test
	public void TestGetCustomerName() {
		assertEquals("Bobby", pickUpCustomer.getName());
	}
	
	@Test
	public void TestGetCustomerMobileNumber() {
		assertEquals("0412345678", pickUpCustomer.getMobileNumber());
	}
	
	@Test
	public void TestGetCustomerType() {
		assertEquals("Pick Up", pickUpCustomer.getCustomerType());
		assertEquals("Driver Delivery", driverDeliveryCustomer.getCustomerType());
		assertEquals("Drone Delivery", droneDeliveryCustomer.getCustomerType());
	}
	
	@Test
	public void TestGetCustomerXLocation() {
		assertEquals(2, driverDeliveryCustomer.getLocationX());
	}
	
	@Test
	public void TestGetCustomerYLocation() {
		assertEquals(3, driverDeliveryCustomer.getLocationY());
	}
	
	@Test
	public void TestGetDriverDeliveryDistancePositiveLocations() throws CustomerException {
		assertTrue(Math.abs(0 - driverDeliveryCustomer.getLocationX()) + Math.abs(0 - driverDeliveryCustomer.getLocationY()) == driverDeliveryCustomer.getDeliveryDistance());	
	}
	
	@Test
	public void TestGetDriverDeliveryDistanceNegativeLocations() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678", -2, -3);
		assertTrue(Math.abs(0 - driverDeliveryCustomer.getLocationX()) + Math.abs(0 - driverDeliveryCustomer.getLocationY()) == driverDeliveryCustomer.getDeliveryDistance());	
	}
	
	@Test
	public void TestGetDroneDeliveryDistancePositiveLocations() throws CustomerException {
		assertTrue(Math.sqrt(Math.pow(0 - droneDeliveryCustomer.getLocationX(), 2) + Math.pow(0 - droneDeliveryCustomer.getLocationY(), 2)) == droneDeliveryCustomer.getDeliveryDistance());	
	}
	
	@Test
	public void TestGetDroneDeliveryDistanceNegativeLocations() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", -2, -3);
		assertTrue(Math.sqrt(Math.pow(0 - droneDeliveryCustomer.getLocationX(), 2) + Math.pow(0 - droneDeliveryCustomer.getLocationY(), 2)) == droneDeliveryCustomer.getDeliveryDistance());	
	}
}
