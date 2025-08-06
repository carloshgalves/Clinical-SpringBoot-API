package med.voll.api.domain.patient;

import med.voll.api.domain.address.Address;

public record PatientSumaryDTO (Long id, String name, String email, String cpf, String telephoneNumber, Integer age, Sex sex, Address address) {

    public PatientSumaryDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(), patient.getTelephoneNumber(), patient.getAge(), patient.getSex(), patient.getAddress());
    }

}
