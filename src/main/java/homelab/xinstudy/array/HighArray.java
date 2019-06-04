package homelab.xinstudy.array;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray (int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey)
    {
        int i;
        for(i = 0; i < nElems; i++)
        {
            if(a[i] == searchKey)  break;
        }
        if(i == nElems)
            return false;
        else
            return true;
    }

    public int binarySearch(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems -1 ;
        int curInd = 0;

        while(true) {
            curInd = (lowerBound + upperBound) / 2;
            if (a[curInd] == searchKey)
                return curInd;
            else if (curInd == nElems)
                return nElems;
            else if (a[curInd] < searchKey) {
                //lowerBound = 0;
                lowerBound = curInd + 1 ;
            } else //if (a[curInd] > a[curInd + 1]// {
            {
                upperBound = curInd - 1;
                //upperBound = nElems - 1;
            }
        }
        //return nElems;
    }

    public void insert(long value)
    {
        a[nElems] = value;
        nElems ++;
    }

    public boolean delete(long value)
    {
        int i;
        for (i = 0; i < nElems; i++)
        {
            if (a[i] == value)
                break;
        }
        if (i == nElems)
            return false;
        else
        {
            for(int j = i; j < nElems ; j++)
            {
                a[j] = a[j+1];
            }
            nElems --;
            return true;
        }
    }

    public void display()
    {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + ",");
        System.out.print(".");
    }


}
