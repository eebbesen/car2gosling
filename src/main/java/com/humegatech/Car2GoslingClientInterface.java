package com.humegatech;

import java.util.ArrayList;

public interface Car2GoslingClientInterface {
    public ArrayList getLocations();

    /**
     * Not all locations have gas stations
     *
     * @param location
     * @return Gas Station information for a given location
     */
    public ArrayList getGasStations(final String location);

    public ArrayList getOperationAreas(final String location);

    public ArrayList getParkingSpots(final String location);

    public ArrayList getVehicles(final String location);
}
