package com.humegatech;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

@SuppressWarnings("rawtypes")
public class Car2GoslingClientTest {
    /**
     * This really calls the Car2Go API so it is a functional test When running
     * via Maven, initialze with -DCAR2GO_CONSUMER_KEY=<your_key> when running
     * e.g. <code>mvn test -DCAR2GO_CONSUMER_KEY=mysecretkey</code>
     */
    private final Car2GoslingClientImpl client = new Car2GoslingClientImpl(System.getProperty("CAR2GO_CONSUMER_KEY"));
    private static final String LOC = "Hamburg";

    @Test
    public void testGetLocations() {
        final ArrayList locations = client.getLocations();

        assertTrue("Didn't get any locations", locations.size() > 0);
        final LinkedHashMap location = (LinkedHashMap) locations.get(0);
        assertTrue("Didn't respond to countryCode", location.get("countryCode").toString().length() > 0);
    }

    @Test
    public void testGetGasStations() {
        final ArrayList gasStations = client.getGasStations(LOC);

        assertTrue("Didn't get any gas stations", gasStations.size() > 0);
        final LinkedHashMap gasStation = (LinkedHashMap) gasStations.get(0);
        assertTrue("Didn't respond to coordinates", gasStation.get("coordinates").toString().length() > 0);
    }

    @Test
    public void testGetOperationAreas() {
        final ArrayList operationAreas = client.getOperationAreas(LOC);

        assertTrue("Didn't get any operation areas", operationAreas.size() > 0);
        final LinkedHashMap operationArea = (LinkedHashMap) operationAreas.get(0);
        assertTrue("Didn't respond to coordinates", operationArea.get("coordinates").toString().length() > 0);
    }

    @Test
    public void testGetParkingSpots() {
        final ArrayList parkingSpots = client.getParkingSpots(LOC);

        assertTrue("Didn't get any parking spots", parkingSpots.size() > 0);
        final LinkedHashMap parkingSpot = (LinkedHashMap) parkingSpots.get(0);
        assertTrue("Didn't respond to coordinates", parkingSpot.get("coordinates").toString().length() > 0);
    }

    @Test
    public void testGetVehicles() {
        final ArrayList vehicles = client.getVehicles(LOC);

        assertTrue("Didn't get any vehicles", vehicles.size() > 0);
        final LinkedHashMap vehicle = (LinkedHashMap) vehicles.get(0);
        assertTrue("Didn't respond to address", vehicle.get("address").toString().length() > 0);
    }

    // private void runTest(final String operation, final String valueToCheck) {
    // final ArrayList things = client.getVehicles(LOC);
    //
    // assertTrue(String.format("Didn't get any %ss", operation), things.size()
    // > 0);
    // final LinkedHashMap vehicle = (LinkedHashMap) things.get(0);
    // assertTrue(String.format("Didn't respond to %s", valueToCheck),
    // vehicle.get(valueToCheck).toString().length() > 0);
    // }
}
