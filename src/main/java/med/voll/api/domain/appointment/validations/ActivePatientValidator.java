package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.domain.patient.PatientRepository;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivePatientValidator {

    @Autowired
    private PatientRepository patientRepository;

    public void validatePatient(ScheduleAppointmentData data) {
        var isPatientActive = patientRepository.findActiveById(data.idPatient());
        if (!isPatientActive) {
            throw new ValidationException("Patient is no longer available for scheduling");
        }
    }

}
