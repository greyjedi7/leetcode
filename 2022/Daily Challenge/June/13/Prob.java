import java.util.ArrayList;
import java.util.List;

public class Prob {

    public int getMin(int i, int j){
        return (i < j) ? i : j; 
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        int[][] minimumSum = new int[m][n];

        for(int i=0;i<n;i++){
            minimumSum[m-1][i] = triangle.get(m-1).get(i);
        }

        for(int i=m-2;i>=0;i--){
            int length = triangle.get(i).size();
            for(int j=0;j<length;j++){
                minimumSum[i][j] = getMin(minimumSum[i+1][j] + triangle.get(i).get(j),minimumSum[i+1][j+1] + triangle.get(i).get(j));
            }
        }

        return minimumSum[0][0];

    }

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(2);
        triangle.add(new ArrayList<>());
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.add(new ArrayList<>());
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.add(new ArrayList<>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);
        System.out.println(new Prob().minimumTotal(triangle));
    }

}
