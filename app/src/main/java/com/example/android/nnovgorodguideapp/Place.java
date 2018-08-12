package com.example.android.nnovgorodguideapp;

import android.content.Context;


public class Place {

    private static final int NO_IMG_PROVIDED = -1;
    private Context mContext;
    private int name;
    private int address;
    private int emailAddress;
    private int telNumber;
    private int mapCoordinates;
    private int imageResourceId;


    Place(Context context, int vname, int vaddress, int vemailAddress, int vtelNumber,
          int vmapCoordinates, int vimageResourceId) {
        mContext = context;
        name = vname;
        address = vaddress;
        emailAddress = vemailAddress;
        telNumber = vtelNumber;
        mapCoordinates = vmapCoordinates;
        imageResourceId = vimageResourceId;
    }

    Place(Context context, int vname, int vaddress, int vtelNumber,
          int vmapCoordinates, int vimageResourceId) {
        mContext = context;
        name = vname;
        address = vaddress;
        telNumber = vtelNumber;
        mapCoordinates = vmapCoordinates;
        imageResourceId = vimageResourceId;
    }

    Place(Context context, int vname, int vaddress,
          int vmapCoordinates, int vimageResourceId) {
        mContext = context;
        name = vname;
        address = vaddress;
        mapCoordinates = vmapCoordinates;
        imageResourceId = vimageResourceId;
    }


    public String getName() {
        return mContext.getString(name);
    }

    public String getAddress() {
        return mContext.getString(address);
    }

    public String getEmailAddress() {
        return mContext.getString(emailAddress);
    }

    public String getTelNumber() {
        return mContext.getString(telNumber);

    }

    public String getMapCoordinates() {
        return mContext.getString(mapCoordinates);
    }

    public int getImageResourceId() {
        return imageResourceId;
    }


    public boolean hasEmailAddress() {
        return emailAddress != 0;
    }

    public boolean hasTelNumber() {
        return telNumber != 0;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMG_PROVIDED;
    }


    @Override
    public String toString() {
        return "Word{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", mapCoordinates='" + mapCoordinates + '\'' +
                ", imageResourceId=" + imageResourceId +
                '}';
    }

}
