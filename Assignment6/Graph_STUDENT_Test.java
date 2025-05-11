import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class Graph_STUDENT_Test {
    private Graph graph;
    private Town t1, t2, t3;
    private Road r1, r2;

    @Before
    public void setUp() {
        graph = new Graph();
        t1 = new Town("A");
        t2 = new Town("B");
        t3 = new Town("C");
        graph.addVertex(t1);
        graph.addVertex(t2);
        graph.addVertex(t3);
        graph.addEdge(t1, t2, 3, "R1");
        graph.addEdge(t2, t3, 4, "R2");
    }

    @Test
    public void testAddEdgeAndVertex() {
        assertTrue(graph.containsVertex(t1));
        assertTrue(graph.containsEdge(t1, t2));
    }

    @Test
    public void testRemoveVertexAndEdge() {
        graph.removeVertex(t3);
        assertFalse(graph.containsVertex(t3));
        assertNull(graph.getEdge(t2, t3));
    }

    @Test
    public void testDijkstraShortestPath() {
        ArrayList<String> path = graph.shortestPath(t1, t3);
        assertEquals(2, path.size());
    }
}