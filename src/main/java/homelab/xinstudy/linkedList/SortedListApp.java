package homelab.xinstudy.linkedList;
class SortedList{
    private Link first;

    public SortedList()
    {
        first = null;
    }
    public SortedList(Link[] linkArray )
    {
        first = null;
        for(int i =0; i < linkArray.length; i++)
            insert(linkArray[i]);

    }
    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insert(long key)
    {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while(current != null && key > current.dData) //need to keep the condition current != null , otherwise never ended!!!
        {
            previous = current;
            current = current.next;
        }
        if (previous == null)  //empty list
            first = newLink;
        else   // at the begin, end or middle of list case, previous would not be null
            previous.next = newLink;

        newLink.next = current;  //whatever case
    }
    public void insert(Link newLink)
    {
        Link previous = null;
        Link current = first;

        while(current != null && newLink.dData > current.dData)
        {
            previous = current;
            current = current.next;
        }
        if(previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }
    public Link remove()   //deleteFirst
    {
        Link temp = first;
        first = first.next;
        return temp;
    }
    public void displayList()
    {
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
public class SortedListApp {
    public static void main(String[] args)
    { // create new list
        SortedList theSortedList = new SortedList();
        theSortedList.insert(20); // insert 2 items
        theSortedList.insert(40);
        theSortedList.displayList(); // display list
        theSortedList.insert(10); // insert 3 more items
        theSortedList.insert(30);
        theSortedList.insert(50);
        theSortedList.displayList(); // display list
        theSortedList.remove(); // remove an item
        theSortedList.displayList(); // display list
    } // end main()
}
