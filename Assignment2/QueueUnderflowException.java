
public class QueueUnderflowException extends RuntimeException{
	public QueueUnderflowException () {
		super("Underflow");
	}
	public QueueUnderflowException (String message) {
		super(message);
	}
}
