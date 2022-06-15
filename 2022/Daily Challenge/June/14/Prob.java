public class Prob {
    

    public int minDistance(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        return (n1 - dp[n1][n2])+(n2 - dp[n1][n2]);
    }

    public static void main(String[] argS){
        String word1 = "leetcode";
        String word2 = "etco";

        System.out.println(new Prob().minDistance(word1, word2));
    }

}
