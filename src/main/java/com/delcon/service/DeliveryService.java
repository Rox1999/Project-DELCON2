package com.delcon.service;
import com.delcon.model.DeliveryBooking;
import com.delcon.repository.DeliveryBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeliveryService {
    @Autowired private DeliveryBookingRepository repo;

    public DeliveryBooking createBooking(DeliveryBooking booking) {
        booking.setTrackingCode(UUID.randomUUID().toString().substring(0,8).toUpperCase());
        booking.setStatus("Booked");
        return repo.save(booking);
    }
    public Optional<DeliveryBooking> getBookingByTrackingCode(String code) {
        return repo.findByTrackingCode(code);
    }
}
