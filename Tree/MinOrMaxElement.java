package Tree;

    public int getMinBST(){
        if(root==null) return -1;
        return getMinBST(this.root);
    }
    private int getMinBST(Node root){
        if(root.left==null)
            return root.value;
        return getMinBST(root.left);
    }

    public int getMaxBST(){
        if(root==null) return -1;
        return getMaxBST(this.root);
    }
    private int getMaxBST(Node root){
        if(root.right==null)
            return root.value;
        return getMaxBST(root.right);
    }

    //  for all BT not just BST
    public int min(){
        return min(this.root);
    }
    private int min(Node root){
        if(root==null) return -1;
        if(root.left==null && root.right==null) return root.value;
        return Math.min(root.value,Math.min(min(root.left),min(root.right)));
    }
