package Tree;

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
