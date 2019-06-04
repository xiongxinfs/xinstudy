package homelab.xinstudy.array;

public class OrderArray {
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
        int lowBound = 0;
        int upperBound = nElems -1;
        int curInd;

        while (true)   //1 start loop
        {
            curInd = (lowBound + upperBound )/2;
            if (a[curInd] == searchKey) //2 found it
                return curInd;
            else if (curInd == nElems)  //3 not found to the end  or condition lowBound > upperBound
                return  curInd;
            else if (a[curInd] < searchKey) //4 go to upper part
                lowBound = curInd + 1;
            else                            //5 go to lower part
                upperBound = curInd -1;
        }
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
