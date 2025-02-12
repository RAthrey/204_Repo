import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	@Before
	public void setUp() throws Exception{
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		String length = "a1!";
		String valid = "SecurePass123!";
		assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidPassword(length);
			}
		});
	    assertTrue(PasswordCheckerUtility.isValidPassword(valid));
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		String upper = "safe123pass";
		String valid = "SecurePass123!";
		assertThrows(NoUpperAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidPassword(upper);
			}
		});
	    assertTrue(PasswordCheckerUtility.isValidPassword(valid));
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		String lower = "SAFE123PASS";
		String valid = "SecurePass123!";
		assertThrows(NoLowerAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidPassword(lower);
			}
		});
	    assertTrue(PasswordCheckerUtility.isValidPassword(valid));
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		String weak = "Weak1!";
		String valid = "SecurePass123!";
		assertThrows(WeakPasswordException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isWeakPassword(weak);
			}
		});
	    assertTrue(PasswordCheckerUtility.isValidPassword(valid));
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		String sequence = "AAA11b1!!";
		String valid = "SecurePass123!";
	    assertTrue(PasswordCheckerUtility.isValidPassword(valid));
		assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidPassword(sequence);
			}
		});
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		String digit = "Safe@Pass";
		assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidPassword(digit);
			}
		});
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		String valid = "SecurePass123!";
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(valid));
		} catch (Exception e) {
			assertFalse("Threw an exception for a valid password", true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords = new ArrayList<>(Arrays.asList(
				"short",           
				"ABC123g",          
				"abc123!",         
				"AB@123",                  
				"aaa123!B"       
			));
			
			ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
			assertTrue(invalidPasswords.get(0).contains("characters"));
			assertTrue(invalidPasswords.get(1).contains("special"));
			assertTrue(invalidPasswords.get(2).contains("uppercase"));
			assertTrue(invalidPasswords.get(3).contains("lowercase"));
			assertTrue(invalidPasswords.get(4).contains("sequence"));
	}
}
