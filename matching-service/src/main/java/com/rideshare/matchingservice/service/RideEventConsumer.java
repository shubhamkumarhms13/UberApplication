package com.rideshare.matchingservice.service;

import com.rideshare.matchingservice.event.RideRequestedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RideEventConsumer {

    private final MatchingService matchingService;

    /**
     * Listen to ride.requested kafka topic
     * Trigger everytime ride service published a new ride request
     * <p>
     * FLOW:
     * Ride Service -> Kafka(ride.requested) -> This consumer -> MatchingService
     */
    @KafkaListener(topics = "ride.requested", groupId = "matching-service-group")
    public void consumerRideRequestedEvent(RideRequestedEvent event) {
        try {
            matchingService.matchDriverForRide(event);
        } catch (Exception e) {
            log.error("Error processing ride requested {} - {}", event.getRideId(), e.getMessage());

            //In production: send to dead letter for retry
        }
    }
}
