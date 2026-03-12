package booking.Controller;

import booking.Booking;
import booking.Service.BookingService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("./booking")

@Getter
@Setter
@AllArgsConstructor

public class BookingController {

    private final BookingService bookingService;

@GetMapping
    public ResponseEntity<List<Booking>> getReservation(){
    return ResponseEntity.ok(bookingService.getBookings());
}

@PostMapping
    public ResponseEntity<Object> createReservation(@RequestBody Booking booking){
    try {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }catch (IllegalArgumentException e){
        String message = e.getMessage();
        if (message.contains("not available")) {
            return ResponseEntity.status(409).body(Map.of("message", message));
        } else {
            return ResponseEntity.status(400).body(Map.of("message", message));
        }
    }
}
}
