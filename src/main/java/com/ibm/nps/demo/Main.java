/*
 * IBM Confidential
 * 
 * OCO Source Materials
 * 
 * 5725-A20
 * 
 * Copyright IBM Corporation 2016. All Rights Reserved.
 * 
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what
 * has been deposited with the U.S. Copyright Office.
 */
package com.ibm.nps.demo;

import java.net.MalformedURLException;
import java.net.URL;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

/**
 * Executable class to showcase Cloudant database functionality.
 *
 * @author Rafa Nogueras rafaeln
 */
public class Main {

    private static final String CLOUDANT_URL = "https://df9efa23-987c-434d-a177-ea16c91c491b-bluemix.cloudant.com/_all_dbs";
    private static final String API_TOKEN = "urionditengsolowerespera";
    private static final String API_PASSWORD = "25af816fd95e7f7ca7b22288ff8f9521ba4d8487";

    public static void main(String[] args) throws MalformedURLException {
        CloudantClient client = ClientBuilder.url(new URL(CLOUDANT_URL))
                .username(API_TOKEN)
                .password(API_PASSWORD)
                .build();

        // Show the server version
        System.out.println("Server Version: " + client.serverVersion());

        // Get a handle on our database, but don't create it if it doesn't already exist.
        Database db = client.database("rafaeln", false);

        // Create an NetPromoterScore object and save it in the database
        NetPromoterScore netPromoterScore = new NetPromoterScore("Test Customer", 8);
        db.save(netPromoterScore);
        System.out.println("You have inserted a new document");

        // Get an NetPromoterScore out of the database and deserialize the JSON into a Java type.
        NetPromoterScore doc = db.find(NetPromoterScore.class, netPromoterScore.getId());
        System.out.println(doc);
    }
}
