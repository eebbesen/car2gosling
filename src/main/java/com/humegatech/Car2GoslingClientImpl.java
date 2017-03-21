package com.humegatech;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

public class Car2GoslingClientImpl implements Car2GoslingClientInterface {
    private static final String DEFAULT_CAR2GO_API_URL = "https://www.car2go.com/api/v2.1/";
    private final String car2GoConsumerKey;
    private final String car2GoApiUrl;

    public Car2GoslingClientImpl(final String car2GoConsumerKey) {
        this.car2GoConsumerKey = car2GoConsumerKey;
        this.car2GoApiUrl = DEFAULT_CAR2GO_API_URL;
    }

    @Override
    public ArrayList getLocations() {
        final WebTarget target = buildWebTarget("locations", null);
        final Map operationAreas = executeGet(target);
        return (ArrayList) operationAreas.get("location");
    }

    @Override
    public ArrayList getGasStations(final String location) {
        final WebTarget target = buildWebTarget("gasstations", location);
        final Map operationAreas = executeGet(target);
        return (ArrayList) operationAreas.get("placemarks");
    }

    @Override
    public ArrayList getOperationAreas(final String location) {
        final WebTarget target = buildWebTarget("operationareas", location);
        final Map operationAreas = executeGet(target);
        return (ArrayList) operationAreas.get("placemarks");
    }

    @Override
    public ArrayList getParkingSpots(final String location) {
        final WebTarget target = buildWebTarget("parkingspots", location);
        final Map parkingSpots = executeGet(target);
        return (ArrayList) parkingSpots.get("placemarks");
    }

    @Override
    public ArrayList getVehicles(final String location) {
        final WebTarget target = buildWebTarget("vehicles", location);
        final Map vehicles = executeGet(target);
        return (ArrayList) vehicles.get("placemarks");
    }

    private WebTarget buildWebTarget(final String endpoint, final String location) {
        final WebTarget target = getTarget().path(endpoint).queryParam("oauth_consumer_key", car2GoConsumerKey).queryParam("format",
                "json");
        if (location != null) {
            return target.queryParam("loc", location);
        }

        return target;
    }

    private Map executeGet(final WebTarget webTarget) {
        final Invocation.Builder invocationBuilder = webTarget.request();
        final Response response = invocationBuilder.get();
        return (Map) response.readEntity(Object.class);
    }

    private WebTarget getTarget() {
        final Client client = ClientBuilder.newClient();
        // using JacksonFeature for easier payload handling
        return client.target(car2GoApiUrl).register(JacksonFeature.class);
    }
}
