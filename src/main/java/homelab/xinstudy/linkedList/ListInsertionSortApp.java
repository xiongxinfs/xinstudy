package homelab.xinstudy.linkedList;
/*starts with an array of
unsorted items of type link, inserts them into a sorted list (using a constructor), and
then removes them and places them back into the array*/


public class ListInsertionSortApp {
    public static void main(String[] args)
    {
        int size = 10;

        Link[] linkArray = new Link[size];

        for(int i = 0; i < size; i++)  // 1 fill array
        {
            int n = (int)(Math.random()*99);
            Link newLink = new Link(n);
            linkArray[i] = newLink;
        }
        System.out.print("Unsorted array: ");
        for(int j=0; j<size; j++)
            System.out.print( linkArray[j].dData + "," );
        System.out.println("");

        SortedList theSortedList = new SortedList(linkArray); //2 put the array into sorted List(sorted inside)

        for(int i =0; i < size; i++)  //3 Put it back to the array
            linkArray[i] = theSortedList.remove();

        System.out.print("Sorted Array: ");
        for(int j=0; j<size; j++)
            System.out.print(linkArray[j].dData + ",");
        System.out.println("");

    }
}
