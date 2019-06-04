package homelab.xinstudy.stack;

public class StackLong {
    private int maxSize;
    private long[] stackArrary;
    private int top;           //the top index!!

    public StackLong(int size)
    {
        maxSize = size;
        stackArrary = new long[maxSize];
        top = -1;
    }
    public void push(long value)
    {
        stackArrary[++top] = value;
    }
    public long pop ()
    {
        return stackArrary[top--];
    }
    public long peek()
    {
        return stackArrary[top];
    }
    public boolean isEmpty()
    {
        return (top == -1);
    }
    public boolean isFull()
    {
        return (top == maxSize -1 );
    }
}

class StackApp {
    public static void main(String[] args) {
        StackLong theStackLong = new StackLong(10); // make new stack
        theStackLong.push(20); // push items onto stack
        theStackLong.push(40);
        theStackLong.push(60);
        theStackLong.push(80);
        while (!theStackLong.isEmpty()) // until it’s empty,
        { // delete item from stack
            long value = theStackLong.pop();
            System.out.print(value); // display it
            System.out.print(" ");
        } // end while
        System.out.println("");
    } // end main()
}
