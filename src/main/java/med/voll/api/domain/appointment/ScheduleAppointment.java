package med.voll.api.domain.appointment;

import jakarta.validation.Valid;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.patient.PatientRepository;
import med.voll.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleAppointment {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public void scheduleAppointment(@Valid ScheduleAppointmentData data) {
        if (!patientRepository.existsById(data.idPatient())) {
            throw new ValidationException("The patient ID is invalid or not found in the database.");
        }

        if (data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())) {
            throw new ValidationException("The doctor ID is invalid or not found in the database.");
        }

        var patient = patientRepository.getReferenceById(data.idPatient());
        var doctor = selectDoctor(data);
        var appointment = new Appointment(null, patient, doctor, data.dateTime());

        appointmentRepository.save(appointment);
    }

    private Doctor selectDoctor(@Valid ScheduleAppointmentData data) {
        if (data.idDoctor() != null) {
            return doctorRepository.getReferenceById(data.idDoctor());
        }

        if (data.specialty() == null) {
            throw new ValidationException("Specialty not informed. The specialty field is required when the doctor field is not filled in.");
        }

        return doctorRepository.selectRandomDoctorOnGivenDate(data.specialty(), data.dateTime());
    }

}
