    package med.voll.api.domain.patient;

    import jakarta.persistence.*;
    import jakarta.validation.Valid;
    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.EqualsAndHashCode;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import med.voll.api.domain.address.Address;
    import org.hibernate.sql.Update;

    @Table(name = "patients")
    @Entity(name = "Patient")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String cpf;
        private String telephoneNumber;
        private Integer age;

        @NotNull
        @Enumerated(EnumType.STRING)
        private Sex sex;

        @Embedded
        private Address address;

        private boolean active;

        public Patient(@Valid RegisteredPatientDTO patientDTO) {
            this.active = true;
            this.name = patientDTO.name();
            this.email = patientDTO.email();
            this.cpf = patientDTO.cpf();
            this.telephoneNumber = patientDTO.telephoneNumber();
            this.age = patientDTO.age();
            this.sex = patientDTO.sex();
            this.address = new Address(patientDTO.address());
        }

        public void updateData(@Valid UpdatedPatientDTO updatedPatientDTO) {
            if (updatedPatientDTO.name() != null) {
                this.name = updatedPatientDTO.name();
            }
            if (updatedPatientDTO.email() != null) {
                this.email = updatedPatientDTO.email();
            }
            if (updatedPatientDTO.telephoneNumber() != null) {
                this.telephoneNumber = updatedPatientDTO.telephoneNumber();
            }
            if (updatedPatientDTO.addressData() != null) {
                this.address.updateData(updatedPatientDTO.addressData());
            }
        }

        public void deletePatient() {
            this.active = false;
        }
    }
