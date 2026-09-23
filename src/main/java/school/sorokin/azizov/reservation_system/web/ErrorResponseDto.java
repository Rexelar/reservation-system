package school.sorokin.azizov.reservation_system.web;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String message,
        String detailedMessage, //errorMessage
        LocalDateTime errorTime

) {
}
