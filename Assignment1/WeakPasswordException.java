public class WeakPasswordException extends RuntimeException {
    public WeakPasswordException(String message) {
        super(message);
    }
    public WeakPasswordException() {
        super(Exception_Messages.WEAK_PWD_MSG);
    }
}
