
public class QueueOverflowException extends RuntimeException{
	public QueueOverflowException () {
		super("Overflow");
	}
	public QueueOverflowException (String message) {
		super(message);
	}
}
