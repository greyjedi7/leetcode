import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob1 {

    public String anagramPattern(String string){
        
        int[] count = new int[26];

        int n = string.length();

        for(int i=0;i<n;i++){
            count[string.charAt(i)-'a']++;
        }
        
        String result = "";

        for(int i=0;i<26;i++){
            if(count[i] > 0){
                result +=  (char)(i+'a') + String.valueOf(count[i]);
            }
        }

        return result;
    }

    
    public List<String> removeAnagrams(String[] words) {

        List<String> list = new ArrayList<>();

        int n = words.length;

        String prevAnagramPattern = anagramPattern(words[0]);
        list.add(words[0]);
        for(int i=1;i<n;i++){
            String currentAnagramPattern = anagramPattern(words[i]);

            if(prevAnagramPattern.equals(currentAnagramPattern)){
                prevAnagramPattern = currentAnagramPattern;
                continue;
            }

            prevAnagramPattern = currentAnagramPattern;
            list.add(words[i]);
        }
        
        return list;
    }

    public static void main(String[] args){
        String[] words = new String[]{"abba","baba","bbaa","cd","cd"};
        System.out.println(new Prob1().removeAnagrams(words));
    }

}
