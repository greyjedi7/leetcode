#include<bits/stdc++.h>
using namespace std;


void print(vector<vector<int>> input){

    

    for(int i=0;i<input.size();i++){
        for(int j=0;j<input[i].size();j++){
            cout<<input[i][j]<<" ";
        }
        cout<<endl;
    }
}

void setZeroes(vector<vector<int>>&  matrix){

    bool row = false;
    bool col = false;

    for(int i=0;i<matrix[0].size();i++){
        if(matrix[0][i] == 0){
            row = true;
            break;
        }
    }

    for(int i=0;i<matrix.size();i++){
        if(matrix[i][0] == 0){
            col = true;
            break;
        }
    }
    for(int i=0;i<matrix.size();i++){
        for(int j=0;j<matrix[i].size();j++){
            if(matrix[i][j] == 0){
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for(int i=1;i<matrix.size();i++){
        if(matrix[i][0] == 0){
            for(int j=0;j<matrix[i].size();j++){
                matrix[i][j] = 0;
            }
        }
    }

    for(int i=1;i<matrix[0].size();i++){
        if(matrix[0][i] == 0){
            for(int j=0;j<matrix.size();j++){
                matrix[j][i] = 0;
            }
        }
    }

    if(row){
        for(int i=0;i<matrix[0].size();i++) matrix[0][i] = 0;
    }

    if(col){
        for(int i=0;i<matrix.size();i++)   matrix[i][0] = 0;
    }

}



int main(){
    
    vector<vector<int>> input {
        {1,2,3,4},
        {5,0,7,8},
        {0,10,11,12},
        {13,14,15,0}
    };

    setZeroes(input);
    
    print(input);

    return 0;
}