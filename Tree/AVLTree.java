package Tree;

public class AVLTree {
    private class Node{
        private int value;
        private Node left,right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private int height(Node node){
        return node==null ? -1: node.height;
    }
    private void setHeight(Node root) {
        root.height=Math.max(height(root.left), height(root.right))+1;
    }

    private int balanceFactor(Node node){
        return node==null ? 0 : height(node.left)-height(node.right);
    }
    private boolean isLeftHeavy(Node node){
        return balanceFactor(node)>1;
    }
    private boolean isRightHeavy(Node node){
        return balanceFactor(node)<-1;
    }

    private Node balance(Node node){
        // if left heavy have to rotate node to right for sure
        if(isLeftHeavy(node)){
            // if not balance in right subtree of left child then rotate leftchild left first
            if(balanceFactor(node.left)<0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // if right heavy have to rotate node to left for sure
        if(isRightHeavy(node)){
            // if not balance in left subtree of right child then rotate rightchild right first
            if(balanceFactor(node.left)>0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }
    private Node rotateRight(Node node) {
        //  make leftchild of node the new root
        Node newRoot= node.left;
        //  if newRoot have a existing right child then make it leftchild of old root
        node.left = newRoot.right;
        //  make the old root righchild of new root
        newRoot.right = node;
        //  reset heights of old root node and new root node
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }
    private Node rotateLeft(Node node) {
        //  make rightchild of node the new root
        Node newRoot= node.right;
        //  if newRoot have a existing left child then make it rightchild of old root
        node.right = newRoot.left;
        //  make the old root leftchild of new root
        newRoot.left = node;
        //  reset heights of old root node and new root node
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    public void insert(int item){
        this.root=insert(this.root,item);
    }
    private Node insert(Node root, int item) {
        if(root==null){
            return new Node(item);
        }
        if(item<root.value){
            root.left=insert(root.left,item);
        }
        if(item>root.value){
            root.right=insert(root.right,item);
        }
        setHeight(root);
        return balance(root);
    }

    public void print(){
        print(this.root);
    }
    private void print(Node root) {
        if(root==null)
            return;
        String output="";
        output+=root.value+" => ";
        if(root.left!=null)
            output+="Left "+root.left.value;
        if(root.right!=null)
            output+=", Right "+root.right.value;
        System.out.println(output);
        print(root.left);
        print(root.right);
    }
}
