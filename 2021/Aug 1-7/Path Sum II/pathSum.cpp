#include<bits/stdc++.h>
using namespace std;


struct TreeNode
{
    int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};



void traverseTree(TreeNode* root, vector<vector<int>>& result, vector<int> path, int pathSum, int targetSum){

    if(root == nullptr) return;

    if(root->left == NULL && root->right == NULL){
        pathSum += root->val;
        path.push_back(root->val);
        if(pathSum == targetSum){
            result.push_back(path);
        }
        return;
    }

    path.push_back(root->val);
    pathSum += root->val;

    if(root->left != nullptr){
        traverseTree(root->left, result,  path, pathSum, targetSum);
    }

    if(root->right != nullptr) {
        traverseTree(root->right, result,  path, pathSum, targetSum);
    }

}


vector<vector<int>> pathSum(TreeNode* root, int targetSum){
    
    vector<int> path;
    vector<vector<int>> result;
    traverseTree(root, result,  path, 0, targetSum);

    return result;

}


int main(){

    TreeNode* root = new TreeNode(5);
    TreeNode* l1 = new TreeNode(4);
    TreeNode* r1 = new TreeNode(8);
    root->left = l1;
    root->right = r1;

    TreeNode* l11 = new TreeNode(11);
    l1->left = l11;
    l1->right = NULL;

    TreeNode* l21 = new TreeNode(7);
    TreeNode* l22 = new TreeNode(2);
    l11->left = l21;
    l11->right = l22;

    TreeNode* r11 = new TreeNode(13);
    r1->left = r11;
    TreeNode* r12 = new TreeNode(4);
    r1->right = r12;

    

    TreeNode* r21 = new TreeNode(5);
    TreeNode* r22 = new TreeNode(1);
    r12->left = r21;
    r12->right = r22;

    
    vector<vector<int>> result = pathSum(root, 22);
    

    for(int i=0;i<result.size();i++){
        for(int j=0;j<result[i].size();j++){
            cout<<result[i][j]<<" ";
        }
        cout<<endl;
    }

    return 0;
}