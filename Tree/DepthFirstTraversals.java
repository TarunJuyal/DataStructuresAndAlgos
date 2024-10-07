package Tree;


    //  Root,Left,Right
    public void traversePreOrder(){
        traversePreOrder(this.root);
    }
    private void traversePreOrder(Node root){
        if(root==null) return;
        System.out.print(root.value+" ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    //  Left,Root,Right
    public void traverseInOrder(){
        traverseInOrder(this.root);
    }
    private void traverseInOrder(Node root){
        if(root==null) return;
        traverseInOrder(root.left);
        System.out.print(root.value+" ");
        traverseInOrder(root.right);
    }

    //  Left,Right,root
    public void traversePostOrder(){
        traversePostOrder(this.root);
    }
    private void traversePostOrder(Node root){
        if(root==null) return;
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.value+" ");
    }
