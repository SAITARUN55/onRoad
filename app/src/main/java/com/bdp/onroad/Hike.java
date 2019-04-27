package com.bdp.onroad;

public class Hike
{
   private String mName,mstartingTime,mstartingPlace,mDestination,mNoOfSeats,mContactNumber;

    public Hike(String name, String startingTime, String startingPlace, String destination, String noOfSeats, String contactNumber)
    {
        this.mName = name;
        this.mstartingTime = startingTime;
        this.mstartingPlace = startingPlace;
        this.mDestination = destination;
        this.mNoOfSeats = noOfSeats;
        this.mContactNumber=contactNumber;
    }
    // for firebase an empty constructor

    public Hike() { }

    // getters

    public String getName()
    {
        return mName;
    }

    public String getMstartingTime()
    {
        return mstartingTime;
    }

    public String getMstartingPlace()
    {
        return mstartingPlace;
    }

    public String getDestination()
    {
        return mDestination;
    }

    public String getNoOfSeats()
    {
        return mNoOfSeats;
    }

    public String getContactNumber()
    {
        return mContactNumber;
    }
}
