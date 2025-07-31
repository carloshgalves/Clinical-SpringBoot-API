package med.voll.api.domain.doctor;


public record DoctorSumaryDTO(Long id, String name, String email, String addressComplement, String medicalLicenseNumber, Specialty specialty) {

    public DoctorSumaryDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getTelephoneNumber(), doctor.getMedicalLicenseNumber(), doctor.getSpecialty());
    }

}
   