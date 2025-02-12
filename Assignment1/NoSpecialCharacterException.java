public class NoSpecialCharacterException extends RuntimeException{
	public NoSpecialCharacterException(String message) {
		super(message);
	}
	public NoSpecialCharacterException() {
		super(Exception_Messages.SPECIAL_CHAR_EXCEPTION_MSG);
	}
}