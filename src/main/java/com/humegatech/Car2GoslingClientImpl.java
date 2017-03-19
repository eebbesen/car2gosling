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
        final WebTarget target = getTarget().path("locations").queryParam("oauth_consumer_key", car2GoConsumerKey)
                .queryParam("format", "json");

        final Invocation.Builder invocationBuilder = target.request();
        final Response response = invocationBuilder.get();
        final Map locs = (Map) response.readEntity(Object.class);
        return (ArrayList) locs.get("location");
    }

    private WebTarget getTarget() {
        final Client client = ClientBuilder.newClient();
        // using JacksonFeature for easier payload handling
        return client.target(car2GoApiUrl).register(JacksonFeature.class);
    }

}
