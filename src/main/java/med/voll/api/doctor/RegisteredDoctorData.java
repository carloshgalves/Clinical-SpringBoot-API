package med.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.address.RegisteredAddressData;

public record RegisteredDoctorData(
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
