import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.ListIterator;

class SortedDoubleLinkedListTest_STUDENT {
    private SortedDoubleLinkedList<Integer> sortedList;
    private Comparator<Integer> comparator;

    @BeforeEach
    void setUp() throws Exception {
        comparator = Integer::compare;
        sortedList = new SortedDoubleLinkedList<>(comparator);
    }

    @AfterEach
    void tearDown() throws Exception {
        sortedList = null;
    }

    @Test
    void testAdd() {
        sortedList.add(5);
        sortedList.add(1);
        sortedList.add(3);
        sortedList.add(2);
        sortedList.add(4);
        ListIterator<Integer> iterator = sortedList.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(5, iterator.next());
    }

    @Test
    void testRemove() {
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(5);
        assertNotNull(sortedList.remove(3, comparator));
        ListIterator<Integer> iterator = sortedList.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(5, iterator.next());
    }

    @Test
    void testIterator() {
        sortedList.add(10);
        sortedList.add(20);
        sortedList.add(30);
        ListIterator<Integer> iterator = sortedList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(30, iterator.next());
        assertFalse(iterator.hasNext());
    }
}
