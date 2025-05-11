import static org.junit.Assert.*;
import org.junit.Test;

public class Road_STUDENT_Test {

    @Test
    public void testRoadEquality() {
        Town t1 = new Town("A");
        Town t2 = new Town("B");
        Road r1 = new Road(t1, t2, 10, "MainRoad");
        Road r2 = new Road(t2, t1, 10, "MainRoad");
        assertEquals(r1, r2);
    }

    @Test
    public void testRoadCompareToAndToString() {
        Town t1 = new Town("A");
        Town t2 = new Town("B");
        Road r1 = new Road(t1, t2, 10, "First");
        Road r2 = new Road(t1, t2, 5, "Second");
        assertTrue(r1.compareTo(r2) < 0);
        assertTrue(r1.toString().contains("First"));
    }

    @Test
    public void testRoadContains() {
        Town t1 = new Town("A");
        Town t2 = new Town("B");
        Road r = new Road(t1, t2, 5, "Connector");
        assertTrue(r.contains(t1));
        assertTrue(r.contains(t2));
    }
}
