package Tree;

    public int height(){
        return height(this.root);
    }
    private int height(Node root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right)) +1;
    }

