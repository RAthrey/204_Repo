public class NoLowerAlphaException extends RuntimeException{
	public NoLowerAlphaException(String message) {
		super(message);
	}
	public NoLowerAlphaException() {
		super(Exception_Messages.LOWER_ALPHA_EXCEPTION_MSG);
	}
}