package com.bdp.onroad;

public class Hike
{
   private String mName, mstartingTime , mstartingPlace , mDestination ,mNoOfSeats,mContactNumber;

    public Hike(String mName, String mstartingTime, String mstartingPlace, String mDestination, String mNoOfSeats, String mContactNumber)
    {
        this.mName = mName;
        this.mstartingTime = mstartingTime;
        this.mstartingPlace = mstartingPlace;
        this.mDestination =mDestination;
        this.mNoOfSeats = mNoOfSeats;
        this.mContactNumber=mContactNumber;
    }
    // for firebase an empty constructor

    public Hike() { }

    // getters

    public String getmName()
    {
        return mName;
    }

    public String getmStartingTime()
    {
        return mstartingTime;
    }

    public String getmStartingPlace()
    {
        return mstartingPlace;
    }

    public String getmDestination()
    {
        return mDestination;
    }

    public String getmNoOfSeats()
    {
        return mNoOfSeats;
    }

    public String getmContactNumber()
    {
        return mContactNumber;
    }
}
