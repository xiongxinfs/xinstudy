package homelab.xinstudy.queue;

 class QueueLong {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueLong(int size)
    {
        maxSize = size;
        queArray = new long[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insert (long value)
    {
        if(rear == maxSize -1 )  //if rear reach the end of array, reset it
            rear = -1;
        queArray[++rear] = value;  //add more item in array, so increase
        nItems++;
    }
    public long remove()
    {
        long value = queArray[front++];  //front moving towards rear, so increase index in array
        if(front == maxSize)             //if front reach the end of array, reset it
            front = 0;
        nItems --;
        return value;

    }
    public long peekFront()
    {
        return queArray[front];
    }
    public boolean isEmpty()
    {
        return (nItems == 0);
    }
    public boolean isFull()
    {
        return (nItems == maxSize);
    }
    public int size()
    {
        return nItems;
    }
}
class QueueApp
{
    public static void main(String[] args)
    {
        QueueLong theQueue = new QueueLong(5); // queue holds 5 items
        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.remove(); // remove 3 items
        theQueue.remove(); // (10, 20, 30)
        theQueue.remove();
        theQueue.insert(50); // insert 4 more items
        theQueue.insert(60); // (wraps around)
        theQueue.insert(70);
        theQueue.insert(80);
        while( !theQueue.isEmpty() ) // remove and display
        { // all items
            long n = theQueue.remove(); // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print("");
        }
        System.out.println("");
    } // end main()
} // end class QueueApp
