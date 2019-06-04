package homelab.xinstudy.advancedSorting;
class ArrayIns2{
    private long[] theArray;
    private int nElems;

    public ArrayIns2(int maxSize){
        theArray = new long[maxSize];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems++] = value;
    }
    public void display() // displays array contents
    {
        System.out.print("A=");
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(theArray[j] + " " ); // display it
        System.out.println("");
    }
    public void quickSort(){
        recQuickSort(0, nElems -1);
    }
    private void recQuickSort(int left, int right){
        int size = right - left + 1;  //1 get size

        if(size <= 3)
            manualSoft(left, right);  //2 manual sort if smaller than 3
        else
        {
            long median = medianOf3(left, right);  //3 otherwise get median
            int partition = partitionIt(left, right, median);  //4 get pivot
            recQuickSort(left, partition -1);  //5 sort left group
            recQuickSort(partition + 1, right);  //6 sort right group
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

    private void manualSoft(int left, int right) {
        int size = right -left + 1;

        if(size <= 1)   // no sort for 1 element
            return;
        else if (size == 2){    //compare 2 element
            if(theArray[left] > theArray[right])
                swap(left, right);
            return;
        }
        else{  //compare 3 elements
            if(theArray[left] > theArray[right -1])  //1 compare begin, end and middle
                swap(left, right -1);

            if(theArray[left] > theArray[right])
                swap(left, right);

            if(theArray[right] < theArray[right -1])
                swap(right, right -1);
        }
    }
}

public class QuickSort2App {
    public static void main(String[] args){
        int maxSize = 16;
        ArrayIns2 arr = new ArrayIns2(maxSize);

        for(int j=0; j < maxSize; j++){
            long n = (int)(java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort();
        arr.display();
    }
}
