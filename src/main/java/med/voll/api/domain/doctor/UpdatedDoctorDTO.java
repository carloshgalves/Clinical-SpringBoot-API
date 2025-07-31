package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.RegisteredAddressData;

public record UpdatedDoctorDTO (
        @NotNull
        Long id,
        String name,
        String telephone,
        RegisteredAddressData addressData) {}
