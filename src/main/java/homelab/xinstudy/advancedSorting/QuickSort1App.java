package homelab.xinstudy.advancedSorting;
class ArrayIns {
    private long[] theArray;
    private int nElems;

    public ArrayIns(int maxSize) {
        theArray = new long[maxSize];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems++] = value;
    }

    public void display() // displays array contents
    {
        System.out.print("A= ");
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(theArray[j] + ","); // display it
        System.out.println("");
    }
    public void quickSort(){
        recQuickSort(0, nElems -1 );
    }
    private void recQuickSort (int left, int right)
    {
        if(right <= left)
            return;
        else
        {
            long pivot = theArray[right];  //1 take the right most as pivot
            int partition = partitionIt(left, right, pivot);  //2 partition 2 group, return pivot index
            recQuickSort(left, partition -1);   //3 rec sort left group excluding pivot
            recQuickSort(partition + 1, right);  //4 rec sort right group excluding pivot
        }
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;      //1 initialize 2 pointers
        int rightPtr = right ;  //no need to add 1 boz select rightmost item as pivot !!!

        while(true){
            while( theArray[++leftPtr] < pivot)  //2 stops when items in the left group bigger than pivot
                ;

            while(rightPtr > left && theArray[--rightPtr] >pivot)  //3 stops when items in the right group smaller than pivot
                ;

            if(leftPtr >= rightPtr)  //4 cross pivot, return
                break;
            else                     //5 swap items in the left and right groups
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);   //6 dont forget to put the pivot back!!!
        return leftPtr;    //pivot is in leftPtr
    }
    private void swap(int dex1, int dex2){
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

}

public class QuickSort1App {
    public static void main(String[] args){
        int maxSize = 16;
        ArrayIns arr = new ArrayIns(maxSize);

        for(int j=0; j < maxSize; j++){
            long n = (int)(java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort();
        arr.display();
    }
}
