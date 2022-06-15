public class Prob1 {
    
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int freq = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == letter){
                freq++;
            }
        }

        return (freq*100)/n;
    }

    public static void main(String[] args){
        System.out.println(new Prob1().percentageLetter("floot", 'o'));
    }

}
