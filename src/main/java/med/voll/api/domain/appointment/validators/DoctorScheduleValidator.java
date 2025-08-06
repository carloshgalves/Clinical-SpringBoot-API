package med.voll.api.domain.appointment.validators;

import med.voll.api.domain.appointment.AppointmentRepository;
import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorScheduleValidator implements ScheduleAppointmentValidator{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void validate(ScheduleAppointmentData data) {
        var conflictScheduledDoctor = appointmentRepository.existsByDoctorIdAndDateTime(data.idDoctor(), data.dateTime());
        if (conflictScheduledDoctor) {
            throw new ValidationException("The doctor is already booked for another appointment on that date");
        }
    }
}
