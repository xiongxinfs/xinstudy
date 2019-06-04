package homelab.xinstudy.advancedSorting;
/*
shell sort is a insertioni sort with gap
* */
class ArraySh{
    private long[] theArray;
    private int nElems;

    public ArraySh(int maxSize){
        theArray = new long[maxSize];
        nElems = 0;
    }
    public void insert(long value){
        theArray[nElems++] = value;
    }
    public void display() // displays array contents
    {
        System.out.print(" ");
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(theArray[j] + ","); // display it
        System.out.println("");
    }
    public void shellSort(){
        int inner, outer;
        long temp;

        int h = 1;
        while(h <= nElems/3)
            h = h*3 +1;  //start from max gap

        while(h > 0){
            for(outer =h; outer < nElems; outer++)
            {
                temp = theArray[outer];
                inner = outer;

                while (inner > h-1 && theArray[inner - h] > temp)
                {
                    theArray[inner] = theArray[inner-h];
                    inner = inner -h;
                }
                theArray[inner] = temp;
            }
            h = (h - 1)/3;  //decrease the gap
        }
    }
}
public class ShellSortApp {
    public static void main(String[] args){
        int maxSize = 1000; // array size
        ArraySh arr;
        arr = new ArraySh(maxSize); // create the array
        for(int j=0; j<maxSize; j++) // fill array with
        { // random numbers
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display(); // display unsorted array
        arr.shellSort(); // shell sort the array
        arr.display();
    }
}
