package com.ai6.ikyrus.cabmodule.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bharath on 7/5/17.
 */
/*@Data
@NoArgsConstructor*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String id;
    private String address;
    private float latitude;
    private float longitude;


    public Address() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
