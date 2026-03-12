package booking;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Booking {
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private int roomNumber;
    private String reservationDescription;
    private LocalDate reservationDate;
}
