package com.humegatech;

import static org.junit.Assert.assertTrue;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

public class Car2GoslingClientTest {
    /**
     * Functional test suite: really calls the Car2Go API!
     *
     * When running via Maven, initialize with -DCAR2GO_CONSUMER_KEY=
     * <your_key> e.g. <code>mvn test -DCAR2GO_CONSUMER_KEY=mysecretkey</code>
     */
    private final Car2GoslingClientImpl client = new Car2GoslingClientImpl(System.getProperty("CAR2GO_CONSUMER_KEY"));
    private static final String LOC = "Hamburg";

    @Test
    public void testGetLocations() throws JSONException {
        final String payload = client.getLocations();
        final JSONArray locations = new JSONArray(payload);

        assertTrue("Didn't get any locations", locations.length() > 0);
        assertTrue("Didn't respond to mapSection", locations.getJSONObject(0).get("mapSection").toString().length() > 0);
    }

    @Test
    public void testGetGasStations() throws JSONException {
        final String payload = client.getGasStations(LOC);
        final JSONArray gasStations = new JSONArray(payload);

        assertTrue("Didn't get any gas stations", gasStations.length() > 0);
        assertTrue("Didn't respond to name", gasStations.getJSONObject(0).get("name").toString().length() > 0);
        assertTrue("Didn't respond to coordinates", gasStations.getJSONObject(0).get("coordinates").toString().length() > 0);
    }

    @Test
    public void testGetOperationAreas() throws JSONException {
        final String payload = client.getOperationAreas(LOC);
        final JSONArray operationAreas = new JSONArray(payload);

        assertTrue("Didn't get any operation areas", operationAreas.length() > 0);
        assertTrue("Didn't respond to zoneType", operationAreas.getJSONObject(0).get("zoneType").toString().length() > 0);
    }

    @Test
    public void testGetParkingSpots() throws JSONException {
        final String payload = client.getParkingSpots(LOC);
        final JSONArray parkingSpots = new JSONArray(payload);

        assertTrue("Didn't get any parking spots", parkingSpots.length() > 0);
        assertTrue("Didn't respond to chargingPole", parkingSpots.getJSONObject(0).get("chargingPole").toString().length() > 0);
    }

    @Test
    public void testGetVehicles() throws JSONException {
        final String payload = client.getVehicles(LOC);
        final JSONArray vehicles = new JSONArray(payload);

        assertTrue("Didn't get any vehicles", vehicles.length() > 0);
        assertTrue("Didn't respond to vin", vehicles.getJSONObject(0).get("vin").toString().length() > 0);
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
