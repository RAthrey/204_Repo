
public class InvalidNotationFormatException extends RuntimeException {
	public InvalidNotationFormatException() {
		super("InvalidNotation");
	}
	public InvalidNotationFormatException(String message) {
		super(message);
	}
}
