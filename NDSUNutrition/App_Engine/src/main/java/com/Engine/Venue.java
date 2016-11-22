package com.Engine;

import java.io.Serializable;

/**
 *
 * @author donovan.beckmann
 */
public class Venue implements Serializable{
    private String name;

    public Venue(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venue)) return false;

        Venue venue = (Venue) o;

        return name != null ? name.equals(venue.name) : venue.name == null;

    }

    @Override
    public String toString() {
        return "Venue{" +
                "name ='" + name + '\'' +
                '}';
    }
}
