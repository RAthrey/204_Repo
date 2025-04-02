import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JUnit test for CourseDBManager
 */
class CourseDBManagerTest_STUDENT {

    private CourseDBManager manager;

    @BeforeEach
    void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    @AfterEach
    void tearDown() throws Exception {
        manager = null;
    }

    @Test
    void testAdd() {
        manager.add("CMSC204", 12345, 4, "SC450", "Dr. Smith");
        assertDoesNotThrow(() -> manager.get(12345));
    }

    @Test
    void testShowAll() {
        manager.add("CMSC204", 12345, 4, "SC450", "Dr. Smith");
        manager.add("CMSC203", 67890, 3, "SC451", "Dr. Jones");
        ArrayList<String> courses = manager.showAll();
        assertEquals(2, courses.size());
    }

    @Test
    void testReadFile() {
        try {
            File testFile = new File("test_input.txt");
            FileWriter writer = new FileWriter(testFile);
            writer.write("CMSC204 12345 4 SC450 Dr. Smith\n");
            writer.write("CMSC203 67890 3 SC451 Dr. Jones\n");
            writer.close();
            
            manager.readFile(testFile);
            
            assertDoesNotThrow(() -> manager.get(12345));
            assertDoesNotThrow(() -> manager.get(67890));
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }
    }

    @Test
    void testGet() {
        manager.add("CMSC204", 12345, 4, "SC450", "Dr. Smith");
        CourseDBElement element = manager.get(12345);
        assertEquals("CMSC204", element.getID());
        assertEquals(4, element.getCredits());
    }
}