package com.humegatech;

public interface Car2GoslingClientInterface {
    /**
     * A location is a city/geographical area in which Car2Go offers rental vehicles
     *
     * @return Location information
     */
    public String getLocations();

    /**
     * NOTE: Not all locations have Car2Go-approved gas stations
     *
     * @param location
     * @return Gas Station information for a given location
     */
    public String getGasStations(final String location);

    /**
     * Included/excluded geographies within a location
     *
     * @param location
     * @return Operation area (zone) information for a given location
     */
    public String getOperationAreas(final String location);

    /**
     * Reserved parking spots (e.g. at airports, special events, etc.)
     * 
     * @param location
     * @return Parking spot information for a given location
     */
    public String getParkingSpots(final String location);

    /**
     * Vehicles available for rental
     * 
     * @param location
     * @return Vehicle information for a given location
     */
    public String getVehicles(final String location);
}
