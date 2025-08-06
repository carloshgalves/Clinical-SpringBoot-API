package med.voll.api.domain.appointment.validators;

import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AppointmentLeadTimeValidator implements ScheduleAppointmentValidator{

    @Override
    public void validate(ScheduleAppointmentData data) {
        var appointmentDateTime = data.dateTime();
        var now = LocalDateTime.now();
        var minutesUntilAppointment = Duration.between(now, appointmentDateTime).toMinutes();

        if (minutesUntilAppointment < 30) {
            throw new ValidationException("Appointment must be scheduled at least 30 minutes in advance");
        }
    }
}
