package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: provide class to create location objects

public class Location implements LocationInformation {

	private String city; //Stores location's city
	private String address; //Stores location's address
	private String zipcode; //Stores location's zipcode
	
	/**Constructor for new Location object 
	@param city, a string defining the location's city
	@param address, a string defining the location's address 
	@param zipcode, a string defining the location's zipcode*/
	Location(String city, String address, String zipcode){
		this.city = city;
		this.address = address;
		this.zipcode = zipcode;
	}
	
	/*Gets the location's city
	@return String with the location's city*/
	@Override
	public String getCity() {
		return city;
	}

	/*Gets the location's address
	@return String with the location's address*/
	@Override
	public String getAddress() {
		return address;
	}

	/*Gets the location's zipcode
	@return String with the location's zipcode*/
	@Override
	public String getZipCode() {
		return zipcode;
	}
	
	/*Displays location information as a string
	@return String of the location's city, address, and zipcode*/
	@Override
	public String toString() {
		return ("\nCity\n" + city +"\nAddress\n" + address + "\nZipcode\n" + zipcode);
	}
}
