public class TreeNode<T> {
    protected T data;
    protected TreeNode<T> left, right;

    public TreeNode(T dataNode) {
        data=dataNode;
        left = null;
        right = null;
    }

    public TreeNode(TreeNode<T> node) {
        this.data=node.data;
        this.left = node.left;
        this.right = node.right;
    }

    public T getData() {
        return data;
    }

}
