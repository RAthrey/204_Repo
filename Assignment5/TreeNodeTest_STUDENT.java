import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeTest_STUDENT {
	private TreeNode<String> node;
    private TreeNode<String> copiedNode;

    @BeforeEach
    void setUp() throws Exception {
    	node = new TreeNode<>("Morse");
        copiedNode = new TreeNode<>(node);
    }

    @AfterEach
    void tearDown() throws Exception {
    	node = null;
        copiedNode = null;
    }

    @Test // Test case for TreeNode(T dataNode) constructor
    void testTreeNodePassingData() {
    	TreeNode<String> newNode = new TreeNode<>("Code");
        assertNotNull(newNode);
        assertEquals("Code", newNode.getData());
        assertNull(newNode.left);
        assertNull(newNode.right);
    }

    @Test // Test case for TreeNode(TreeNode<T> node) constructor
    void testCopyTreeNode() {
    	assertNotNull(copiedNode);
        assertEquals("Morse", copiedNode.getData());
        assertEquals(node.left, copiedNode.left);
        assertEquals(node.right, copiedNode.right);
    }

    @Test
    void testGetData() {
    	assertEquals("Morse", node.getData());
    }

}
