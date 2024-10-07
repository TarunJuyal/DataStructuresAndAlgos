package Tree;
    public boolean isValidBST(){
        return isValidBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isValidBST(Node root, int Min, int Max){
        if(root==null) return true;
        return (root.value< Max && root.value > Min)
                && isValidBST(root.left,Min,root.value)
                && isValidBST(root.right,root.value,Max);
    }
