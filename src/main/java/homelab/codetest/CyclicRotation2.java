package homelab.codetest;

public class CyclicRotation2 {
    public static void main(String[] args){
        int[] A = {};
        int K = 4;
        int[] result = solution(A, K);
        for(int i : result)
            System.out.println(i);
    }
    static private int[] solution(int[] A, int K){
        if(A == null || A.length == 0)
            return A;

        int temp;
        for (int i = 0; i < K; i++){
            temp = A[A.length -1];
            for(int j = A.length -1; j >0; j--){
                A[j] = A[j-1];
            }
            A[0] = temp;
        }
        return A;
    }
}
