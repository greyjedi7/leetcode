import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int[] sortArrayByParity(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return nums;
    }

    public static int[] stringToIntArray(String string){
        String[] strArr = string.split(",");
        int[] intArr = new int[strArr.length];

        for(int i=0;i<strArr.length;i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        return intArr;
    }

    public static String intArrToString(int[] arr){
        String[] strArr = new String[arr.length];
        
        for(int i=0;i<arr.length;i++){
            strArr[i] = String.valueOf(arr[i]);
        }
        return String.join(",", strArr);
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

        int[][] actualResultArr = new int[testCases.size()][];
        int idx = 0;
        for(int i=0;i<testCases.size();i++){
            actualResultArr[idx++] = sortArrayByParity(stringToIntArray(testCases.get(i)));
        }

        for(int i=0;i<expectedResults.size();i++){
            String[] expectedAnswers = expectedResults.get(i).split("-");
            boolean flag = false;
            for(String answer: expectedAnswers){
                if(answer.equals(intArrToString(actualResultArr[i]))){
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("Expected Answer should be one of these "+expectedResults.get(i));
                System.out.println("But the answer is "+intArrToString(actualResultArr[i]));
            }
        }


    }

}
