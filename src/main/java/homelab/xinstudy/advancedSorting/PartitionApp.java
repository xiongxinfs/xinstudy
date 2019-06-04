package homelab.xinstudy.advancedSorting;
class ArrayPar {
    private long[] theArray;
    private int nElems;

    public ArrayPar(int maxSize) {
        theArray = new long[maxSize];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems++] = value;
    }

    public void display() // displays array contents
    {
        System.out.print(" ");
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(theArray[j] + ","); // display it
        System.out.println("");
    }
    public int size(){
        return nElems;
    }
    public int partition(int left, int right, long pivot){
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while(true){
            while(leftPtr < right && theArray[++leftPtr] < pivot)
                ;

            while(rightPtr > left && theArray[--rightPtr] > pivot)
                ;

            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }

        return leftPtr;
    }
    private void swap(int dex1, int dex2){
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
public class PartitionApp {
    public static void main(String[] args){
        int maxSize = 16;
        ArrayPar arr;
        arr = new ArrayPar(maxSize);

        for(int i =0 ; i < maxSize; i++){
            long n = (int) (java.lang.Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        long pivot = 99;
        System.out.print("Pivot is " + pivot);
        int size = arr.size();

        int partDex = arr.partition(0, size - 1, pivot);
        System.out.println(", Partition is at index " + partDex);
        arr.display();
    }
}
