package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Component
public class AppointmentLeadTimeValidator {

    public void validateLeadTime(ScheduleAppointmentData data) {
        var appointmentDateTime = data.dateTime();
        var now = LocalDate.now();
        var minutesDifference = Duration.between(now, appointmentDateTime).toMinutes();

        if (minutesDifference < 30) {
            throw new ValidationException("Appointment must be scheduled at least 30 minutes in advance");
        }
    }

}
