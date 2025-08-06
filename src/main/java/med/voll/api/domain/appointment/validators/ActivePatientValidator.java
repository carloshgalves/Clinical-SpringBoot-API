package med.voll.api.domain.appointment.validators;

import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.domain.patient.PatientRepository;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivePatientValidator implements ScheduleAppointmentValidator {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void validate(ScheduleAppointmentData data) {
        var isPatientActive = patientRepository.existsByIdAndActiveTrue(data.idPatient());
        if (!isPatientActive) {
            throw new ValidationException("Patient is no longer available for scheduling");
        }
    }
}
