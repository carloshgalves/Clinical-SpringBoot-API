package med.voll.api.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {

    ADMINISTRATOR("administrator"),
    PATIENT("patient"),
    DOCTOR("doctor");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

}
