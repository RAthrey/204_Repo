import java.util.ArrayList;
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
public class MyQueue<T> implements QueueInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int currentSize;
    private int maxCapacity;
    private static final int DEFAULT_CAPACITY = 10;
    public MyQueue(int currentSize) {
        this.maxCapacity = currentSize;
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    public MyQueue() {
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
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        T data = head.data;
        head = head.next;
        currentSize--;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean enqueue(T e) throws QueueOverflowException {
    	if (isFull()) {
            throw new QueueOverflowException();
        }
        Node<T> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
            tail=newNode;
        } else {
            tail.next = newNode;
            tail=newNode;
        }
        currentSize++;
        return true;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        String finalString = "";
        Node<T> current = head;
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
    	if (head == null) {
            return "";
        }
        String finalString = "";
        Node<T> current = head;
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
    public void fill(ArrayList<T> list) throws QueueOverflowException {
    	ArrayList<T> copyList = new ArrayList<>(list);
        for (T item : copyList) {
        	if (isFull()) {
                throw new QueueOverflowException();
            }
            enqueue(item);
        }
    }
}