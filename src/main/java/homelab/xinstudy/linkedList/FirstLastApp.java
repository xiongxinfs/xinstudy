package homelab.xinstudy.linkedList;

class Link
{
    public long dData;
    public Link next;

    public Link(long dd)
    {
        dData = dd;
        next = null; //no need
    }
    public void displayLink()
    {
        System.out.print("{" + dData + ","  + dData + "} ");
    }
}
class FirstLastList
{
    //double ended link list
    private Link first;
    private Link last;

    public FirstLastList()
    {
        first = null;
        last = null;
    }
    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(long value)
    {
        Link newLink = new Link(value);
        if(isEmpty())          //always thinks about empty list!!!
            last = newLink;
        newLink.next = first;  //link to old first
        first = newLink;  //new one becomes first
    }
    public void insertLast(long value)
    {
        Link newLink = new Link(value);
        if(isEmpty())              //always thinks about empty list!!!
            first = newLink;
        else
            last.next = newLink; //old last link to new one
        last = newLink;          //new one becomes last

    }
    public long deleteFirst()    //still not easy to delete last !!
    {
        long temp = first.dData;
        if(first.next == null)    //always thinks about only last one in the list!!!
            last = null;
        first = first.next;
        return temp;
    }
    public void displayLinkList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
public class FirstLastApp {
    public static void main(String[] args)
    { // make a new list
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayLinkList(); // display the list
        theList.deleteFirst(); // delete first two items
        theList.deleteFirst();
        theList.displayLinkList(); // display again
    } // end main()
}
