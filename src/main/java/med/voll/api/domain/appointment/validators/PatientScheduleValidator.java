package med.voll.api.domain.appointment.validators;

import med.voll.api.domain.appointment.AppointmentRepository;
import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientScheduleValidator implements ScheduleAppointmentValidator{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void validate(ScheduleAppointmentData data) {
        var firstAvailableAppointment = data.dateTime().withHour(7);
        var lastAvailableAppointment = data.dateTime().withHour(18);
        var patientHasAnotherAppointmentInTheDay = appointmentRepository.existsByPatientIdAndDateTimeBetween(data.idPatient(), firstAvailableAppointment, lastAvailableAppointment);

        if (patientHasAnotherAppointmentInTheDay) {
            throw new ValidationException("Patient already has an appointment in that day");
        }
    }

}
