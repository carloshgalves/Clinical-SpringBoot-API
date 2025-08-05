    package med.voll.api.domain.patient;

    import jakarta.persistence.*;
    import jakarta.validation.Valid;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.EqualsAndHashCode;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import med.voll.api.domain.address.Address;

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

        @NotNull
        private String name;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String cpf;

        @NotBlank
        private String telephoneNumber;

        @NotNull
        private Integer age;

        @NotBlank
        @Enumerated(EnumType.STRING)
        private Sex sex;

        @Embedded
        private Address address;

        private boolean active;

        public Patient(@Valid RegisteredPatientDTO patientDTO) {
            this.active = true;
            this.name = patientDTO.name();
            this.cpf = patientDTO.cpf();
            this.age = patientDTO.age();
            this.sex = patientDTO.sex();
            this.address = new Address(patientDTO.address());
        }
    }
