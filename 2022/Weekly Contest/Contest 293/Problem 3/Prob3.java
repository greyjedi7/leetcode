public class Prob3 {


    public int largestCombination(int[] candidates) {
        
        int n = candidates.length;

        int maxLength = 0;

        for(int i=0;i<24;i++){
            int count=0;
            for(int j=0;j<n;j++){

                int value = candidates[j] >> i;
                if(value % 2 == 1){
                    count++;
                }
            }
            if(count > maxLength){
                maxLength = count;
            }
        }

        return maxLength;
    }


    public static void main(String[] args){
        // new Prob3().largestCombination(new int[]{16,17,71,62,12,24,14})
        System.out.println(new Prob3().largestCombination(new int[]{16,17,71,62,12,24,14}));
    }

}
