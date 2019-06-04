package homelab.codetest;
import java.util.ArrayList;
import java.util.List;

public class PermMissingElem {
    public static void main(String[] args){
        int[] A = {2,3,1,5};
        System.out.println(solution(A));
    }
    static private int solution(int[] A)
    {
        long totalSum = 0;
        long n = A.length + 1;
        long expectedSum = n * (n + 1)/2;
        for(int i : A)
            totalSum += i;

        return (int) (expectedSum - totalSum);
    }
}
