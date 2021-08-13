#include<bits/stdc++.h>
using namespace std;


void setZeros(vector<vector<int>>&  matrix){
    for(int i=0;i<matrix.size();i++){
        for(int j=0;j<matrix[i].size();j++){
            if(matrix[i][j] == 0){
                matrix[i][0] = -1;
                matrix[0][j] = -1;
            }
        }
    }

    for(int i=1;i<matrix.size();i++){
        if(matrix[i][0] == -1){
            for(int j=0;j<matrix[i].size();j++){
                matrix[i][j] = 0;
            }
        }
    }

    for(int i=0;i<matrix[0].size();i++){
        if(matrix[0][i] == -1){
            for()
        }
    }
}

int main(){
    
    vector<vector<int>> input {
        {0,1,2,0},
        {3,4,5,2},
        {1,3,1,5}
    };

    return 0;
}