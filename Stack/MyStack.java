package Stack;

public class MyStack {
    private int[] items;
    private int top=-1;

    public MyStack(int length){
        this.items= new int[length];
    }

    private void increaseCapacity(){
        System.out.println("Capacity increased");
        int[] newArray=new int[2*this.items.length];
        for(int i=0;i<this.items.length;i++) {
            newArray[i]=this.items[i];
        }
        this.items=newArray;
    }

    public boolean isEmpty(){
        return this.top==-1;
    }

    public boolean isFull(){
        return this.top==this.items.length-1;
    }

    public int size(){
        return this.top+1;
    }

    public int peek(){
        if(isEmpty()) throw new RuntimeException("Stack Underflow.");
        return this.items[top];
    }

    public int pop(){
        if(isEmpty()) throw new RuntimeException("Stack Underflow.");
        return this.items[top--];
    }

    public void push(int item){
        if(isFull()){
            increaseCapacity();
        }
        this.items[++top]=item;
    }

    public void print() {
        System.out.print("[");
        for(int i=0;i<=this.top;i++) {
            System.out.print(this.items[i]+" ");
        }
        System.out.print("]");
    }
}
