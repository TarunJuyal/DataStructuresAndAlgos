package Arrays;

public class MyArray {
    private int[] items;
    private int size;

    public MyArray(int length){
        this.items= new int[length];
        this.size=0;
    }

    private void increaseCapacity(){
        System.out.println("Capacity increased");
        int[] newArray=new int[2*this.size];
        for(int i=0;i<this.size;i++) {
            newArray[i]=this.items[i];
        }
        this.items=newArray;
    }

    public void insert(int item){
        //  check if array full is so double size and copy
        if(items.length==this.size){
            increaseCapacity();
        }
        //  add item
        items[this.size++]=item;
    }

    public void insertAt(int index, int item){
        //  check if valid index
        if(index<0 || index>=this.size) throw new IllegalArgumentException();
        //  if valid index then check if array is full if so increase capacity
        increaseCapacity();
        //  if have to insert at last then insert
        if(index==this.size) {
            this.items[index]=item;
        }
        //  if insert at other than last shift all to right then insert
        else{
            for (int i = size; i >index ; i--) {
                this.items[i]=this.items[i-1];
            }
            this.items[index]=item;
        }
        this.size++;
    }

    public int indexOf(int item) {
        for(int i=0;i<this.size;i++) {
            if(items[i]==item)
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int removeAt(int index){
        //  check valid index
        if(index<0 || index>=this.size) throw new IllegalArgumentException();
        //  remove ie shift items to left and decrease size
        int removedItem = this.items[index];
        for (int i = index; i < size; i++) {
            this.items[i]=this.items[i+1];
        }
        this.size--;
        return removedItem;
    }

    public void print() {
        System.out.print("[");
        for(int i=0;i<this.size;i++) {
            System.out.print(this.items[i]+" ");
        }
        System.out.print("]");
    }
}
