import java.util.ArrayList;


public class MorseCodeTree implements ConverterTreeInterface<String> {
	
	private TreeNode<String> root; 
	
	public MorseCodeTree() {
        root = null;
        buildTree();
    }
	
	@Override
	public TreeNode getRoot() {
		return root; 
	}

	@Override
	public void setRoot(TreeNode newNode) {
		root = newNode; 
		
	}

	public void addNode(String code, String letter) {
	    addNode(root, code, letter);
	}
	
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.isEmpty()) {
			root.data = letter; 
			return; 
		}
        if (code.charAt(0) == '.') {
            if (root.left == null) {
            	root.left = new TreeNode<>("");
            }
            addNode(root.left, code.substring(1), letter);
        } else {
            if (root.right == null) {
            	root.right = new TreeNode<>("");
            }
            addNode(root.right, code.substring(1), letter);
        }
    }

	@Override
	public void buildTree() {
		root = new TreeNode<>("");
		addNode("", ""); 
		addNode(".", "e"); 
		addNode("-", "t"); 
		addNode("..", "i"); 
		addNode(".-", "a"); 
		addNode("-.", "n"); 
		addNode("--", "m"); 
		addNode("...", "s"); 
		addNode("..-", "u"); 
		addNode(".-.", "r"); 
		addNode(".--", "w"); 
		addNode("-..", "d"); 
		addNode("-.-", "k"); 
		addNode("--.", "g"); 
		addNode("---", "o"); 
		addNode("....", "h"); 
		addNode("...-", "v"); 
		addNode("..-.", "f"); 
		addNode(".-..", "l"); 
		addNode(".--.", "p"); 
		addNode(".---", "j"); 
		addNode("-...", "b"); 
		addNode("-..-", "x"); 
		addNode("-.-.", "c"); 
		addNode("-.--", "y"); 
		addNode("--..", "z"); 
		addNode("--.-", "q"); 
	}

	@Override
	public String fetchLetter(TreeNode<String> root, String code) {
		if (code.length() == 0) {
			return root.getData();
		}
        if (code.charAt(0) == '.') {
        	return fetchLetter(root.left, code.substring(1));
        }
        else {
        	return fetchLetter(root.right, code.substring(1));
        }
	}
	
	@Override
	public ArrayList toArrayList() {
		ArrayList<String> arrayList = new ArrayList<>(); 
		traverseInOrder(root, arrayList); 
		return arrayList; 
	}

	@Override
	public String printTree() {
		ArrayList<String> arrayList = toArrayList();
        String result = "";
        for (int i = 0; i < arrayList.size(); i++) {
            result += arrayList.get(i);
            if (i < arrayList.size() - 1) {
                result += " ";
            }
        }
        return result;
	}

	@Override
	public void traverseInOrder(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
            traverseInOrder(root.left, list);
            if (!root.getData().equals("")) {
            	list.add(root.getData());
            }
            traverseInOrder(root.right, list);
        }
		
	}

}