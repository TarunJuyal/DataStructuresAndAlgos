package LinkedList;

import java.util.NoSuchElementException;

public class MyLinkedList {
    //  a private node class
    private class Node{
        private int value;
        private Node next;
        public Node(int item){
            this.value=item;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void print(){
        Node temp = head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.print("]");
    }

    public boolean isEmpty(){
        return this.head==null;
    }

    public int size(){
        return this.size;
    }

    public void addLast(int item){
        //  create node
        Node node = new Node(item);
        //  if list empty put head and tail = new node
        if(this.isEmpty()){
            head=tail=node;
        }
        //  if not empty then new node will be tail.next and move tail to next
        else{
            tail.next=node;
            tail=node;
        }
        size++;
    }

    public void addFirst(int item){
        //  create node
        Node node = new Node(item);
        //  if list empty put head and tail = new node
        if(this.isEmpty()){
            head=tail=node;
        }
        //  if not empty then newNode.next will be head, then head will be newNode
        else{
            node.next=head;
            head=node;
        }
        size++;
    }

    public void add(int index, int item){
        //  check if valid index
        if(index<0 || index>size) throw new IllegalArgumentException("Invalid Index");
        //  check if index =  0. insert at beginning
        if(index==0) addFirst(item);
        //  check if index = size. insert at last
        else if(index==size) addLast(item);
        //  find the index and insert in middle
        else {
            Node node = new Node(item);
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            node.next=temp.next;
            temp.next=node;
            size++;
        }
    }

    public int removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException("Empty List");
        Node removedNode=head;
        //  if list has 1 element put head and tail = null
        if(head==tail){
            head=tail=null;
        }
        //  if not then traverse till tail is next and make it null and move tail to new last value
        else{
            head=head.next;
            removedNode.next=null;
        }
        size--;
        return removedNode.value;
    }

    public int removeLast(){
        if(isEmpty())
            throw new NoSuchElementException("Empty List");
        int removedValue=tail.value;
        //  if list has 1 element put head and tail = null
        if(head==tail){
            head=tail=null;
        }
        //  if not then traverse till tail is next and make it null and move tail to new last value
        else{
            Node temp = head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            tail=temp;
            tail.next=null;
        }
        size--;
        return removedValue;
    }

    public int remove(int index){
        Node removedNode;
        //  check if valid index
        if(index<0 || index>=size) throw new IllegalArgumentException("Invalid Index");
        if(isEmpty())
            throw new NoSuchElementException("Empty List");
        //  check if index =  0. remove from front
        if(index==0) return removeFirst();
        //  check if index = size. remove from last
        else if(index==size-1) return removeLast();
        //  find the index and insert in middle
        else{
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            removedNode=temp.next;
            temp.next=temp.next.next;
            size--;
            return removedNode.value;
        }
    }

    public int indexOf(int item) {
        if(isEmpty())
            return -1;
        int index=0;
        Node temp=head;
        while(temp!=null) {
            if(temp.value==item)
                return index;
            temp=temp.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item)!=-1;
    }
}
