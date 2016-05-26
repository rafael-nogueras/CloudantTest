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

import java.util.Date;

/**
 * Encapsulates the Net Promoter Score data persisted for every customer.
 *
 * @author Rafa Nogueras rafaeln
 */
class NetPromoterScore {
    /**
     * Unique identifier for this item within the database.
     */
    private final String _id;

    /**
     * The name of the customer providing the rating.
     */
    private final String customerName;

    /**
     * The net promoter score rating provided by the customer.
     */
    private final int rating;

    /**
     * The creation time of this entry,
     */
    private final Date creationDate;

    /**
     * The revision value of the database entry; it is set by the database.
     */
    private String _rev = null;

    NetPromoterScore(String customerName, int rating) {
        this.customerName = customerName;
        this.rating = rating;

        _id = "nps_id" + System.currentTimeMillis();
        creationDate = new Date();
    }

    String getId() {
        return _id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRating() {
        return rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getRevision() {
        return _rev;
    }

    @Override
    public String toString() {
        return "NetPromoterScore{" +
                "_id='" + _id + '\'' +
                ", _rev='" + _rev + '\'' +
                ", customerName='" + customerName + '\'' +
                ", rating=" + rating +
                ", creationDate=" + creationDate +
                '}';
    }
}
