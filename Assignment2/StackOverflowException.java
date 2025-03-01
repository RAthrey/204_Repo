
public class StackOverflowException extends RuntimeException{
	public StackOverflowException () {
		super("StackUnderflow");
	}
	public StackOverflowException (String message) {
		super(message);
	}
}
