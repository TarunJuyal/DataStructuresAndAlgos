package Queue;

import java.util.Arrays;

public class MyQueue {
    private int[] items;
    private int front, rear,size;

    public MyQueue(int length){
        this.items = new int[length];
        this.front=this.rear=-1;
        this.size=0;
    }

    public boolean isEmpty(){
        return this.front==-1;
    }

    public boolean isFull(){
        return this.size==this.items.length;
    }

    public int size(){
        return this.size;
    }


    public void enqueue(int item){
        //  if full error
        if(isFull()) throw new RuntimeException("Queue is Full");
        // if empty make both 0 and enter number
        if(isEmpty()) {
            this.front=this.rear=0;
            this.items[this.rear++]=item;
        }
        //  if rear is past last array length make it 0
        else if(this.rear==this.items.length) {
            this.rear = 0;
            this.items[this.rear]=item;
        }
        //  if none of the above just increment and enter
        else this.items[this.rear++]=item;
        this.size++;
    }

    public int dequeue(){
        // if empty error
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        int removed = this.items[this.front];
        this.items[this.front]=0;
        //  if only one then set both to -1
        if(this.front==this.rear) this.front=this.rear=-1;
        //  if front is end of array make it 0
        if(this.front==this.items.length-1) this.front=0;
        //  if none of the condition increment front
        else this.front++;
        this.size--;
        return removed;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.items);
    }
}
