public class Prob1 {
    

    public String largestGoodInteger(String num){

        int maxStringValue = 0;
        String maxString = null;


        for(int i=2;i<num.length();i++){
            if(num.charAt(i-2) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i)){;
                int value = num.charAt(i-2) + num.charAt(i-1) + num.charAt(i);
                if(value > maxStringValue){
                    maxString = num.substring(i-2, i+1);
                    maxStringValue = value;
                }
            }
        }

        return maxString == null ? "" : maxString;

    }

    public static void main(String[] args){
        String num = "6777133339";
        System.out.println(new Prob1().largestGoodInteger(num));
    }

}
