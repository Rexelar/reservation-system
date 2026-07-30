package school.sorokin.azizov.reservation_system;

import java.time.LocalDate;
import java.time.LocalDateTime;

record Reservation (
        Long id,
        Long userId,
        Long roomId,
        LocalDate starDate,
        LocalDate endDate,
        ReservationStatus status

)

{
}
