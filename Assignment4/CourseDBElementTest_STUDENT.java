import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBElementTest_STUDENT {

	private CourseDBElement element1;
    private CourseDBElement element2;
    private CourseDBElement element3;

    @BeforeEach
    void setUp() {
        element1 = new CourseDBElement("CS101", 12345, 4, "Room100", "Dr. Smith");
        element2 = new CourseDBElement("CS102", 67890, 3, "Room200", "Prof. Johnson");
        element3 = new CourseDBElement("CS101", 12345, 4, "Room100", "Dr. Smith"); 
    }

    @Test
    void testGettersAndSetters() {
        element1.setID("CS105");
        assertEquals("CS105", element1.getID());
        
        element1.setCRN(54321);
        assertEquals(54321, element1.getCRN());
        
        element1.setCredits(5);
        assertEquals(5, element1.getCredits());
        
        element1.setRoomNum("Room300");
        assertEquals("Room300", element1.getRoomNum());
        
        element1.setInstructor("Dr. Williams");
        assertEquals("Dr. Williams", element1.getInstructor());
    }

    @Test
    void testHashCode() {
        assertEquals(element1.hashCode(), element3.hashCode()); 
        assertNotEquals(element1.hashCode(), element2.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(element1, element3); 
        assertNotEquals(element1, element2); 
    }

    @Test
    void testToString() {
        String expected = "Course:CS101 CRN:12345 Credits:4 Instructor:Dr. Smith Room:Room100";
        assertEquals(expected, element1.toString());
    }

}
