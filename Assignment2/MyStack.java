import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
    private Node<T> top;
    private int currentSize;
    private int maxCapacity;
    private static final int DEFAULT_CAPACITY = 10;
    public MyStack(int size) {
        this.maxCapacity = size;
        this.top = null;
        this.currentSize = 0;
    }

    public MyStack() {
        this(DEFAULT_CAPACITY); 
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == maxCapacity;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        T data = top.data;
        top = top.next;
        currentSize--;
        return data;
    }

    @Override
    public T top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("Stack is full");
        }
        Node<T> newNode = new Node<>(e);
        newNode.next = top;
        top = newNode;
        currentSize++;
        return true;
    }

    @Override
    public String toString() {
    	if (top == null) {
            return "";
        }
        String finalString = "";
        Node<T> current = top;
        while (current != null) {
        	finalString += current.data;
            if (current.next != null) {
            	finalString += ""; 
            }
            current = current.next;
        }
        return finalString;
    }

    @Override
    public String toString(String delimiter) {
    	if (top == null) {
            return "";
        }
        String finalString = "";
        Node<T> current = top;
        while (current != null) {
        	finalString += current.data;
            if (current.next != null) {
            	finalString += delimiter; 
            }
            current = current.next;
        }
        return finalString;
    }

    @Override
    public void fill(ArrayList<T> list) throws StackOverflowException {
        ArrayList<T> copyList = new ArrayList<>(list);
        for (T item : copyList) {
            push(item);
        }
    }
}