import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedListTest_STUDENT {
    private BasicDoubleLinkedList<Integer> list;

    @BeforeEach
    void setUp() throws Exception {
        list = new BasicDoubleLinkedList<>();
    }

    @AfterEach
    void tearDown() throws Exception {
        list = null;
    }

    @Test
    void testGetSize() {
        assertEquals(0, list.getSize());
        list.addToEnd(1);
        assertEquals(1, list.getSize());
        list.addToFront(2);
        assertEquals(2, list.getSize());
    }

    @Test
    void testAddToEnd() {
        list.addToEnd(5);
        assertEquals(5, list.getLast());
        list.addToEnd(10);
        assertEquals(10, list.getLast());
    }

    @Test
    void testAddToFront() {
        list.addToFront(3);
        assertEquals(3, list.getFirst());
        list.addToFront(7);
        assertEquals(7, list.getFirst());
    }

    @Test
    void testGetFirst() {
        assertNull(list.getFirst());
        list.addToFront(4);
        assertEquals(4, list.getFirst());
        list.addToFront(9);
        assertEquals(9, list.getFirst());
    }

    @Test
    void testGetLast() {
        assertNull(list.getLast());
        list.addToEnd(8);
        assertEquals(8, list.getLast());
        list.addToEnd(2);
        assertEquals(2, list.getLast());
    }

    @Test
    void testIterator() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        ListIterator<Integer> iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(1, iter.next());
        assertEquals(2, iter.next());
        assertEquals(3, iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    void testRemove() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        list.remove(2, Integer::compare);
        assertEquals(2, list.getSize());
        assertEquals(1, list.getFirst());
        assertEquals(3, list.getLast());
    }

    @Test
    void testRetrieveFirstElement() {
        list.addToEnd(10);
        list.addToEnd(20);
        assertEquals(10, list.retrieveFirstElement());
        assertEquals(20, list.getFirst());
    }

    @Test
    void testRetrieveLastElement() {
        list.addToEnd(15);
        list.addToEnd(25);
        assertEquals(25, list.retrieveLastElement());
        assertEquals(15, list.getLast());
    }

    @Test
    void testToArrayList() {
        list.addToEnd(100);
        list.addToEnd(200);
        list.addToEnd(300);
        ArrayList<Integer> arrayList = list.toArrayList();
        assertEquals(3, arrayList.size());
        assertEquals(100, arrayList.get(0));
        assertEquals(200, arrayList.get(1));
        assertEquals(300, arrayList.get(2));
    }
}