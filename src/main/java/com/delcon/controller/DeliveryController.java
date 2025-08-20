package com.delcon.controller;
import com.delcon.model.DeliveryBooking;
import com.delcon.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class DeliveryController {
    @Autowired private DeliveryService deliveryService;

    @PostMapping
    public DeliveryBooking createBooking(@RequestBody DeliveryBooking b) {
        return deliveryService.createBooking(b);
    }

    @GetMapping("/{trackingCode}")
    public ResponseEntity<DeliveryBooking> getBooking(@PathVariable String trackingCode) {
        Optional<DeliveryBooking> booking = deliveryService.getBookingByTrackingCode(trackingCode);
        return booking.map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
