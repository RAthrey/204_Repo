import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {

    private MyStack<Integer> stack;

    @BeforeEach
    void setUp() throws Exception {
        stack = new MyStack<>(5);
    }

    @AfterEach
    void tearDown() throws Exception {
        stack = null;
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        try {
            stack.push(1);
        } catch (StackOverflowException e) {
            fail("StackOverflowException should not be thrown");
        }
        assertFalse(stack.isEmpty());
    }

    @Test
    void testIsFull() {
        assertFalse(stack.isFull());
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
        } catch (StackOverflowException e) {
            fail("StackOverflowException should not be thrown");
        }
        assertTrue(stack.isFull());
    }

    @Test
    void testPop() {
        try {
            stack.push(1);
            stack.push(2);
            assertEquals(2, stack.pop());
            assertEquals(1, stack.pop());
        } catch (StackOverflowException | StackUnderflowException e) {
            fail("Exception should not be thrown");
        }
        assertThrows(StackUnderflowException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testTop() {
        try {
            stack.push(1);
            stack.push(2);
            assertEquals(2, stack.top());
            stack.pop();
            assertEquals(1, stack.top());
        } catch (StackOverflowException | StackUnderflowException e) {
            fail("Exception should not be thrown");
        }
        assertThrows(StackUnderflowException.class, () -> {
            stack.pop();
            stack.pop();
            stack.top();
        });
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size());
        try {
            stack.push(1);
            stack.push(2);
        } catch (StackOverflowException e) {
            fail("StackOverflowException should not be thrown");
        }
        assertEquals(2, stack.size());
    }

    @Test
    void testPush() {
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
        } catch (StackOverflowException e) {
            fail("StackOverflowException should not be thrown");
        }
        assertThrows(StackOverflowException.class, () -> {
            stack.push(6);
        });
    }

    @Test
    void testToString() {
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
        } catch (StackOverflowException e) {
            fail("StackOverflowException should not be thrown");
        }
        assertEquals("321", stack.toString());
    }

    @Test
    void testToStringString() {
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
        } catch (StackOverflowException e) {
            fail("StackOverflowException should not be thrown");
        }
        assertEquals("3,2,1", stack.toString(","));
    }

    @Test
    void testFill() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            stack.fill(list);
        } catch (StackOverflowException e) {
            fail("StackOverflowException should not be thrown");
        }
        assertEquals("321", stack.toString());
        assertThrows(StackOverflowException.class, () -> {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(4);
            newList.add(5);
            newList.add(6);
            stack.fill(newList);
        });
    }
}