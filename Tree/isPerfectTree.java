package Tree;

//	A perfect binary tree of height h has 2^(h + 1) – 1 node.
//	A perfect binary tree of height h has 2^h leaf nodes.
    public boolean isPerfectTree(){
        return isPerfectTree(this.root);
    }
    private boolean isPerfectTree(Node node) {
        if(node==null) return true;
        return Math.pow(2,height(node)+1) - 1 == size(node);
    }
    private int size(Node node) {
        if(root==null)
            return 0;
        return size(node.left)+size(node.right)+1;
    }
    private int height(Node node){
        return node==null ? -1: node.height;
    }
