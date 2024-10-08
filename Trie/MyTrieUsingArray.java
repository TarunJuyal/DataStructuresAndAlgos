package Trie;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyTrieUsingArray {
    private static int ALPHABET_SIZE=26;

    private class Node{
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }
    }

    private Node root = new Node(' ');
    private int wordCount=0;

    public int getTotalWordCount(){
        return this.wordCount;
    }

    //  only for lowercase
    public void insert(String word){
        Node current = this.root;
        for(char c : word.toCharArray()){
            int index=c-'a';
            if(current.children[index]==null)
                current.children[index]=new Node(c);
            current=current.children[index];
        }
        current.isEndOfWord=true;
        this.wordCount++;
    }

    //  only for lowercase
    public boolean find(String word){
        if(word==null) return false;
        Node current = this.root;
        for(char c : word.toCharArray()){
            int index=c-'a';
            if(current.children[index]==null)
                return false;
            current=current.children[index];
        }
        return current.isEndOfWord;
    }

    //  only for lowercase
    /*  could remove from memory as well the nodes but extra effort
    and as array is anyways initialized just did wordCount-- and 
    isEndOfWord=false; */
    public void remove(String word){
        if(word==null) return;
        Node current = this.root;
        for(char c : word.toCharArray()){
            int index=c-'a';
            if(current.children[index]==null)
                throw new NoSuchElementException();
            current=current.children[index];
        }
        current.isEndOfWord=false;
        this.wordCount--;
    }

    public ArrayList<String> getWords(){
        ArrayList<String> a = new ArrayList<>();
        if(this.wordCount==0) return a;
        getWords(this.root,"",a);
        return a;
    }
    private void getWords(Node root, String word, ArrayList<String> a){
        if(root.isEndOfWord) a.add(word);
        for(Node node: root.children){
            if(node!=null)
                getWords(node,word+ node.value,a);
        }
    }
}
