public class Stek{
    int maxsize;
    int[] stkarr;
    int top=-1;
    public Stek(int size){
        this.maxsize = size;
        stkarr = new int[size];
    }
    public void push(int i){
        stkarr[++top]=i;
    }
    public int peek(){
        return stkarr[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public int pop(){
        return stkarr[top--];
    }
    public boolean isFull(){
        return top==maxsize-1;
    }
    public static void main(String [] args){
        Stek ob = new Stek(9);
        ob.push(10);
        ob.push(30);
        ob.push(40);
        ob.push(10);
        ob.push(30);
        ob.push(40);
        ob.push(10);
        ob.push(30);
        ob.push(40);
        while(!ob.isEmpty()){
            int val = ob.pop();
            System.out.println(val);
        }
    }
}
