package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;


@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;
    private String medicalLicenseNumber;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(RegisteredDoctorData data) {
        this.name = data.name();
        this.email = data.email();
        this.medicalLicenseNumber = data.medicalLicenseNumber();
        this.telephoneNumber = data.telephoneNumber();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

}
