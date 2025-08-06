package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.appointment.ScheduleAppointmentData;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveDoctorValidator {

    @Autowired
    private DoctorRepository doctorRepository;

    public void validateDoctor(ScheduleAppointmentData data) {
        //Optional doctor selection
        if (data.idDoctor() == null) {
            return;
        }

        var isDoctorActive = doctorRepository.findActiveById(data.idDoctor());
        if (!isDoctorActive) {
              throw new ValidationException("Doctor is no longer available for scheduling");
        }
    }

}
