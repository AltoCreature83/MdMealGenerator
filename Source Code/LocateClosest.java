package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Locate addresses within city

import java.util.ArrayList;

public class LocateClosest {
	
	/*This method takes the Arraylist of McDonald locations along 
	with the user's city and compares both of the parameters. 
	@returns an arraylist with the list of matches*/
	static ArrayList<Location> getClosest(ArrayList<Location> locations, String userCity) {
		
		ArrayList<Location> match = new ArrayList();
		
		for (int i = 0; i < locations.size(); i++) {
			if(locations.get(i).getCity().equals(userCity)) {
				match.add(locations.get(i));
			}
		}
		return match;
	}
}
