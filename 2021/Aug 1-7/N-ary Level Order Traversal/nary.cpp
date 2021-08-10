#include<bits/stdc++.h>
using namespace std;


class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};


int calculateDepth(Node* root,int level){

    if(root == NULL) return 0;

    int maxi = level;
    for(int i=0;i<root->children.size();i++){
        maxi = max(calculateDepth(root->children[i], level+1), maxi);
    }
    return maxi;
}

void traverse(Node* root, int level, vector<vector<int>>& result){
    if(root == NULL) return;
    result[level].push_back(root->val);
    for(int i=0;i<root->children.size();i++){
        traverse(root->children[i], level+1, result);
    }
}

vector<vector<int>> levelOrder(Node* root){
    vector<vector<int>> result;
    vector<int> level;

    int totalLevel = calculateDepth(root, 1);
    for(int i=0;i<totalLevel;i++){
        result.push_back(level);
    }

    traverse(root, 0, result);

    return result;
}



int main(){

    Node* root = new Node(1);
    Node* l11 = new Node(3);
    Node* l12 = new Node(2);
    Node* l13 = new Node(4);
    root->children.push_back(l11);
    root->children.push_back(l12);
    root->children.push_back(l13);
    Node* l21 = new Node(5);
    Node* l22 = new Node(6);
    l11->children.push_back(l21);
    l11->children.push_back(l22);

    vector<vector<int>> result = levelOrder(root);

    for(int i=0;i<result.size();i++){
        for(int j=0;j<result[i].size();j++){
            cout<<result[i][j]<<" ";
        }
        cout<<endl;
    }

    return 0;
}