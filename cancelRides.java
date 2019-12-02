package com.bdp.onroad;

public class cancelRides {
    private String mName,mStartingTime,mStartingPlace,mDestination,mNoOfSeats,mContactNumber,mDriverEmail;

    public cancelRide(String name, String startingTime, String startingPlace, String destination, String noOfSeats, String contactNumber,String driveremail)
    {
        this.mName = name;
        this.mStartingTime = startingTime;
        this.mStartingPlace = startingPlace;
        this.mDestination = destination;
        this.mNoOfSeats = noOfSeats;
        this.mContactNumber=contactNumber;
        this.mDriverEmail=driveremail;

    }
}
