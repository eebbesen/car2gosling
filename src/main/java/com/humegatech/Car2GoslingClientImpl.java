package com.humegatech;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Car2GoslingClientImpl implements Car2GoslingClientInterface {
    private static final String DEFAULT_CAR2GO_API_URL = "https://www.car2go.com/api/v2.1/";
    private final String car2GoConsumerKey;
    private final String car2GoApiUrl;

    public Car2GoslingClientImpl(final String car2GoConsumerKey) {
        this.car2GoConsumerKey = car2GoConsumerKey;
        this.car2GoApiUrl = DEFAULT_CAR2GO_API_URL;
    }

    @Override
    public String getLocations() {
        final WebTarget target = buildWebTarget("locations", null);
        final JSONObject locations = executeGet(target);
        return getValues(locations, "location");
    }

    @Override
    public String getGasStations(final String location) {
        final WebTarget target = buildWebTarget("gasstations", location);
        final JSONObject gasStations = executeGet(target);
        return getValues(gasStations, "placemarks");
    }

    @Override
    public String getOperationAreas(final String location) {
        final WebTarget target = buildWebTarget("operationareas", location);
        final JSONObject operationAreas = executeGet(target);
        return getValues(operationAreas, "placemarks");
    }

    @Override
    public String getParkingSpots(final String location) {
        final WebTarget target = buildWebTarget("parkingspots", location);
        final JSONObject parkingSpots = executeGet(target);
        return getValues(parkingSpots, "placemarks");
    }

    @Override
    public String getVehicles(final String location) {
        final WebTarget target = buildWebTarget("vehicles", location);
        final JSONObject vehicles = executeGet(target);
        return getValues(vehicles, "placemarks");
    }

    private String getValues(final JSONObject payload, final String key) {
        String ret = "";
        try {
            ret = payload.get(key).toString();
        } catch (final JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ret;
    }

    private WebTarget buildWebTarget(final String endpoint, final String location) {
        final WebTarget target = getTarget().path(endpoint).queryParam("oauth_consumer_key", car2GoConsumerKey).queryParam("format",
                "json");
        if (location != null) {
            return target.queryParam("loc", location);
        }

        return target;
    }

    private JSONObject executeGet(final WebTarget webTarget) {
        final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.get();
        final String jsonString = response.readEntity(String.class);
        try {
            return new JSONObject(jsonString);
        } catch (final JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private WebTarget getTarget() {
        final Client client = ClientBuilder.newClient();
        return client.target(car2GoApiUrl);
    }
}
