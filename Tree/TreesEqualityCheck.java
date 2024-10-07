package Tree;

    public boolean isEqual(MyTree other){
        return equals(this.root, other.root);
    }
    private boolean equals(Node first, Node second) {
        if(first ==  null && second ==  null) return true;
        if(first !=  null && second !=  null) return first.value==second.value
                                                    && equals(first.left,second.left)
                                                    && equals(first.right,second.right);
        return false;
    }
