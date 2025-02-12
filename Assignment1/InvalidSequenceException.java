public class InvalidSequenceException extends RuntimeException {

    public InvalidSequenceException(String message) {
        super(message); 
    }

    public InvalidSequenceException() {
        super(Exception_Messages.INVALID_SEQUENCE_EXCEPTION_MSG); 
    }

}