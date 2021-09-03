package sample;

// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Interface for location objects

// An interface that defines operations of Location Objects
public interface LocationInformation {


    /* Gets the city of the user or store location
     @return The city as a String */
    public String getCity();



    /* Gets the current address of the user or store location
      @return The address of the location or the user as a String */
    public String getAddress();



    /* Gets the Zip Code of the user or store location
     @return The Zip Code as a String */
    public String getZipCode();



    /*
     @return The object's String representation */
    public String toString();

    //end LocationInterface
}
