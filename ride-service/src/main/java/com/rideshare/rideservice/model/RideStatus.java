package com.rideshare.rideservice.model;

/**
 * FLOW:
 * Requested -> Matching -> Accepted -> Driver_Arriving
 *           -> Ride_Started -> Completed
 *           -> Cancelled (can happen at multiple stages)
 */
public enum RideStatus {
    REQUESTED,
    MATCHING,
    ACCEPTED,
    DRIVER_ARRIVING,
    RIDE_STARTED,
    COMPLETED,
    CANCELLED
}
