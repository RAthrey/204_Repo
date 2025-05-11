import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.io.*;

public class TownGraphManager_STUDENT_Test {
    private TownGraphManager manager;

    @Before
    public void setUp() {
        manager = new TownGraphManager();
        manager.addTown("A");
        manager.addTown("B");
        manager.addTown("C");
        manager.addRoad("A", "B", 5, "Road1");
        manager.addRoad("B", "C", 10, "Road2");
    }

    @Test
    public void testAddAndGetTown() {
        assertTrue(manager.containsTown("A"));
        assertNotNull(manager.getTown("A"));
        assertEquals("A", manager.getTown("A").getName());
    }

    @Test
    public void testAllTownsSorted() {
        ArrayList<String> towns = manager.allTowns();
        assertEquals(Arrays.asList("A", "B", "C"), towns);
    }

    @Test
    public void testShortestPath() {
        ArrayList<String> path = manager.getPath("A", "C");
        assertEquals(2, path.size());
        assertTrue(path.get(0).contains("Road1"));
        assertTrue(path.get(1).contains("Road2"));
    }

    @Test
    public void testDeleteRoadConnection() {
        assertTrue(manager.containsRoadConnection("A", "B"));
        assertTrue(manager.deleteRoadConnection("A", "B", "Road1"));
        assertFalse(manager.containsRoadConnection("A", "B"));
    }
}