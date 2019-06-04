package homelab.xinstudy.linkedList;
class LinkList{
    private Link first;

    public LinkList()
    {
        first = null;
    }
    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(long value)
    {
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
    }
    public long deleteFirst()
    {
        Link temp = first;
        first = first.next;
        return temp.dData;
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

class LinkStack{
    private LinkList theList;  //stack use normal linkList

    public LinkStack()
    {
        theList = new LinkList();
    }
    public void push(long value)
    {
        theList.insertFirst(value);
    }
    public long pop()
    {
        return theList.deleteFirst();
    }
    public boolean isEmpty()
    {
        return (theList.isEmpty());
    }
    public void displayStack()
    {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}
public class LinkStackApp {
    public static void main(String[] args)
    {
        LinkStack theStack = new LinkStack(); // make stack
        theStack.push(20); // push items
        theStack.push(40);
        theStack.displayStack(); // display stack
        theStack.push(60); // push items
        theStack.push(80);
        theStack.displayStack(); // display stack
        theStack.pop(); // pop items
        theStack.pop();
        theStack.displayStack(); // display stack
    } // end main()

}
