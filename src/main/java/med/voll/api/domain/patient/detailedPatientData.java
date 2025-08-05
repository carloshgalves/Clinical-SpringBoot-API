package med.voll.api.domain.patient;

import med.voll.api.domain.address.Address;

public record detailedPatientData(Long id, String name, String email, String cpf, String telephoneNumber, Integer age, Sex sex, Address address) {

    public detailedPatientData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(), patient.getTelephoneNumber(), patient.getAge(), patient.getSex(), patient.getAddress());
    }

}
