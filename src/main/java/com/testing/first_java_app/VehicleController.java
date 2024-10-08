package com.testing.first_java_app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.transit.realtime.GtfsRealtime.FeedEntity;
import com.google.transit.realtime.GtfsRealtime.FeedMessage;

@RestController
public class VehicleController {

    @RequestMapping("/vehicle/location")
    public String getVehicleLocation() {
        String location = "";
        String licensePlate = "";

        try {
            URL url = new URL(
                    "https://api.data.gov.my/gtfs-realtime/vehicle-position/prasarana?category=rapid-bus-mrtfeeder");
            FeedMessage feed = FeedMessage.parseFrom(url.openStream());
            for (FeedEntity entity : feed.getEntityList()) {
                // if(entity.hasVehicle()){
                // System.out.println(entity);
                // }
                if (entity.getVehicle().getTrip().getRouteId().equals("T815")) {
                    System.out.println("Bus T815 : " + entity);
                    System.out.println("Vehicle stop status: " + entity.getVehicle().getCurrentStatus());
                    System.out.println("Stop id: " + entity.getVehicle().getStopId());
                    location = Double.toString(entity.getVehicle().getPosition().getLatitude()) + "," + Double.toString(entity.getVehicle().getPosition().getLongitude());
                    licensePlate = entity.getVehicle().getVehicle().getLicensePlate();


                }

            }

        } catch (IOException e) {
            System.out.println("Transport API issue");
        }
        return new Vehicle(location, licensePlate).toString();
    }
}
