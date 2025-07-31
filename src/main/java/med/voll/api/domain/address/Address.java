package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String number;
    private String addressComplement;

    public Address(RegisteredAddressData data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zipCode = data.zipCode();
        this.city = data.city();
        this.state = data.state();
        this.number = data.number();
        this.addressComplement = data.addressComplement();
    }

    public void updateData(RegisteredAddressData addressData) {
        if (addressData.street() != null) {
            this.street = addressData.street();
        }
        if (addressData.neighborhood() != null) {
            this.neighborhood = addressData.neighborhood();
        }
        if (addressData.zipCode() != null) {
            this.zipCode = addressData.zipCode();
        }
        if (addressData.city() != null) {
            this.city = addressData.city();
        }
        if (addressData.state() != null) {
            this.state = addressData.state();
        }
        if (addressData.number() != null) {
            this.number = addressData.number();
        }
        if (addressData.addressComplement() != null) {
            this.addressComplement = addressData.addressComplement();
        }
    }
}
