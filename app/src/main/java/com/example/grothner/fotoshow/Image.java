package com.example.grothner.fotoshow;

import org.osmdroid.util.GeoPoint;

/**
 * Created by Gregor on 17.06.2015.
 */
public class Image {
    String id;
    String date;
    GeoPoint geoPoint;

    public Image(String id, String date, GeoPoint geoPoint) {
        this.id = id;
        this.date = date;
        this.geoPoint = geoPoint;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", geoPoint=" + geoPoint +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }
}
