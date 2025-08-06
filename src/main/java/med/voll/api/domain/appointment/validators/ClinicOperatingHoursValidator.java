package med.voll.api.domain.appointment.validators;

import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ClinicOperatingHoursValidator implements ScheduleAppointmentValidator{

    @Override
    public void validate(ScheduleAppointmentData data) {
        var dateTimeAppointment = data.dateTime();

        var sunday = dateTimeAppointment.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeClinicOpens = dateTimeAppointment.getHour() < 7;
        var afterClinicCloses = dateTimeAppointment.getHour() > 18;

        if (sunday || beforeClinicOpens || afterClinicCloses) {
            throw new ValidationException("Appointment outside clinic operating hours");
        }
    }
}
