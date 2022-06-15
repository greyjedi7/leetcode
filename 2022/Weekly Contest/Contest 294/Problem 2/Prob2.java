import java.util.Arrays;

public class Prob2 {

    public void print(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
    
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] diff = new int[n];

        for(int i=0;i<n;i++){
            diff[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(diff);
        int count = 0;

        for(int i=0;i<n;i++){
            if(diff[i] == 0){
                count++;
                continue;
            }
            int difference = additionalRocks - diff[i];
            if(difference >= 0){
                additionalRocks -= diff[i];
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args){
        System.out.println(new Prob2().maximumBags(
            new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
    }


}
