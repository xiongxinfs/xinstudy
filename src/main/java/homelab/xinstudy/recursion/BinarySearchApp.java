package homelab.xinstudy.recursion;

class OrderArray {
    private long[] a;
    private int nElems;

    public OrderArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public int size()
    {
        return nElems;
    }

    public int find(long searchKey)
    {
        return recFind(searchKey, 0, nElems - 1);
    }

    public int recFind(long searchKey, int lowBound, int upperBound)
    {
        int curInd;

        //while (true)   //1 start loop
        //{
            curInd = (lowBound + upperBound )/2;
            if (a[curInd] == searchKey) //2 found it
                return curInd;
            else if (lowBound > upperBound)  //3 not found to the end  or condition lowBound > upperBound
                return  nElems;
            else if (a[curInd] < searchKey) //4 go to upper part
                return recFind(searchKey, curInd + 1, upperBound);
                //lowBound = curInd + 1;
            else
                return recFind(searchKey, lowBound, curInd - 1);//5 go to lower part
                //upperBound = curInd -1;
        //}
    }

    public void insert (long value )
    {
        int i ;
        for ( i = 0 ; i < nElems ; i++)
            if (a[i] >= value) //1 found it
                break;

        for(int j = nElems; j > i; j--) //2 move bigger ones up
            a[j] = a [j-1];

        a[i] = value;  //3 insert
        nElems ++;    //4 size + 1
    }

    public boolean delete (long value)
    {
        int i ;
        for (i = 0 ; i < nElems ; i++)
            if (a[i] == value) //1 found it
                break;

        if (i == nElems -1)  // or not found it to the end
            return false;
        else
        {
            for(int j = i; j < nElems; j++)   //2 move bigger ones down
                a[j] = a [j + 1];
            nElems --;   //3 size -1
            return true;
        }

    }

    public void display()
    {
        for(int i = 0; i < nElems; i++)
            System.out.print(a[i] + ",");
    }
}

public class BinarySearchApp {
    public static void main(String[] args)
    {
        int maxSize = 100; // array size
        OrderArray arr; // reference to array
        arr = new OrderArray(maxSize); // create the array
        arr.insert(72); // insert items
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);
        arr.display(); // display array
        int searchKey = 27; // search for item
        if( arr.find(searchKey) != arr.size() )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can’t find " + searchKey);
    } // end main()
}
