package homelab.xinstudy.linkedList;

class LinkQueue{
    private FirstLastList theList; //queue use FirstLastList

    public LinkQueue()
    {
        theList = new FirstLastList();
    }
    public boolean isEmpty()
    {
        return (theList.isEmpty());
    }
    public void insert (long value)
    {
        theList.insertLast(value);  //not using inserFirst otherwise become statck
    }
    public long remove ()
    {
        return theList.deleteFirst();
    }
    public void displayQueue()
    {
        System.out.print("Queue (front-->rear): ");
        theList.displayLinkList();
    }

}
public class LinkQueueApp {
    public static void main(String[] args)
    {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20); // insert items
        theQueue.insert(40);
        theQueue.displayQueue(); // display queue
        theQueue.insert(60); // insert items
        theQueue.insert(80);
        theQueue.displayQueue(); // display queue
        theQueue.remove(); // remove items
        theQueue.remove();
        theQueue.displayQueue(); // display queue
    } // end main()
}
