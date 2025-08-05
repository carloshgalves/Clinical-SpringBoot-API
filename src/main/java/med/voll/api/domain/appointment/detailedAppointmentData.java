package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record detailedAppointmentData(Long idAppointment, Long idDoctor, Long idPatient, LocalDateTime dateTime) {
}
