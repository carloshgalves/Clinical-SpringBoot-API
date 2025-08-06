package med.voll.api.domain.patient;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.RegisteredAddressData;

public record RegisteredPatientDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotBlank
        String telephoneNumber,

        @NotNull
        Integer age,

        @Enumerated(EnumType.STRING)
        @NotNull
        Sex sex,

        @NotNull
        @Valid
        RegisteredAddressData address
) {
}
