package med.voll.api.domain.doctor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;


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

    private boolean active;

    public Doctor(RegisteredDoctorDTO data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.medicalLicenseNumber = data.medicalLicenseNumber();
        this.telephoneNumber = data.telephoneNumber();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updateData(@Valid UpdatedDoctorDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.telephone() != null) {
            this.telephoneNumber = data.telephone();
        }
        if (data.addressData() != null) {
            this.address.updateData(data.addressData());
        }
    }

    public void deleteDoctor() {
        this.active = false;
    }
}
