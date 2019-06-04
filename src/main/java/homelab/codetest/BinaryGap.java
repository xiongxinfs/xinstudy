package homelab.codetest;

public class BinaryGap {
    public static void main(String[] args){
        int gap = solution(66561);
        System.out.println(gap);
    }
    static private int solution(int N)
    {
        int gap = 0;
        int count = 0;
        boolean isGap = false;

        String binaryString = Integer.toBinaryString(N);
        for(int i = 0; i < binaryString.length(); i++)
        {
            char temp = binaryString.charAt(i);
            if(temp == '1' && isGap == false)
                isGap = true;
            else if(temp == '0' && isGap == true)
                count++;
            else if (temp == '1' && isGap == true)
            {
                if(count > gap)
                    gap = count;
                count = 0;
            }

        }
        return gap;
    }
}
