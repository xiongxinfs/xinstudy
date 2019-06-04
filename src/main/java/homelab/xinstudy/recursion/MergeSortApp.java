package homelab.xinstudy.recursion;
class DArray{
    private long[] theArray;
    private int nElems;

    public DArray(int max){
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems] = value;
        nElems ++;
    }
    public void display() // displays array contents
    {
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(theArray[j] + " "); // display it
        System.out.println("");
    }
    public void mergeSort() // called by main(), can be omitted
    { // provides workspace
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems-1);
    }
    private void recMergeSort(long[] workSpace, int lowBound, int upperBound){
        if(lowBound == upperBound)
            return;
        else{
            int mid = (lowBound + upperBound)/2;
            recMergeSort(workSpace, lowBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowBound, mid + 1, upperBound);

        }
    }
    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound)
    {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr -1;
        int n = upperBound - lowerBound + 1;

        while(lowPtr <= mid && highPtr <= upperBound){
            if(theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }
        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];

        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        for(int i = 0; i < n; i++)   //need to copy back to theArray from lowBound
            theArray[ lowerBound+i] = workSpace[i];
    }
}

public class MergeSortApp {
    public static void main(String[] args){
        int maxSize = 100; // array size
        DArray arr; // reference to array
        arr = new DArray(maxSize); // create the array
        arr.insert(64); // insert items
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);
        arr.display(); // display items
        arr.mergeSort(); // merge sort the array
        arr.display();
    }
}
