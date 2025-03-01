import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {

    private MyQueue<Integer> queue;

    @BeforeEach
    void setUp() throws Exception {
        queue = new MyQueue<>(5); 
    }

    @AfterEach
    void tearDown() throws Exception {
        queue = null;
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        try {
            queue.enqueue(1);
        } catch (QueueOverflowException e) {
            fail("QueueOverflowException should not be thrown");
        }
        assertFalse(queue.isEmpty());
    }

    @Test
    void testDequeue() {
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            assertEquals(1, queue.dequeue());
            assertEquals(2, queue.dequeue());
        } catch (QueueOverflowException | QueueUnderflowException e) {
            fail("Exception should not be thrown");
        }
        assertThrows(QueueUnderflowException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());
        try {
            queue.enqueue(1);
            queue.enqueue(2);
        } catch (QueueOverflowException e) {
            fail("QueueOverflowException should not be thrown");
        }
        assertEquals(2, queue.size());
    }

    @Test
    void testEnqueue() {
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
        } catch (QueueOverflowException e) {
            fail("QueueOverflowException should not be thrown");
        }
        assertThrows(QueueOverflowException.class, () -> {
            queue.enqueue(6);
        });
    }

    @Test
    void testIsFull() {
        assertFalse(queue.isFull());
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
        } catch (QueueOverflowException e) {
            fail("QueueOverflowException should not be thrown");
        }
        assertTrue(queue.isFull());
    }

    @Test
    void testToString() {
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
        } catch (QueueOverflowException e) {
            fail("QueueOverflowException should not be thrown");
        }
        assertEquals("123", queue.toString());
    }

    @Test
    void testToStringString() {
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
        } catch (QueueOverflowException e) {
            fail("QueueOverflowException should not be thrown");
        }
        assertEquals("1,2,3", queue.toString(","));
    }

    @Test
    void testFill() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            queue.fill(list);
        } catch (QueueOverflowException e) {
            fail("QueueOverflowException should not be thrown");
        }
        assertEquals("123", queue.toString());
        assertThrows(QueueOverflowException.class, () -> {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(4);
            newList.add(5);
            newList.add(6);
            queue.fill(newList);
        });
    }
}