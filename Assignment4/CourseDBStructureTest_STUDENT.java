import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBStructureTest {
    private CourseDBStructure cds;

    @BeforeEach
    void setUp() throws Exception {
        cds = new CourseDBStructure(10);
    }

    @AfterEach
    void tearDown() throws Exception {
        cds = null;
    }

    @Test
    void testCourseDBStructureStringInt() {
        CourseDBStructure testStructure = new CourseDBStructure("Test", 20);
        assertEquals(20, testStructure.getTableSize());
    }

    @Test
    void testCourseDBStructureInt() {
        CourseDBStructure testStructure = new CourseDBStructure(30);
        assertTrue(testStructure.getTableSize() > 0);
    }

    @Test
    void testAdd() {
        CourseDBElement element = new CourseDBElement("CS101", 12345, 3, "Room100", "Dr. Smith");
        cds.add(element);
        try {
            assertEquals(element, cds.get(12345));
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testShowAll() {
        CourseDBElement element1 = new CourseDBElement("CS101", 12345, 3, "Room100", "Dr. Smith");
        CourseDBElement element2 = new CourseDBElement("CS102", 67890, 4, "Room200", "Dr. Johnson");
        cds.add(element1);
        cds.add(element2);
        ArrayList<String> courses = cds.showAll();
        assertEquals(2, courses.size());
        assertTrue(courses.contains(element1.toString()));
        assertTrue(courses.contains(element2.toString()));
    }

    @Test
    void testGet() {
        CourseDBElement element = new CourseDBElement("CS101", 12345, 3, "Room100", "Dr. Smith");
        cds.add(element);
        try {
            assertEquals(element, cds.get(12345));
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testGetTableSize() {
        assertEquals(7, cds.getTableSize()); 
    }

    @Test
    void testGet4KPrime() {
        assertEquals(7, CourseDBStructure.get4KPrime(5));
        assertEquals(11, CourseDBStructure.get4KPrime(8));
    }
}
