import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testEvaluatePostfixExpression() {
        try {
            assertEquals(20.0, Notation.evaluatePostfixExpression("23+4*"));
            assertEquals(4.0, Notation.evaluatePostfixExpression("82/"));
            assertEquals(7.0, Notation.evaluatePostfixExpression("123*+"));
            assertEquals(2.8, Notation.evaluatePostfixExpression("234*+5/"));
        } catch (InvalidNotationFormatException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testConvertPostfixToInfix() {
        try {
            assertEquals("((2+3)*4)", Notation.convertPostfixToInfix("23+4*"));
            assertEquals("(8/2)", Notation.convertPostfixToInfix("82/"));
            assertEquals("(1+(2*3))", Notation.convertPostfixToInfix("123*+"));
            assertEquals("((2+(3*4))/5)", Notation.convertPostfixToInfix("234*+5/"));
        } catch (InvalidNotationFormatException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testConvertInfixToPostfix() {
        try {
            assertEquals("23+4*", Notation.convertInfixToPostfix("(2+3)*4"));
            assertEquals("82/", Notation.convertInfixToPostfix("8/2"));
            assertEquals("123*+", Notation.convertInfixToPostfix("1+2*3"));
            assertEquals("234*+5/", Notation.convertInfixToPostfix("(2+3*4)/5"));
        } catch (InvalidNotationFormatException e) {
            fail("Exception should not be thrown");
        }
    }
}