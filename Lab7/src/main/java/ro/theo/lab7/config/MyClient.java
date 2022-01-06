package ro.theo.lab7.config;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class MyClient {
    private static String url = "http://localhost:8080/Lab7-1.0-SNAPSHOT/resources/documents";

    public static void main(String args[]) {
        Client client = ClientBuilder.newClient().register(DocumentFilter.class);
        String temp = client.target(url).request(MediaType.APPLICATION_JSON).get(String.class);
    }
}