public class Prob {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int count=0;

    public void dfs(TreeNode node, int level){

        int leftValue;
        int rightValue;

        if(node.left != null){
            dfs(node.left, level+1);
            leftValue = node.left.val;
        } else {
            leftValue = -1;
        }
        if(node.right != null){
            dfs(node.right, level+1);
            rightValue = node.right.val;
        } else {
            rightValue = -1;
        }

        if((leftValue == 0 && rightValue == -1) || (rightValue == 0 && leftValue == -1)){
            node.val = 2;
            count++;

        }

        if((leftValue == 1 && rightValue == -1) || (rightValue == 1 && leftValue == -1)){
            if(level == 0){
                node.val=2;
                count++;
            }
        }

        if((leftValue == 2 && rightValue == -1) || (rightValue == 2 && leftValue == -1)){
            node.val = 1;
        }

        if((leftValue == 2 && rightValue == 0) || (rightValue == 2 && leftValue == 0)){
            node.val = 2;
            count++;
        }

        if((leftValue == 1 && rightValue == 0) || (rightValue == 1 && leftValue == 0)){
            node.val=2;
            count++;
        }

        if(leftValue == 0 && rightValue == 0){
            node.val = 2;
            count++;
        }
    }


    public int minCameraCover(TreeNode root) {
        dfs(root,0);
        return count==0?1:count;
    }

    public TreeNode initalize(){
        TreeNode child = new TreeNode(0);
        TreeNode subTree1 = new TreeNode(0,null, child);
        TreeNode child2 = new TreeNode(0);
        TreeNode subTree2 = new TreeNode(0,child2,subTree1);
        TreeNode root = new TreeNode(0, null, subTree2);
        return root;
    }

    
    public static void main(String[] args){
        Prob prob = new Prob();

        System.out.println(prob.minCameraCover(prob.initalize()));
    }


}
