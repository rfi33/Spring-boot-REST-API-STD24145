package com.example.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final List<Booking> bookings= new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Booking> CreateBooking(Booking booking){
        if(booking.getRoomNumber() < 1 || booking.getRoomNumber() > 9){
            throw new IllegalArgumentException("Room number must be between 1 and 9");
        }

        for (Booking existing: bookings){
            if(existing.getRoomNumber() == booking.getRoomNumber()
                    && existing.getReservationDate().equals(booking.getReservationDate()))
                throw new IllegalArgumentException("This room is not available for this date");
        }
        bookings.add(booking);
        return bookings;
    }
}
