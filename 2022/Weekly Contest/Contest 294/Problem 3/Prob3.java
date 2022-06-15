public class Prob3 {
    
    public void print(int[][] stockPrices){
        int n = stockPrices.length;
        for(int i=0;i<n;i++){
            System.out.println(stockPrices[i][0]+" "+stockPrices[i][1]);
        }
    }

    public void merge(int[][] stockPrices, int start, int middle, int end){
        int n1 = middle - start + 1;
        int n2 = end - middle;

        int[][] arr1 = new int[n1][2];
        int[][] arr2 = new int[n2][2];
        
        for(int i=0;i<n1;i++){
            arr1[i][0] = stockPrices[start + i][0];
            arr1[i][1] = stockPrices[start + i][1];
        }

        for(int i=0;i<n2;i++){
            arr2[i][0] = stockPrices[middle + 1 + i][0];
            arr2[i][1] = stockPrices[middle + 1 + i][1];
        }

        int i=0,j=0;

        int k=start;
        while(i<n1 && j<n2){
            if(arr1[i][0] <= arr2[j][0]){
                stockPrices[k][0] = arr1[i][0];
                stockPrices[k++][1] = arr1[i++][1];
            } else {
                stockPrices[k][0] = arr2[j][0];
                stockPrices[k++][1] = arr2[j++][1];
            }
        }

        while(i<n1){
            stockPrices[k][0] = arr1[i][0];
            stockPrices[k++][1] = arr1[i++][1];
        }

        while(j<n2){
            stockPrices[k][0] = arr2[j][0];
            stockPrices[k++][1] = arr2[j++][1];
        }
    }

    public void mergeSort(int[][] stockPrices, int start, int end){
        if(start < end){
            int middle = start + (end-start)/2;
            mergeSort(stockPrices, start, middle);
            mergeSort(stockPrices, middle+1, end);
            merge(stockPrices, start, middle, end);
        }
    }

    public int minimumLines(int[][] stockPrices) {

        int n = stockPrices.length;
        mergeSort(stockPrices, 0, n-1);

        int lineCount = 1;
        
        for(int i=1;i<n-1;i++){
            int slope1 = (stockPrices[i][1] - stockPrices[i-1][1])*(stockPrices[i+1][0]-stockPrices[i][0]);
            int slope2 = (stockPrices[i+1][1] - stockPrices[i][1])*(stockPrices[i][0]-stockPrices[i-1][0]);
            System.out.println(slope1+" "+slope2);
            if(slope1 != slope2){
                lineCount++;
            }
        }
        return n == 1 ? 0 : lineCount;
    }


    public static void main(String[] args){
        int[][] stockPrices = new int[][]{
            {3,4},{1,2},{7,8},{2,3}
        };
        Prob3 prob3 = new Prob3();
        System.out.println(prob3.minimumLines(stockPrices));
    }

}
