package homelab.xinstudy.linkedList;

class LinkX
{
    public int iData;     //not using public
    public double dData;
    public LinkX next;

    public LinkX(int id, double dd)
    {
        iData = id;
        dData = dd;
    }
    public void displayLink()
    {
        System.out.print("{" + iData + ","  + dData + "} ");
    }
}

class LinkListX {
    private LinkX first;

    public LinkListX()
    {
        first = null;
    }
    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(int id, double dd)
    {
        LinkX newLinkX = new LinkX(id, dd);
        newLinkX.next = first;  //point to old first
        first = newLinkX;
    }
    public LinkX deleteFirst()
    {
        LinkX temp = first;
        first = first.next;
        return temp;
    }
    public LinkX find(int key)
    {
        LinkX current = first;
        while(current !=null && current.iData != key)
        {
            if(current.next == null )    //cant find it
                return null;
            else
                current = current.next;
        }
        return current;

    }
    public LinkX delete(int key)
    {
        LinkX current = first;
        LinkX previous = null;

        while(current.iData != key)
        {
            if(current.next == null)  //cant find it
                return null;
            else
            {
                previous = current;
                current = current.next;
            }
        }
        if(current == first)     //found it now delete :1 first
            first = first.next;
        else if(previous != null)  //found it: 2 middle or end
            previous.next = current.next;
        return current;

    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        LinkX current = first;
        while (current!= null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    public void insertAfter(int id, double dd)
    {

    }

}
class LinkListApp
{
    public static void main(String[] args)
    {
        LinkListX theList = new LinkListX(); // make new list
        theList.insertFirst(22, 2.99); // insert four items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList(); // display list
        while( !theList.isEmpty() ) // until it’s empty,
        {
            LinkX aLinkX = theList.deleteFirst(); // delete link
            System.out.print("Deleted "); // display it
            aLinkX.displayLink();
            System.out.println("");
        }
        theList.displayList(); // display list
    } // end main()
} // end class LinkListApp
////////////////////////////////////////////////////////////////

