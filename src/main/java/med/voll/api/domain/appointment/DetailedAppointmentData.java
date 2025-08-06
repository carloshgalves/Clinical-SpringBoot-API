package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record DetailedAppointmentData(Long idAppointment, Long idDoctor, Long idPatient, LocalDateTime dateTime) {
}
