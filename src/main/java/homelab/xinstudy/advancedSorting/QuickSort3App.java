package homelab.xinstudy.advancedSorting;

class ArrayIns3 {
    private long[] theArray; // ref to array theArray
    private int nElems; // number of data items

    //--------------------------------------------------------------
    public ArrayIns3(int max) // constructor
    {
        theArray = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value) // put element into array
    {
        theArray[nElems] = value; // insert it
        nElems++; // increment size
    }

    //--------------------------------------------------------------
    public void display() // displays array contents
    {
        System.out.print("A =");
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(theArray[j] + " "); // display it
        System.out.println("");
    }
    public void quickSort(){
        recQuickSort(0, nElems -1);
    }
    public void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if(size < 10)
            insertionSort(left, right);
        else{
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition -1);
            recQuickSort(partition + 1, right);
        }

    }
    private long medianOf3(int left, int right){
        int center = (left + right)/2;

        if(theArray[left] > theArray[center])  //1 compare begin, end and middle
            swap(left, center);

        if(theArray[left] > theArray[right])
            swap(left, right);

        if(theArray[right] < theArray[center])
            swap(right, center);
        swap(center, right -1);  //2 put the pivot in right -1, as right is already sorted
        return theArray[right -1];
    }
    private void swap(int dex1, int dex2){
        long temp = theArray[dex1]; // A into temp
        theArray[dex1] = theArray[dex2]; // B into A
        theArray[dex2] = temp; // temp into B
    }
    private int partitionIt(int left, int right, long median) {
        int leftPtr = left;  //not (left -1) boz we want to start from left + 1
        int rightPtr = right - 1;  //need to be right -1 as start from left of pivot(right -1)

        while (true){
            while(theArray[++leftPtr] < median);
            while(theArray[--rightPtr] > median);
            if(leftPtr >= rightPtr)  //cross line then stop
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right -1);  //move pivot to middle
        return leftPtr;
    }
    private void insertionSort(int left, int right){
        int in, out;

        for(out = left + 1; out <= right; out++){  //start from left+1!!!
            long temp = theArray[out];
            in = out;

            while(in > left && theArray[in -1] < temp){
                theArray[in] = theArray[in -1];
                --in;
            }
            theArray[in] = temp;
        }
    }
}

public class QuickSort3App {
    public static void main(String[] args){
        int maxSize = 16; // array size
        ArrayIns arr; // reference to array
        arr = new ArrayIns(maxSize);

        for(int j=0; j<maxSize; j++) // fill array with
        { // random numbers
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display(); // display items
        arr.quickSort(); // quicksort them
        arr.display();
    }
}
