package Trie;

    private void getWords(Node root, String word, ArrayList<String> a){
        if(root.isEndOfWord) a.add(word);
        for(Map.Entry<Character,Node> node: root.children.entrySet()){
            getWords(node.getValue(),word+ node.getValue().value,a);
        }
    }

    public ArrayList<String> autocomplete(String word){
        ArrayList<String> a = new ArrayList<>();
        if(this.wordCount==0) return a;
        Node current = this.root;
        for(Character c: word.toCharArray()){
            if(!current.children.containsKey(c))
                return  a;
            current=current.children.get(c);
        }
        getWords(current,word,a);
        return a;
    }

