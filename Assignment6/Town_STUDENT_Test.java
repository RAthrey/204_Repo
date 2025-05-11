import static org.junit.Assert.*;
import org.junit.Test;

public class Town_STUDENT_Test {

    @Test
    public void testEqualsAndCompareTo() {
        Town a = new Town("Alpha");
        Town b = new Town("Alpha");
        Town c = new Town("Beta");
        assertEquals(a, b);
        assertNotEquals(a, c);
        assertTrue(a.compareTo(b) == 0);
        assertTrue(a.compareTo(c) < 0);
    }

    @Test
    public void testToStringAndHashCode() {
        Town a = new Town("TestTown");
        assertEquals("TestTown", a.toString());
        assertEquals("TestTown".hashCode(), a.hashCode());
    }
}