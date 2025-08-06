package med.voll.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.RegisteredAddressData;

public record UpdatedPatientDTO(
        @NotNull
        Long id,
        String name,
        String email,
        String telephoneNumber,
        RegisteredAddressData addressData
) {
}
