package com.rideshare.matchingservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Event consumes from Kafka topic: ride.requested
 * Published by ride service when a rider request a ride
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestedEvent {

    private String riderId;
    private String rideId;
    private double pickupLatitude;
    private double pickupLongitude;
    private String pickupAddress;
    private double dropLatitude;
    private double dropLongitude;
    private String dropAddress;

}
