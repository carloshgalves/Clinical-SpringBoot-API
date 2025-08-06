package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.domain.patient.PatientRepository;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientScheduleValidator {

    @Autowired
    private PatientRepository patientRepository;

    public void validatePatientSchedule(ScheduleAppointmentData data) {
        var firstAvailableAppointment = data.dateTime().withHour(7);
        var lastAvailableAppointment = data.dateTime().withHour(18);
        var patientHasAnotherAppointmentInTheDay = patientRepository.existsByIdAndDateBetween(data.idPatient(), firstAvailableAppointment, lastAvailableAppointment);
        if (patientHasAnotherAppointmentInTheDay) {
            throw new ValidationException("Patient already has an appointment in that day");
        }
    }

}
