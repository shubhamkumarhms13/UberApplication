package com.rideshare.matchingservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Event published to Kafka topic: ride.matched
 * Consumed by Ride Service to update ride with assigned driver
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideMatchedEvent {

    private String riderId;
    private String rideId;
    private String driverId;
    private double pickupLatitude;
    private double pickupLongitude;
    private double distanceToPickupKm;
}
