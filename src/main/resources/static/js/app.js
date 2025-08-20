// --- Booking Submission ---
document.getElementById('bookingForm').onsubmit = async function(e) {
    e.preventDefault();
    let data = {
        senderName: document.getElementById('senderName').value,
        pickupAddress: document.getElementById('pickupAddress').value,
        deliveryAddress: document.getElementById('deliveryAddress').value,
        packageDesc: document.getElementById('packageDesc').value,
        deliveryDate: document.getElementById('deliveryDate').value
    };
    let res = await fetch('/api/bookings', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    });
    const bookingMsg = document.getElementById('bookingMsg');
    if(res.ok) {
        let booking = await res.json();
        bookingMsg.innerHTML = `<span class='text-success'>Booking successful!<br>Your Tracking Code: <b>${booking.trackingCode}</b></span>`;
        document.getElementById('bookingForm').reset();
    } else {
        bookingMsg.innerHTML = "<span class='text-danger'>Failed to book delivery. Try again.</span>";
    }
};

// --- Parcel Tracking ---
document.getElementById('trackForm').onsubmit = async function(e) {
    e.preventDefault();
    let id = document.getElementById('trackingId').value.trim();
    let res = await fetch(`/api/bookings/${encodeURIComponent(id)}`);
    const trackingResult = document.getElementById('trackingResult');
    if(res.ok) {
        let booking = await res.json();
        trackingResult.innerHTML = `
            <span class="text-success">Parcel Status: <b>${booking.status}</b></span><br>
            Sent by: ${booking.senderName}<br>
            Pickup: ${booking.pickupAddress}<br>
            Delivery: ${booking.deliveryAddress}<br>
            Scheduled Date: ${booking.deliveryDate}
        `;
    } else {
        trackingResult.innerHTML = "<span class='text-danger'>Tracking code not found.</span>";
    }
};
