public class NoUpperAlphaException extends RuntimeException{
	public NoUpperAlphaException(String message) {
		super(message);
	}
	public NoUpperAlphaException() {
		super(Exception_Messages.UPPER_ALPHA_EXCEPTION_MSG);
	}
}