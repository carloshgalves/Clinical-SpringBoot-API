package med.voll.api.domain.appointment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.doctor.Specialty;

import java.time.LocalDateTime;

public record ScheduleAppointmentData(
        @NotNull
        Long idPatient,

        @NotNull
        Long idDoctor,

        @NotNull
        @Future
        LocalDateTime dateTime,

        Specialty specialty
) {
}
