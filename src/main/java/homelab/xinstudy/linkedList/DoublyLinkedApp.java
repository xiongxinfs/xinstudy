package homelab.xinstudy.linkedList;

class LinkDouble
{
    public long dData;
    public LinkDouble next;
    public LinkDouble previous;

    public LinkDouble(long value)
    {
        dData = value;
    }
    public void displayLink()
    {
        System.out.print(dData + ",");
    }
}
class DoublyLinkedList{
    private LinkDouble first;
    private LinkDouble last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }
    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(long value)
    {
        LinkDouble newLink = new LinkDouble(value);

        if(isEmpty())   //always think about empty list!!
            last = newLink;
        else            //other case
            first.previous = newLink;
        newLink.next = first;   //all of the cases
        first = newLink;

    }
    public void insertLast(long value)
    {
        LinkDouble newLink = new LinkDouble(value);

        if(isEmpty())        ///empty list
            first = newLink;
        else {
            last.next = newLink;
            newLink.previous = last;    //can be put outside as last is null in empty case
        }
        last = newLink;
    }
    public LinkDouble deleteFirst()
    {
        LinkDouble temp = first;
        if(first.next == null)    //only one in the list
            last = null;
        else
            first.next.previous = null;
        first = first.next;        //in any cases, supposed it is non empty list (check isEmpty() before call the method)

        return temp;
    }
    public LinkDouble deleteLast()
    {
        LinkDouble temp = last;
        if(first.next == null)  //only one in list
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }
    public boolean insertAfter(long key, long value)
    {
        LinkDouble current = first;

        while (current.dData != key) {
            current = current.next;
            if (current == null)    //cant find key
                return false;
        }
        LinkDouble newLink = new LinkDouble(value);  //found the key so init new link

        if(current == last)   //found last as extreme case
        {
            newLink.next = null;   //no need, already did in initial!
            last = newLink;
        }
        else
        {
            current.next.previous = newLink;
            newLink.next = current.next;

        }
        newLink.previous = current;
        current.next = newLink;
        return true;

        /*if(isEmpty())  //wrong condition as no key found!!
        {
            first = newLink;
            last = newLink;
        }
        else {
            while (current.dData != key) {
                if (current.next == null)
                    break;
                current = current.next;
            }
            current.next.previous = newLink;
            newLink.next = current.next;
            current.next = newLink;
        }*/
    }

    public LinkDouble deleteKey(long key)
    {
        LinkDouble current = first;

        while(current.dData != key)
        {
            current = current.next;
            if(current == null)  //cant find it
                return null;
        }

        if(current == first)    //1found it first item
            first = current.next;
        else
            current.previous.next = current.next;

        if(current == last )  //2 found it last item
            last = current.previous;
        else
            current.next.previous = current.previous;

        return current;
    }

    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        LinkDouble current = first;

        while(current!= null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.print("");
    }
    public void displayBackward()
    {
        System.out.print("List (last-->first): ");
        LinkDouble current = last;

        while(current!= null)
        {
            current.displayLink();
            current = current.previous;
        }
        System.out.print("");
    }
}

public class DoublyLinkedApp {
    public static void main(String[] args)
    { // make a new list
        //delete and insertAfter need to be check isEmpty before called
        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayForward(); // display list forward
        theList.displayBackward(); // display list backward
        theList.deleteFirst(); // delete first item
        theList.deleteLast(); // delete last item
        theList.deleteKey(11); // delete item with key 11
        theList.displayForward(); // display list forward
        theList.insertAfter(22, 77); // insert 77 after 22
        theList.insertAfter(33, 88); // insert 88 after 33
        theList.displayForward(); // display list forward
    } // end main()
}
