package homelab.xinstudy.stack;
import java.io.*;

/*
class StackChar {
    private int maxSize;
    private char[] stackArrary;
    private int top;           //the top index!!

    public StackChar(int size)
    {
        maxSize = size;
        stackArrary = new char[maxSize];
        top = -1;
    }
    public void push(char value)
    {
        stackArrary[++top] = value;
    }
    public char pop ()
    {
        return stackArrary[top--];
    }
    public char peek()
    {
        return stackArrary[top];
    }
    public boolean isEmpty()
    {
        return (top == -1);
    }
    public boolean isFull()
    {
        return (top == maxSize -1 );
    }
}
*/
class BracketChecker{
    private String input;

    public BracketChecker(String value)
    {
        input = value;
    }
    public void check()
    {
        int stackSize = input.length();
        StackChar theStack = new StackChar(stackSize);

        for(int i = 0; i < stackSize; i++)
        {
            char chr = input.charAt(i);
            switch (chr)
            {
                case '{':
                case '[':
                case '(':
                    theStack.push(chr);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!theStack.isEmpty())
                    {
                        char chx = theStack.pop();
                        if ( (chr == '{' && chx != '}') ||
                                (chr == '[' && chx != ']' ) ||
                                (chr == '(' && chx != ')' ))
                            System.out.println("Error: "+ chr + "at "+ i);  //not maching

                    }
                    else
                        System.out.println("Error: "+ chr + "at "+ i);   //mising left delimiter
                    break;
                default:
                    break;
            }
        }
        if(!theStack.isEmpty())
            System.out.println("Error: missing right delimiter");
    }
}

public class BracketApp {
    public static void main(String[] args) throws IOException
    {
        String input;
        while(true)
        {
            System.out.print(
                    "Enter string containing delimiters: ");
            System.out.flush();
            input = getString(); // read a string from kbd
            if( input.equals("") ) // quit if [Enter]
                break;
// make a BracketChecker
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check(); // check brackets
        } // end while
    } // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------

}
