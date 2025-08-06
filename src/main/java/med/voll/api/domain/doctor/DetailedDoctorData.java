package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;

public record DetailedDoctorData(Long id, String name, String email, String telephoneNumber, String medicalLicenseNumber, Specialty specialty, Address address) {

    public DetailedDoctorData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getTelephoneNumber(), doctor.getMedicalLicenseNumber(), doctor.getSpecialty(), doctor.getAddress());
    }

}
