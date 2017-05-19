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
	
	/* Basic customer creation should pass but doesn't. */
	@Test
	public void TestValidDroneDeliveryCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", 2, 3);
	}
	
	/* 20-character length name of letters should pass but doesn't. */
	@Test
	public void TestMaxLengthDroneDeliveryCustomerNameLettersOnly() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("BobbyBobbyBobbyBobby", "0412345678", 2, 3);
	}
	
	/* name of numbers only should pass but doesn't. */
	@Test
	public void TestDroneDeliveryCustomerNameNumbersOnly() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("123456789", "0412345678", 2, 3);
	}
	
	/* name of special characters only should pass but doesn't. */
	@Test
	public void TestDroneDeliveryCustomerNameSpecialCharsOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("['=)>,~\\!@#$%^&*(", "0412345678", 2, 3);
	}
	
	/* name of 1 character only should pass but doesn't. */
	@Test
	public void TestMinLengthDroneDeliveryCustomerName() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("a", "0412345678", 2, 3);
	}

	/* empty name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestEmptyDroneDeliveryCustomerName() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("", "0412345678", 2, 3);
	}
	
	/* too long name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDroneDeliveryCustomerNameTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("ThisNameIsWayOver20CharactersForSure", "0412345678", 2, 3);
	}
	
	/* whitespace only name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestWhiteSpaceOnlyDroneDeliveryCustomerName() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("     ", "0412345678", 2, 3);
	}
	
	/* name with whitespace should pass but doesn't. */
	@Test
	public void TestWhiteSpaceDroneDeliveryCustomerName() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("   Bobby   ", "0412345678", 2, 3);
	}
	
	/* too short mobile number should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDroneDeliveryCustomerMobileNumberTooShort() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "04123", 2, 3);
	}
	
	/* too long mobile number should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDroneDeliveryCustomerMobileNumberTooLong() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678999999", 2, 3);
	}
	
	/* Mobile number not starting at 0 throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDroneDeliveryCustomerMobileNumberDoesntStartWith0() throws CustomerException {
		pickUpCustomer = new PickUpCustomer("Bobby", "4123456789", 2, 3);
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
	
	@Test
	public void TestFarAwayDriverDeliveryCustomer() throws CustomerException {
		driverDeliveryCustomer = new DriverDeliveryCustomer("Bobby", "0412345678", -81, 97);
	}
	
	@Test
	public void TestFarAwayDroneDeliveryCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", -81, 97);
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
