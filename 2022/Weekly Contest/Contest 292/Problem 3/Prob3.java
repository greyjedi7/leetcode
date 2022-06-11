public class Prob3 {
    
    public int countTexts(String pressedKeys){
        int []dp = new int[pressedKeys.length()+1];

        int mod = 1000000007;

        dp[0]=1;
        for(int i=1;i<=pressedKeys.length();i++){
            dp[i] = dp[i-1];

            if(i>=2 && pressedKeys.charAt(i-2) == pressedKeys.charAt(i-1)){
                dp[i] = (dp[i] + dp[i-2]) % mod;
            } else {
                continue;  
            }

            if(i>=3 && pressedKeys.charAt(i-3) == pressedKeys.charAt(i-1)) {
                dp[i] = (dp[i] + dp[i-3]) % mod;
            } else {
                continue;
            }

            if(i>=4 && (pressedKeys.charAt(i-1) == '7' || pressedKeys.charAt(i-1) == '9') && pressedKeys.charAt(i-4) == pressedKeys.charAt(i-1)) {
                dp[i] = (dp[i] + dp[i-4]) % mod;
            }
        }

        return dp[pressedKeys.length()] % mod;

    }

    public static void main(String[] args){
        String pressedKeys = "335566";
        Prob3 prob3 = new Prob3();
        System.out.println(prob3.countTexts(pressedKeys));
    }

}
