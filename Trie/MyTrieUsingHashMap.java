package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyTrieUsingHashMap {
    private class Node{
        private char value;
        private HashMap<Character,Node> children;
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
            this.children=new HashMap<>();
        }
    }

    private Node root = new Node(' ');
    private int wordCount;

    public int getTotalWordCount(){
        return this.wordCount;
    }

    public void insert(String word){
        Node current = this.root;
        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c))
                current.children.put(c,new Node(c));
            current=current.children.get(c);
        }
        current.isEndOfWord=true;
        this.wordCount++;
    }

    public boolean find(String word){
        if(word==null) return false;
        Node current = this.root;
        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c))
                return false;
            current=current.children.get(c);
        }
        return current.isEndOfWord;
    }

    //  making isEndOfWord=false
    public void remove(String word){
        if(word==null) return;
        Node current = this.root;
        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c))
                return;
            current=current.children.get(c);
        }
        current.isEndOfWord=false;
        this.wordCount--;
    }

    //  post order traversal to remove nodes as well after marking isEndOfWord=false
    public void removeRecursive(String word){
        removeRecursive(this.root,word);
    }
    private void removeRecursive(Node root, String word) {
        if(word.isEmpty()){
            if(!root.isEndOfWord) return;
            root.isEndOfWord=false;
            this.wordCount--;
            return;
        }
        Node child = root.children.get(word.charAt(0));
        if(child==null) return;
        removeRecursive(child,word.substring(1));
        //  while coming back from recursion is child has no children and is not a endOfWord remove it
        if(child.children.isEmpty() && !child.isEndOfWord)
            root.children.remove(child.value);
    }

    public ArrayList<String> getWords(){
        ArrayList<String> a = new ArrayList<>();
        if(this.wordCount==0) return a;
        getWords(this.root,"",a);
        return a;
    }
    private void getWords(Node root, String word, ArrayList<String> a){
        if(root.isEndOfWord) a.add(word);
        for(Map.Entry<Character,Node> node: root.children.entrySet()){
            getWords(node.getValue(),word+ node.getValue().value,a);
        }
    }
}
