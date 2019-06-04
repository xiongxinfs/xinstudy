package homelab.codetest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedList;

public class CyclicRotation {
    public static void main(String[] args){
        int[] A = {1, 2, 3, 5, 1};
        int K = 3;
        int[] result = solution(A, K);
        for(int i : result)
        System.out.println(i);
    }
    static private int[] solution(int[] A, int K){
        //List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        //List<Integer> list = new LinkedList<Integer>(Arrays.asList(A));
        if(A == null || A.length == 0)
            return null;

        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i : A)
            list.add(i);

        for (int i = 0; i < K; i++){
            Integer temp = list.getLast();
            list.remove(temp);
            list.addFirst(temp);
        }
        A = list.stream().mapToInt(i -> i).toArray();
        return  A;

    }
}
