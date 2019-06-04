package homelab.xinstudy.simpleSorting;

class ArraySort
{
    private long[] a;
    private int nElems;

    public ArraySort(int maxSize)
    {
        a = new long[maxSize];
        nElems = 0;
    }
    public void insert(long value)
    {
        a[nElems] = value;
        nElems ++;
    }
    public void display()
    {
        for(int i = 0; i < nElems; i++)
            System.out.print(a[i] + ",");
        System.out.println(" ");
    }
    public void bubbleSort()
    {
        int in, out;

        for(out = nElems -1 ; out > 1; out--)  //1 out loop go backward
            for(in = 0; in < out; in ++)       //2 in loop go forward, but each time get shorter
                if(a[in] > a[in +1])           //3 if lower  bigger than upper, swap
                  swap(in, in + 1);


        /*for(int i =0; i < nElems; i++)
        {
            for(int j = 0; j < nElems - i; i++)
            {
                if (a[j] < a[i])
                {
                    long temp = a[j];
                    a[j] = a [i];
                    a [i] = temp;
                }
            }
        }
        */
    }
    public void selectionSort()
    {
        int min = 0;
        for(int out = 0; out < nElems -1; out ++) {     //1 out loop end with the second last one(as the last one is compared with second last one in inloop)
            min = out;                                  //2 min always need to reset as the start of outloop, not the min in last loop!!
            for (int in = out + 1; in < nElems; in++) {  //3 in loop start from the next one of outloop
                if (a[in] < a[min])                      //4 if current value is smaller then recorded in min
                    min = in;
            }
            swap(out, min);
        }
    }
    public void insertionSort()
    {
        int in, out;
        //long marked;

        for(out = 1; out < nElems; out++)        //1 out loop start from second one(as you need to compare with the first one)
        {
            //int marked = out;  can't use the index as the array is shifting so have to use value!!!
            long marked = a[out];                     //2 marked the value of the out loop, reset every out loop pass
            in = out;                            //3 in loop start from the left of out, going backward
            while(in > 0 && a[in -1 ] >= marked)  //4 compare the values of in loop with the marked value
            {                                    // if it is bigger than marked, shift in loop forward, until marked value is bigger than the rest of in loop
                a[in] = a[in -1] ;
                in--;
            }
            a[in] = marked;                     //5 insert the marked value, as empty space comes out after shifting
        }
    }
    private void swap (int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;

    }


}

class SortApp {
    public static void main(String[] args)
    {
        int maxSize = 100; // array size
        ArraySort arr; // reference to array
        arr = new ArraySort(maxSize); // create the array
        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // display items
        //arr.bubbleSort(); // bubble sort them
        //arr.selectionSort();
        arr.insertionSort();

        arr.display();
    }
}
