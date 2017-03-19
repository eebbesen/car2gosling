package com.humegatech;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

public class Car2GoslingClientTest {
    /**
     * This really calls the Car2Go API so it is a functional test
     * When running via Maven, initialze with -DCAR2GO_CONSUMER_KEY=<your_key> when running
     *   e.g. <code>mvn test -DCAR2GO_CONSUMER_KEY=mysecretkey</code>
     */
    @Test
    public void testGetLocations() {
        final Car2GoslingClientImpl client = new Car2GoslingClientImpl(System.getProperty("CAR2GO_CONSUMER_KEY"));
        final ArrayList locations = client.getLocations();

        assertTrue("Didn't get any locations", locations.size() > 0);
        final LinkedHashMap location = (LinkedHashMap) locations.get(0);
        assertTrue("Didn't respond to countryCode", location.get("countryCode").toString().length() > 0);
    }
}
