import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest_STUDENT {

    MorseCodeTree tree;

    @BeforeEach
    void setUp() throws Exception {
        tree = new MorseCodeTree();
        tree.buildTree();
    }

    @AfterEach
    void tearDown() throws Exception {
        tree = null;
    }

    @Test
    void testGetRoot() {
        assertNotNull(tree.getRoot());
        assertEquals("", tree.getRoot().getData());
    }

    @Test
    void testSetRoot() {
        TreeNode<String> newRoot = new TreeNode<>("ROOT");
        tree.setRoot(newRoot);
        assertEquals("ROOT", tree.getRoot().getData());
    }

    @Test
    void testAddNodePassingRoot() {
        TreeNode<String> newTree = new TreeNode<>("");
        tree.addNode(newTree, ".", "E");
        assertEquals("E", newTree.left.getData());
    }

    @Test
    void testBuildTree() {
        // Check a few known values from the Morse code tree
        assertEquals("e", tree.fetchLetter(tree.getRoot(), "."));
        assertEquals("t", tree.fetchLetter(tree.getRoot(), "-"));
        assertEquals("i", tree.fetchLetter(tree.getRoot(), ".."));
        assertEquals("m", tree.fetchLetter(tree.getRoot(), "--"));
        assertEquals("s", tree.fetchLetter(tree.getRoot(), "..."));
    }

    @Test
    void testFetchLetter() {
        assertEquals("h", tree.fetchLetter(tree.getRoot(), "...."));
        assertEquals("o", tree.fetchLetter(tree.getRoot(), "---"));
        assertEquals("g", tree.fetchLetter(tree.getRoot(), "--."));
    }

    @Test
    void testToArrayList() {
        ArrayList<String> list = tree.toArrayList();
        assertNotNull(list);
        assertTrue(list.contains("h"));
        assertTrue(list.contains("s"));
        assertTrue(list.contains("v"));
        assertTrue(list.contains("e"));
        assertTrue(list.contains("t"));
    }

    @Test
    void testPrintTree() {
        String result = tree.printTree().trim();
        assertTrue(result.startsWith("h s v"));
        assertTrue(result.contains("e"));
        assertTrue(result.endsWith("q m o"));
    }
}
