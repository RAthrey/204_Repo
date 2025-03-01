
public class StackUnderflowException extends RuntimeException{
	public StackUnderflowException () {
		super("StackUnderflow");
	}
	public StackUnderflowException (String message) {
		super(message);
	}
}
