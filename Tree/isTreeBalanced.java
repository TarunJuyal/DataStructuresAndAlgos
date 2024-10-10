package Tree;

public boolean isBalanced(){
        return isBalanced(this.root);
    }
private boolean isBalanced(Node node) {
        if(node==null) return true;
        return Math.abs(balanceFactor(node)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }
