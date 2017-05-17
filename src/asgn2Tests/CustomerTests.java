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
		droneDeliveryCustomer = new DroneDeliveryCustomer("BobbyBobbyBobbyBobby", "0412345678", 2, 3);
	}
	
	/* name of numbers only should pass but doesn't. */
	@Test
	public void TestDroneDeliveryCustomerNameNumbersOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("123456789", "0412345678", 2, 3);
	}
	
	/* name of speical characters only should pass but doesn't. */
	@Test
	public void TestDroneDeliveryCustomerNameSpecialCharsOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("['=)>,~\\!@#$%^&*(", "0412345678", 2, 3);
	}
	
	/* name of 1 character only should pass but doesn't. */
	@Test
	public void TestMinLengthDroneDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("a", "0412345678", 2, 3);
	}

	/* empty name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestEmptyDroneDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("", "0412345678", 2, 3);
	}
	
	/* too long name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDroneDeliveryCustomerNameTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("ThisNameIsWayOver20CharactersForSure", "0412345678", 2, 3);
	}
	
	/* whitespace only name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestWhiteSpaceOnlyDroneDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("     ", "0412345678", 2, 3);
	}
	
	/* name with whitespace should pass but doesn't. */
	@Test
	public void TestWhiteSpaceDroneDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("   Bobby   ", "0412345678", 2, 3);
	}
	
	/* too short mobile number should pass but doesn't. */
	@Test
	public void TestDroneDeliveryCustomerMobileNumberTooShort() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "04123", 2, 3);
	}
	
	/* too long mobile number should pass but doesn't. */
	@Test
	public void TestDroneDeliveryCustomerMobileNumberTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678999999", 2, 3);
	}
	
	/* Mobile number not starting at 0 throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDroneDeliveryCustomerMobileNumberDoesntStartWith0() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "4123456789", 2, 3);
	}
	
	/* Basic customer creation should pass but doesn't. */
	@Test
	public void TestValidDriverDeliveryCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", 2, 3);
	}
	
	/* 20-character length name of letters should pass but doesn't. */
	@Test
	public void TestMaxLengthDriverDeliveryCustomerNameLettersOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("BobbyBobbyBobbyBobby", "0412345678", 2, 3);
	}
	
	/* name of numbers only should pass but doesn't. */
	@Test
	public void TestDriverDeliveryCustomerNameNumbersOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("123456789", "0412345678", 2, 3);
	}
	
	/* name of speical characters only should pass but doesn't. */
	@Test
	public void TestDriverDeliveryCustomerNameSpecialCharsOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("['=)>,~\\!@#$%^&*(", "0412345678", 2, 3);
	}
	
	/* name of 1 character only should pass but doesn't. */
	@Test
	public void TestMinLengthDriverDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("a", "0412345678", 2, 3);
	}

	/* empty name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestEmptyDriverDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("", "0412345678", 2, 3);
	}
	
	/* too long name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDriverDeliveryCustomerNameTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("ThisNameIsWayOver20CharactersForSure", "0412345678", 2, 3);
	}
	
	/* whitespace only name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestWhiteSpaceOnlyDriverDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("     ", "0412345678", 2, 3);
	}
	
	/* name with whitespace should pass but doesn't. */
	@Test
	public void TestWhiteSpaceDriverDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("   Bobby   ", "0412345678", 2, 3);
	}
	
	/* too short mobile number should pass but doesn't. */
	@Test
	public void TestDriverDeliveryCustomerMobileNumberTooShort() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "04123", 2, 3);
	}
	
	/* too long mobile number should pass but doesn't. */
	@Test
	public void TestDriverDeliveryCustomerMobileNumberTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678999999", 2, 3);
	}
	
	/* Mobile number not starting at 0 throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestDriverDeliveryCustomerMobileNumberDoesntStartWith0() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "4123456789", 2, 3);
	}
	
	/* Basic customer creation should pass but doesn't. */
	@Test
	public void TestValidPickUpDeliveryCustomer() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678", 0, 0);
	}
	
	/* 20-character length name of letters should pass but doesn't. */
	@Test
	public void TestMaxLengthPickUpDeliveryCustomerNameLettersOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("BobbyBobbyBobbyBobby", "0412345678", 0, 0);
	}
	
	/* name of numbers only should pass but doesn't. */
	@Test
	public void TestPickUpDeliveryCustomerNameNumbersOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("123456789", "0412345678", 0, 0);
	}
	
	/* name of speical characters only should pass but doesn't. */
	@Test
	public void TestPickUpDeliveryCustomerNameSpecialCharsOnly() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("['=)>,~\\!@#$%^&*(", "0412345678", 0, 0);
	}
	
	/* name of 1 character only should pass but doesn't. */
	@Test
	public void TestMinLengthPickUpDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("a", "0412345678", 0, 0);
	}

	/* empty name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestEmptyPickUpDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("", "0412345678", 0, 0);
	}
	
	/* too long name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestPickUpDeliveryCustomerNameTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("ThisNameIsWayOver20CharactersForSure", "0412345678", 0, 0);
	}
	
	/* whitespace only name throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestWhiteSpaceOnlyPickUpDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("     ", "0412345678", 0, 0);
	}
	
	/* name with whitespace should pass but doesn't. */
	@Test
	public void TestWhiteSpacePickUpDeliveryCustomerName() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("   Bobby   ", "0412345678", 0, 0);
	}
	
	/* too short mobile number should pass but doesn't. */
	@Test
	public void TestPickUpDeliveryCustomerMobileNumberTooShort() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "04123", 0, 0);
	}
	
	/* too long mobile number should pass but doesn't. */
	@Test
	public void TestPickUpDeliveryCustomerMobileNumberTooLong() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "0412345678999999", 0, 0);
	}
	
	/* Mobile number not starting at 0 throwing an exception should pass but doesn't. */
	@Test (expected = CustomerException.class)
	public void TestPickUpDeliveryCustomerMobileNumberDoesntStartWith0() throws CustomerException {
		droneDeliveryCustomer = new DroneDeliveryCustomer("Bobby", "4123456789", 0, 0);
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
