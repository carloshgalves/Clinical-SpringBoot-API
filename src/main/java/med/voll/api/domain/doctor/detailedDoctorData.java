package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;

public record detailedDoctorData(Long id, String name, String email, String telephoneNumber, String medicalLicenseNumber, Specialty specialty, Address address) {

    public detailedDoctorData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getTelephoneNumber(), doctor.getMedicalLicenseNumber(), doctor.getSpecialty(), doctor.getAddress());
    }

}
