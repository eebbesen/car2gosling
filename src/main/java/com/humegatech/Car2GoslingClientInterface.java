package com.humegatech;

public interface Car2GoslingClientInterface {
    public String getLocations();

    /**
     * Not all locations have gas stations
     *
     * @param location
     * @return Gas Station information for a given location
     */
    public String getGasStations(final String location);

    public String getOperationAreas(final String location);

    public String getParkingSpots(final String location);

    public String getVehicles(final String location);
}
