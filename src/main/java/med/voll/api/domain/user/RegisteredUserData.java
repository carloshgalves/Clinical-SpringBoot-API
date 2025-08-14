package med.voll.api.domain.user;

public record RegisteredUserData(String login, String password, UserRole role) {
}
