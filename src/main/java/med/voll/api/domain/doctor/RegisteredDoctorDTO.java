package med.voll.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.RegisteredAddressData;

public record RegisteredDoctorDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telephoneNumber,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String medicalLicenseNumber,

        @NotNull
        Specialty specialty,

        @NotNull
        @Valid
        RegisteredAddressData address) {

}
