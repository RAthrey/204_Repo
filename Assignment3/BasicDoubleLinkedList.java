import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected class Node {
        T data;
        Node next, prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    protected Node head, tail;
    protected int size;

    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public T getFirst() {
    	if (head != null) {
    		return head.data;
    	} else {
    		return null;
    	}
    }

    public T getLast() {
    	if (tail != null) {
    		return tail.data;
    	} else {
    		return null;
    	}
    }

    public Node remove(T targetData, Comparator<T> comparator) {
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public T retrieveFirstElement() {
        if (head == null) {
        	return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
        	head.prev = null;
        }
        else {
        	tail = null;
        }
        size--;
        return data;
    }

    public T retrieveLastElement() {
        if (tail == null) {
        	return null;
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
        	tail.next = null;
        }
        else {
        	head = null;
        }
        size--;
        return data;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (current == null) {
            	throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }

        public boolean hasPrevious() {
            return current != null && current.prev != null;
        }

        public T previous() {
            if (current == null || current.prev == null) {
            	throw new NoSuchElementException();
            }
            current = current.prev;
            return current.data;
        }

        public int nextIndex() { 
        	throw new UnsupportedOperationException(); 
        }
        public int previousIndex() { 
        	throw new UnsupportedOperationException(); 
        }
        public void remove() { 
        	throw new UnsupportedOperationException(); 
        }
        public void set(T e) { 
        	throw new UnsupportedOperationException(); 
        }
        public void add(T e) {
        	throw new UnsupportedOperationException(); 
        }
    }
}
