import java.util.ArrayList;

public class PasswordCheckerUtility {
	/**
    * Compares two passwords and throws an exception if they do not match.
    * 
    * @param password The original password.
    * @param passwordConfirm The password to compare against.
    * @throws UnmatchedException if the passwords do not match.
    */
	public static void comparePasswords​(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException("Passwords do not match");
        }
	}
	/**
     * Compares two passwords and returns true if they match.
     * 
     * @param password The original password.
     * @param passwordConfirm The password to compare against.
     * @return true if the passwords match, false otherwise.
     */
	public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm) {
		if(!password.equals(passwordConfirm)) {
			return false;
		}
		return true;
	}
	/**
     * Checks if the password is longer than 6 characters.
     * 
     * @param password The password to check.
     * @return true if the password length is valid.
     * @throws LengthException if the password is too short.
     */
	public static boolean isValidLength​(String password) throws LengthException {
		if (password.length()>=6) {
			return true;
		}
		throw new LengthException();
	}
	/**
     * Checks if the password contains at least one uppercase letter.
     * 
     * @param password The password to check.
     * @return true if the password contains an uppercase letter.
     * @throws NoUpperAlphaException if the password has no uppercase letter.
     */
	public static boolean hasUpperAlpha​(String password) throws NoUpperAlphaException {
		for (int i=0;i<password.length();i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	/**
     * Checks if the password contains at least one lowercase letter.
     * 
     * @param password The password to check.
     * @return true if the password contains a lowercase letter.
     * @throws NoLowerAlphaException if the password has no lowercase letter.
     */
	public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException {
		for (int i=0;i<password.length();i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	/**
     * Checks if the password contains at least one digit.
     * 
     * @param password The password to check.
     * @return true if the password contains a digit.
     * @throws NoDigitException if the password has no digits.
     */
	public static boolean hasDigit(String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	/**
     * Checks if the password contains at least one special character.
     * 
     * @param password The password to check.
     * @return true if the password contains a special character.
     * @throws NoSpecialCharacterException if the password lacks a special character.
     */
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException {
		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) >= 32 && password.charAt(i) <= 47) || (password.charAt(i) >= 58 && password.charAt(i) <= 64) || (password.charAt(i) >= 91 && password.charAt(i) <= 96) || password.charAt(i) >= 123 && password.charAt(i) <= 126) {
				return true;
			}
		}
		throw new NoSpecialCharacterException();
	}
	/**
     * Checks if the password contains three or more of the same consecutive character.
     * 
     * @param password The password to check.
     * @return true if no sequence of three repeating characters exists.
     * @throws InvalidSequenceException if there are three repeating characters in a row.
     */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
	    for (int i = 0; i < password.length() - 2; i++) {
	        if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
	            throw new InvalidSequenceException();
	        }
	    }
	    return true;
	}
	 /**
     * Checks if a password is valid based on all defined password rules.
     * 
     * @param password The password to check.
     * @return true if the password meets all security requirements.
     * @throws LengthException If the password is too short.
     * @throws NoUpperAlphaException If the password lacks an uppercase letter.
     * @throws NoLowerAlphaException If the password lacks a lowercase letter.
     * @throws NoDigitException If the password lacks a digit.
     * @throws NoSpecialCharacterException If the password lacks a special character.
     * @throws InvalidSequenceException If the password has three repeating characters in a row.
     */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		if (isValidLength​(password) && hasUpperAlpha​(password) && hasLowerAlpha​(password) && hasDigit(password) && hasSpecialChar​(password) && NoSameCharInSequence(password)) {
			return true;
		} else {
			return false;
		}
	}
	/**
     * Checks if the password length is between 6 and 9 characters.
     * 
     * @param password The password to check.
     * @return true if the password length is within the specified range.
     */
	public static boolean hasBetweenSixandNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		} else {
			return false;
		}
	}
	/**
     * Determines if a password is weak.
     * A weak password meets all requirements but has a length between 6 and 9 characters.
     * 
     * @param password The password to check.
     * @return false if the password is strong.
     * @throws WeakPasswordException If the password is considered weak.
     */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		try {
			isValidPassword(password);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		if (hasBetweenSixandNineChars(password)) {
			throw new WeakPasswordException();
		} else {
			return false;
		}
	}
	/**
     * Returns a list of invalid passwords along with the reason they failed.
     * 
     * @param passwords The list of passwords to check.
     * @return A list of invalid passwords with their respective error messages.
     */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
	    ArrayList<String> invalidPasswords = new ArrayList<>();
	    for (int i = 0; i < passwords.size(); i++) {
	        try {
	            isValidPassword(passwords.get(i));
	        } catch (RuntimeException e) {
	            invalidPasswords.add(passwords.get(i)+ " " + e.getMessage());
	        }
	    }
	    return invalidPasswords;
	}

}
