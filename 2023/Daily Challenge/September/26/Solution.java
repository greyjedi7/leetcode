import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author greyjedi7
 */
public class Solution {

    /**
     * This problem utilizes the monotonic stack which is used to sort elements in ascending or descending order
     * 
     * There are three things to note here:
     * 1. Monotonic Stack to maintain the lexicographically smallest string
     * 2. Frequency array to see if the current character has a future element
     * 3. Visited array to see if the current character has already visited
     * @param s string
     * @return unique Character string
     */
    public static String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c: s.toCharArray()){

            if(visited[c-'a']){
                freq[c-'a']--;
                continue;
            }

            while(!stack.empty() && stack.peek() >= c && freq[stack.peek()-'a'] > 0){
                visited[stack.pop()-'a'] = false;
            }
            
            stack.push(c);
            freq[c-'a']--;
            visited[c-'a'] = true;
        }

        String result = "";
        for(Character c: stack){
            result += String.valueOf(c);
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        File file = new File("testcases.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<String> testCases = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine()) != null){
            testCases.add(line);
        }

        bufferedReader.close();

        file = new File("expectedresults.txt");
        bufferedReader = new BufferedReader(new FileReader(file));

        List<String> expectedResults = new ArrayList<>();
        while((line = bufferedReader.readLine()) != null){
            expectedResults.add(line);
        }
        bufferedReader.close();

        List<String> actualResults = new ArrayList<>();
        for(String testCase: testCases){
            actualResults.add(removeDuplicateLetters(testCase));
        }

        for(int i=0;i<actualResults.size();i++){
            if(!actualResults.get(i).equals(expectedResults.get(i))){
                System.out.println("Actual Result: "+ actualResults.get(i)+"\nExpected Result: "+expectedResults.get(i));
            }
        }
    }
}