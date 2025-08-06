package med.voll.api.infra.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
