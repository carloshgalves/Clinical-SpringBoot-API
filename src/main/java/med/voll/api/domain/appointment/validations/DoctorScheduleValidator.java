package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.appointment.AppointmentRepository;
import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorScheduleValidator {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void validateDoctorSchedule(ScheduleAppointmentData data) {
        var conflictScheduledDoctor = appointmentRepository.existsByDoctorIdAndDateTime(data.idDoctor(), data.dateTime());
        if (!conflictScheduledDoctor) {
            throw new ValidationException("The doctor is already booked for another appointment on that date");
        }
    }

}
