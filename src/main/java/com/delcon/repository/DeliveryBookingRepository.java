package com.delcon.repository;
import com.delcon.model.DeliveryBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DeliveryBookingRepository extends JpaRepository<DeliveryBooking, Long> {
    Optional<DeliveryBooking> findByTrackingCode(String trackingCode);
}
