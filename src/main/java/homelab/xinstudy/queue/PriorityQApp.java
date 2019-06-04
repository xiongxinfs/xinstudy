package homelab.xinstudy.queue;

import java.io.IOException;

class PriorityQ{
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int size)
    {
        maxSize = size;
        queArray = new long[maxSize];
        nItems = 0;
    }
    public void insert(long value)
    {
        if(nItems == 0)                   //1 empty array
            queArray[nItems ++] = value;
        else                              //2 not empty, need to compare from front;the minimum key is in the end of array(front), the largest is in 0(rear)
        {
            int i;
            for(i = nItems -1; i >= 0; i--)  //start to check from front(highest index of array)
            {
                if (value > queArray[i])    //if insert value is larger go down in array
                    queArray[i+1] = queArray[i];
                else                       //find the place and stop
                    break;
            }
            queArray[i+1] = value;        //not the index i but next one!!!! otherwise replace the bigger one
            nItems++;
        }
    }
    public long remove()
    {
        return queArray[--nItems];
    }
    public long peekMin()
    {
        return queArray[nItems -1];
    }
    public boolean isEmpty()
    {
        return (nItems == 0);
    }
    public boolean isFull()
    {
        return (nItems == maxSize);
    }
}
public class PriorityQApp {
    public static void main(String[] args) throws IOException
    {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        while( !thePQ.isEmpty() )
        {
            long item = thePQ.remove();
            System.out.print(item + " "); // 10, 20, 30, 40, 50
        } // end while
        System.out.println(" ");
    } // end main()
//------------------------------
}
