
/**
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
 */


import java.util.HashMap;
import java.util.Map;

public class Prob {


    public int maximumUniqueSubarray(int[] nums) {
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;

        int[] sum = new int[n];

        sum[0] = nums[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1] + nums[i];
        }

        int maxSum = -1;
        int startIndex = 0;
        int endIndex = 0;
        hashMap.put(nums[0],0);
        for(int i=1;i<n;i++){
            if(hashMap.containsKey(nums[i])){
                int resultantSum = (startIndex == endIndex) ? nums[startIndex] : (sum[endIndex] - ((startIndex == 0) ? 0 : sum[startIndex-1]));
                if(maxSum < resultantSum){
                    maxSum = resultantSum;
                }
                int prevIndex = hashMap.get(nums[i]);
                for(int j=startIndex;j<=prevIndex;j++){
                    hashMap.remove(nums[j]);
                }
                startIndex = prevIndex+1;
            }
            hashMap.put(nums[i],i);
            endIndex++;
        }

        int resultantSum = (startIndex == endIndex) ? nums[startIndex] : (sum[endIndex] - ((startIndex == 0) ? 0 : sum[startIndex-1]));;
        if(maxSum < resultantSum){
            return resultantSum;
        }
        return maxSum;
    }
    public static void main(String[] args){
        System.out.println(new Prob().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
    
}
