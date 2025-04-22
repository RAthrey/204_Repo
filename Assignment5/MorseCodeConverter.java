import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {

    // Static instance of the tree (shared across calls)
    private static MorseCodeTree morseCodeTree = new MorseCodeTree();

    /**
     * Converts a full line of Morse code (letters separated by spaces, words by '/')
     * into English using the MorseCodeTree.
     * 
     * @param code Morse code string
     * @return translated English string
     */
    @SuppressWarnings("unchecked")
	public static String convertToEnglish(String code) {
        String result = "";
        String[] words = code.trim().split(" / ");  

        for (int i = 0; i < words.length; i++) {
            String[] letters = words[i].trim().split(" ");
            for (String letter : letters) {
                result += morseCodeTree.fetchLetter(morseCodeTree.getRoot(), letter);
            }
            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    /**
     * Converts Morse code from a file to English.
     * 
     * @param codeFile file containing Morse code
     * @return translated English string
     * @throws FileNotFoundException if file cannot be found
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
    	Scanner scanner = new Scanner(codeFile);
        String morseCode = "";

        while (scanner.hasNextLine()) {
            morseCode += scanner.nextLine() + " ";
        }
        scanner.close();

        return convertToEnglish(morseCode.trim());
    }

    /**
     * Returns all characters in the MorseCodeTree in LNR (in-order) traversal,
     * separated by a space.
     * 
     * @return in-order traversal of the MorseCodeTree
     */
    public static String printTree() {
        return morseCodeTree.printTree();
    }
}
