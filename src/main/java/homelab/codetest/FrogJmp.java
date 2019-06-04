package homelab.codetest;

public class FrogJmp {
    public static void main(String[] args){
        int X = 10, Y = 85, D = 30;
        System.out.println(solution(X,Y,D));
    }
    static private int solution(int X, int Y, int D){
        double result = 0;
        result = Math.ceil((Y - X) / (double) D );
        return (int)result;
    }
}
