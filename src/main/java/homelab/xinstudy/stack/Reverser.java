package homelab.xinstudy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class Reverser {
    private String input;
    private String output;

    public Reverser(String value)
    {
        input = value;
    }

    public String doRev()
    {
        int stackSize = input.length();
        StackChar theStack = new StackChar(stackSize);

        for(int i = 0; i < stackSize; i++)
        {
            char chr = input.charAt(i);
            theStack.push(chr);
        }
        output = "";
        while(!theStack.isEmpty())
        {
            output = output + theStack.pop();
        }
        return output;
    }
}
class ReverserApp{
    public static void main(String[] args) throws IOException
    {
        /*Reverser re = new Reverser("Hello");
        String output = re.doRev();
        System.out.println(output);
        */
        String input, output;
        while(true)
        {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();
            if( input.equals("") ) // quit if [Enter]
                break;

            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev(); // use it
            System.out.println("Reversed: " + output);
        }

    }
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------
}