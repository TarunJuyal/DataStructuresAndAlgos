package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    private class Node{
        private int value;
        private Node left,right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insertBST(int item){
        this.root=insertBST(this.root,item);
    }
    private Node insertBST(Node root, int item){
        if(root==null){
            root= new Node(item);
            return root;
        }
        if(item<root.value)
            root.left=insertBST(root.left,item);
        else if(item>root.value)
            root.right=insertBST(root.right,item);
        return root;
    }

    public boolean findBST(int item){
        return findBST(this.root,item);
    }
    private boolean findBST(Node root, int item){
        if(root==null){
            return false;
        }
        if(root.value==item){
            return true;
        }
        if(item<root.value)
            return findBST(root.left,item);
        else
            return findBST(root.right,item);
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
