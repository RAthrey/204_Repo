import static org.junit.jupiter.api.Assertions.*;

import java.io.File;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testConvertToEnglish() {
        String morse = "- .... .. ... / .. ... / .- / - . ... -";
        String expected = "this is a test";
        String actual = MorseCodeConverter.convertToEnglish(morse);
        assertEquals(expected, actual.toLowerCase());
    }

    @Test
    public void testHowDoILoveTheeFile() {
        try {
            File file = new File("howDoILoveThee.txt");
            String result = MorseCodeConverter.convertToEnglish(file);
            assertTrue(result.toLowerCase().contains("how do i love thee"));
        } catch (Exception e) {
            fail("File not found or error reading file");
        }
    }

    @Test
    public void testDaisyFile() {
        try {
            File file = new File("Daisy.txt");
            String result = MorseCodeConverter.convertToEnglish(file);
            assertTrue(result.toLowerCase().contains("give me your answer do"));
        } catch (Exception e) {
            fail("File not found or error reading file");
        }
    }

    @Test
    public void testDaisyDaisyFile() {
        try {
        	System.out.println(new File(".").getAbsolutePath());
            File file = new File("DaisyDaisy.txt");
            String result = MorseCodeConverter.convertToEnglish(file);
            assertTrue(result.toLowerCase().contains("im half crazy all for the love of you"));
        } catch (Exception e) {
            fail("File not found or error reading file");
        }
    }

    @Test
    public void testLoveLooksNotFile() {
        try {
            File file = new File("LoveLooksNot.txt");
            String result = MorseCodeConverter.convertToEnglish(file);
            assertTrue(result.toLowerCase().contains("love looks not with the eyes"));
        } catch (Exception e) {
            fail("File not found or error reading file");
        }
    }

    @Test
    public void testStudentFiles() {
        try {
            File file = new File("studentMorse.txt");
            String result = MorseCodeConverter.convertToEnglish(file);
            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e) {
            fail("File not found or error reading file");
        }
    }
}
