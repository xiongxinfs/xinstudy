package homelab.xinstudy.recursion;

import java.io.*;

import static homelab.xinstudy.recursion.StackTriangleApp.getInt;

class Stack{
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int s){
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void push(int value){
        stackArray[++top] = value;
    }
    public int pop(){
        return stackArray[top--];
    }
    public int peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
}

public class StackTriangle2App {
    static int theNumber;
    static int theAnswer;
    static Stack theStack;

    public static void main(String[] args) throws IOException
    {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        stackTriangle();
        System.out.println("Triangle="+theAnswer);
    } // end main()

    private static void stackTriangle() {
        theStack = new Stack(1000);

        theAnswer = 0;

        while(theNumber > 0){
            theStack.push(theNumber);
            --theNumber;
        }
        while(!theStack.isEmpty()){
            int newN = theStack.pop();
            theAnswer += newN;
        }
    }
}
