package homelab.codetest;

import java.util.HashMap;

public class OddOccurrencesInArray {
    public static void main(String[] args){
        int[] A = {9,3,9,3,9,7,9};
        System.out.println(solution(A));
    }
    static private int solution(int[] A)
    {
        int odd = 0;
        Integer result;
        HashMap mapTable = new HashMap<Integer, Integer>();
        for (int i: A) {
            if(mapTable.containsKey(i))
                mapTable.remove(i);
            else
                mapTable.put(i, i);
        }
        if(! mapTable.isEmpty()) {
            odd = (Integer) mapTable.keySet().toArray()[0];
        }
        return odd;
    }
}
