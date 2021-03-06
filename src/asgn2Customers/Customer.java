package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** An abstract class to represent a customer at the Pizza Palace restaurant.
 *  The Customer class is used as a base class of PickUpCustomer, 
 *  DriverDeliveryCustomer and DroneDeliverCustomer. Each of these subclasses overwrites
 *  the abstract method getDeliveryDistance. A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.  
 * 
 * @author Ari Luangamath (n9446826)
*/
public abstract class Customer {

	private String m_Name;
	private String m_MobileNumber;
	private int m_LocationX;
	private int m_LocationY;
	private String m_Type;
	
	/**
	 *  This class represents a customer of the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.2. 
	 *  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment Specification
	 *  are violated. 
	 *  
  	 * <P> PRE: True
  	 * <P> POST: All field values are set
  	 * 
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY - The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param type - A human understandable description of this Customer type
	 * @throws CustomerException if supplied parameters are invalid 
	 * 
	 */
	public Customer(String name, String mobileNumber, int locationX, int locationY, String type) throws CustomerException {

		if (name == null
			|| name.trim().isEmpty() // checks for whitespaces
			|| name.length() > 21
			|| name.isEmpty()
			) { 

			throw new CustomerException();
		}

		if (mobileNumber == null
			|| mobileNumber.trim().isEmpty() // assumed that mobile number cannot be whitespace only (not specified in api)
			|| mobileNumber.charAt(0) != '0' // mobilenumbers must start at 0
			|| !mobileNumber.matches("[0-9]+") // regex ensuring mobile number values should be ints only
			|| mobileNumber.length() < 10
			|| mobileNumber.length() > 10) {
			
			throw new CustomerException();
		}
		
		if (locationX > 10 
			|| locationY > 10
			|| locationX < -10
			|| locationY < -10) {
			
			throw new CustomerException();
		}
		
		if (type.equals("Pick Up") && locationX != 0 && locationY != 0  // to pick up pizza, location is always 0,0. 
			|| type.equals("Driver Delivery") && locationX == 0 && locationY == 0 // will not deliver if the customer is at the restaurant 
			|| type.equals("Drone Delivery") && locationX == 0 && locationY == 0) { // will not deliver if the customer is at the restaurant 
			
			throw new CustomerException();
		}
		
		this.m_Name = name;
		this.m_MobileNumber = mobileNumber;
		this.m_LocationX = locationX;
		this.m_LocationY = locationY;
		this.m_Type = type;
	}
	
	/**
	 * Returns the Customer's name.
	 * @return The Customer's name.
	 */
	public final String getName(){
		return m_Name;
	}
	
	/**
	 * Returns the Customer's mobile number.
	 * @return The Customer's mobile number.
	 */
	public final String getMobileNumber(){
		return m_MobileNumber;
	}

	/**
	 * Returns a human understandable description of the Customer's type. 
	 * The valid alternatives are listed in Section 5.2 of the Assignment Specification. 
	 * @return A human understandable description of the Customer's type.
	 */
	public final String getCustomerType(){
		return m_Type;
	}
	
	/**
	 * Returns the Customer's X location which is the number of blocks East or West 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's X location
	 */
	public final int getLocationX(){
		return m_LocationX;
	}

	/**
	 * Returns the Customer's Y location which is the number of blocks North or South 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's Y location
	 */
	public final int getLocationY(){
		return m_LocationY;
	}

	/**
	 * An abstract method that returns the distance between the Customer and 
	 * the restaurant depending on the mode of delivery. 
	 * @return The distance between the restaurant and the Customer depending on the mode of delivery.
	 */
	public abstract double getDeliveryDistance();

	/**
	 * Compares *this* Customer object with an instance of an *other* Customer object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 *  You do not need to test this method.
	 * 
	 * @return true if *this* Customer object and the *other* Customer object have the same values returned for 	
	 * getName(),getMobileNumber(),getLocationX(),getLocationY(),getCustomerType().
	 */
	@Override
	public boolean equals(Object other){
		Customer otherCustomer = (Customer) other;

		return ( (this.getName().equals(otherCustomer.getName()))  &&
			(this.getMobileNumber().equals(otherCustomer.getMobileNumber())) && 
			(this.getLocationX() == otherCustomer.getLocationX()) && 
			(this.getLocationY() == otherCustomer.getLocationY()) && 
			(this.getCustomerType().equals(otherCustomer.getCustomerType())) );			
	}
}
