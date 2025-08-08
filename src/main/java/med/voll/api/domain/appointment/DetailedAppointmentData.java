package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record DetailedAppointmentData(Long idAppointment, Long idDoctor, Long idPatient, LocalDateTime dateTime) {

    public DetailedAppointmentData(Appointment appointment) {
        this(appointment.getId(), appointment.getDoctor().getId(), appointment.getPatient().getId(), appointment.getDateTime());
    }

}
