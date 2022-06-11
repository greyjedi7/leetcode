public class Prob2 {
    

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){ this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class DataNode {
        int sum;
        int nodeCount=0;
        DataNode(int sum, int nodeCount){
            this.sum = sum;
            this.nodeCount = nodeCount;
        }
    }

    public int avgCount = 0;

    public DataNode depthFirstSearch(TreeNode rootNode){
        if(rootNode == null){
            return new DataNode(0, 0);
        }
        DataNode dataNodeLeft = depthFirstSearch(rootNode.left);
        DataNode dataNodeRight = depthFirstSearch(rootNode.right);
        
        int sum = dataNodeLeft.sum + dataNodeRight.sum + rootNode.val;
        int nodesCount = dataNodeLeft.nodeCount + dataNodeRight.nodeCount + 1;

        if( sum / nodesCount == rootNode.val ){
            avgCount++;
        }

        return new DataNode(sum, nodesCount);
    }

    public int averageOfSubtree(TreeNode root){

        depthFirstSearch(root);
        return avgCount;

    }

    public TreeNode insert(){
        TreeNode child1 = new TreeNode(0);
        TreeNode child2 = new TreeNode(1);
        TreeNode child3 = new TreeNode(6);

        TreeNode subTree1 = new TreeNode(8, child1, child2);
        TreeNode subTree2 = new TreeNode(5, null, child3);
        TreeNode rootNode = new TreeNode(4, subTree1, subTree2);
        return rootNode;
    }


    public static void main(String[] args){
        Prob2 prob2 = new Prob2();
        TreeNode rootNode = prob2.insert();
        System.out.println(prob2.averageOfSubtree(rootNode));
    }

}
