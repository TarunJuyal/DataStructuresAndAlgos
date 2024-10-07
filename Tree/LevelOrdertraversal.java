package Tree;

    public int height(){
        return height(this.root);
    }
    private int height(Node root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right)) +1;
    }

    public ArrayList<Integer> printNodesAtKDistance(int k){
        ArrayList<Integer> a = new ArrayList<>();
        printNodesAtKDistance(this.root,k,a);
        return a;
    }
    private void printNodesAtKDistance(Node root, int k,ArrayList<Integer> a){
        if(root==null) return;
        if(k==0) {
            a.add(root.value);
            return;
        }
        printNodesAtKDistance(root.left,k-1,a);
        printNodesAtKDistance(root.right,k-1,a);
    }

    public void levelOrderTraversalUsingQueue(){
        Queue<Node> q=new LinkedList<>();
        levelOrderTraversalUsingQueue(this.root,q);
    }
    private void levelOrderTraversalUsingQueue(Node root, Queue<Node> q){
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.print(node.value+" ");
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }
    }


    public void levelOrderTraversalUsingNodeAtKDistanceAndHeight(){
        for (int i = 0; i < height(); i++) {
            System.out.print(printNodesAtKDistance(i));
        }
    }

