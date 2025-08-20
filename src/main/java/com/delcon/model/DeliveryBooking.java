package com.delcon.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeliveryBooking {
    @Id @GeneratedValue
    private Long id;
    private String senderName;
    private String pickupAddress;
    private String deliveryAddress;
    private String packageDesc;
    private LocalDate deliveryDate;
    private String trackingCode;
    private String status; // e.g., Booked, In Transit, Delivered

    // Getters and setters...
    public Long getId() { return id; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String n) { senderName = n; }
    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String p) { pickupAddress = p; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String d) { deliveryAddress = d; }
    public String getPackageDesc() { return packageDesc; }
    public void setPackageDesc(String p) { packageDesc = p; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate date) { this.deliveryDate = date; }
    public String getTrackingCode() { return trackingCode; }
    public void setTrackingCode(String t) { trackingCode = t; }
    public String getStatus() { return status; }
    public void setStatus(String s) { status = s; }
}
