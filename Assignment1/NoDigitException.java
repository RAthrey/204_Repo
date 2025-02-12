public class NoDigitException extends RuntimeException{
	public NoDigitException(String message) {
		super(message);
	}
	public NoDigitException() {
		super(Exception_Messages.DIGIT_EXCEPTION_MSG);
	}
}