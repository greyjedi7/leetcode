import java.math.BigInteger;
import java.util.Scanner;

public class prob1 {

    public String removeDigit(String number, char digit){
        
        BigInteger bigInteger = new BigInteger("0");
        BigInteger resultingString;

        for (int i=0;i<number.length();i++){
            if(digit == number.charAt(i)){
                resultingString = new BigInteger(number.substring(0,i) + number.substring(i+1,number.length()));

                bigInteger = resultingString.compareTo(bigInteger) > 0 ? resultingString : bigInteger; 
            }
        }
    
        return bigInteger.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        char digit = sc.next().charAt(0);
        sc.close();
        prob1 prob1 = new prob1();
        System.out.println(prob1.removeDigit(number, digit));
    }
}