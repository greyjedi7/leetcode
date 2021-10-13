#include<bits/stdc++.h>
using namespace std;

vector<int> twoOutOfThree(vector<int>& num1, vector<int>& num2, vector<int>& num3){
    
    int count[101] = {0};
    bool visited[101] = {0};
    for(int i=0;i<num1.size();i++){
        if(visited[num1[i]] == false){
            count[num1[i]]++;
            visited[num1[i]] = true;
        }
    }
    memset( visited, false, sizeof(visited));
    for(int i=0;i<num2.size();i++){
        if(visited[num2[i]] == false){
            count[num2[i]]++;
            visited[num2[i]] = true;
        }
        
    }
    memset( visited, false, sizeof(visited));
    for(int i=0;i<num3.size();i++){
        if(visited[num3[i]] == false){
            count[num3[i]]++;
            visited[num3[i]] = true;
        }
        
    }

    vector<int> result;

    for(int i=1;i<=100;i++){
        if(count[i] >= 2){
            result.push_back(i);
        }
    }

    return result;

}

void print(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int main(){
    vector<int> num1 {
        1,1,2,3
    };
    vector<int> num2 {
        2,3
    };
    vector<int> num3 {
        3
    };

    vector<int> result = twoOutOfThree(num1, num2, num3);

    print(result);

    return 0;
}