public class LengthException extends RuntimeException{
	public LengthException(String message) {
		super(message);
	}
	public LengthException() {
		super(Exception_Messages.INVALID_LENGTH_EXCEPTION_MSG);
	}
}