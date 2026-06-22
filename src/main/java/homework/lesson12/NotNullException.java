package homework.lesson12;

public class NotNullException extends RuntimeException {
    public NotNullException(String fieldName) {
        super("Field " + fieldName + " must not be null");
    }
}
