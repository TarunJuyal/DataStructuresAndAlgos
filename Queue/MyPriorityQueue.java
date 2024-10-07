package Queue;

public class MyPriorityQueue {
    private int[] items;
    private int front,size;

    public MyPriorityQueue(int length){
        this.items = new int[length];
        this.size=0;
        this.front=0;
    }

    private void increaseCapacity(){
        System.out.println("Capacity increased");
        int[] newArray=new int[2*this.size];
        for(int i=0;i<this.size;i++) {
            newArray[i]=this.items[i];
        }
        this.items=newArray;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public boolean isFull(){
        return this.size==this.items.length;
    }

    public void add(int item){
        if(isFull()) increaseCapacity();
        int i;
        for (i = this.size-1; i >=0 && this.items[i]>item ; i--) {
            this.items[i+1]=this.items[i];
        }
        this.items[i+1]=item;
        this.size++;
    }

    public int remove(){
        if(isEmpty()) throw new IllegalStateException();
        return this.items[front++];
    }

    public void print() {
        System.out.print("[");
        for(int i=this.front;i<this.size;i++) {
            System.out.print(this.items[i]+" ");
        }
        System.out.print("]");
    }
}
