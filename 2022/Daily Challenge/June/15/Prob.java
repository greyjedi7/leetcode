import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Prob {

    public int longestStrChain(String[] words) {
        int n = words.length;
        String[][] lengthWise = new String[16][n];
        int[] count = new int[16];
        Map<String, Integer> hashMap = new HashMap<>();

        for(int i=0;i<n;i++){
            hashMap.put(words[i],1);
        }
        
        for(int i=0;i<n;i++){
            int len = words[i].length();
            lengthWise[len-1][count[len-1]++] = words[i];
        }

        int maxLength = 0;

        for(int i=0;i<15;i++){
            for(int j=0;j<count[i];j++){
                
                String a,b;

                for(int k=0;k<count[i+1];k++){
                    a = lengthWise[i][j];
                    b = lengthWise[i+1][k];
                    int diff = 0;
                    int w1 = 0, w2 = 0;
                    int len1 = a.length();
                    int len2 = b.length();
                    while(w1 < len1 && w2 < len2){
                        if(a.charAt(w1) != b.charAt(w2)){
                            diff++;
                            w2++;
                        } else {
                            w1++;
                            w2++;
                        }
                        if(diff > 1){
                            break;
                        }
                    }
                    if(w2 == len2-1){
                        diff++;
                    }
                    if(diff == 1){
                        int length = Math.max(hashMap.get(a)+1,hashMap.get(b));
                        if(length > maxLength){
                            maxLength = length;
                        }
                        hashMap.put(b,length);
                    }
                }
            }

        }
        

        return maxLength==0?1:maxLength;

    }

    
    public static void main(String[] args){
        String[] words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(new Prob().longestStrChain(words));
    }
    
}
