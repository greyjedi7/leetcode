import java.util.Arrays;

public class Prob2 {
    

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int maxValue = special[0] - bottom;

        int n = special.length;

        for(int i=1;i<n;i++){
            int diff = special[i] - special[i-1] - 1;
            if(diff > maxValue){
                maxValue = diff;
            }
        }

        int diff = top - special[n-1];
        
        return (diff > maxValue) ? diff: maxValue;
        
    }


    public static void main(String[] args){
        System.out.println(new Prob2().maxConsecutive(6, 8, new int[]{7,6,8}));
    }

}
