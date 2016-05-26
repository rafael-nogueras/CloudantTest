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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

/**
 * @author Rafa Nogueras rafaeln
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException {
// Create a new CloudantClient instance for account endpoint example.cloudant.com

        ClientBuilder url = ClientBuilder.url(new URL("https://df9efa23-987c-434d-a177-ea16c91c491b-bluemix.cloudant.com/_all_dbs"));
        System.out.println("URL us: " + url);
        CloudantClient client = url
                .username("urionditengsolowerespera")
                .password("25af816fd95e7f7ca7b22288ff8f9521ba4d8487")
                .build();

// Note: for Cloudant Local or Apache CouchDB use:
// ClientBuilder.url(new URL("yourCloudantLocalAddress.example"))
//              .username("exampleUser")
//              .password("examplePassword")
//              .build();

// Show the server version
        System.out.println("Server Version: " + client.serverVersion());

// Get a List of all the databases this Cloudant account
//        List<String> databases = client.getAllDbs();
//        System.out.println("All my databases : ");
//        for ( String db : databases ) {
//            System.out.println(db);
//        }

// Working with data

// Delete a database we created previously.
//        client.deleteDB("example_db");

// Create a new database.
//        client.createDB("example_db");

// Get a Database instance to interact with, but don't create it if it doesn't already exist
        Database db = client.database("rafaeln", false);

// A Java type that can be serialized to JSON

// Create an ExampleDocument and save it in the database
        ExampleDocument exampleDocument = new ExampleDocument(true);
        db.save(exampleDocument);
        System.out.println("You have inserted the document");

// Get an ExampleDocument out of the database and deserialize the JSON into a Java type
        ExampleDocument doc = db.find(ExampleDocument.class, exampleDocument._id);
        System.out.println(doc);
    }

    private static class ExampleDocument {
        private String _id = "example_id" + System.currentTimeMillis();
        private String _rev = null;
        private boolean isExample;

        private Date date;

        public ExampleDocument(boolean isExample) {
            this.isExample = isExample;
            date = new Date();
        }

        public String toString() {
            return "{ id: " + _id + ",\nrev: " + _rev + ",\nisExample: " + isExample + "\n date: " + date + "}";
        }
    }
}
