#include<bits/stdc++.h>
using namespace std;

vector<int> rearrangeArrary(vector<int>& nums){
    sort(nums.begin(),nums.end());
    vector<int> result;
    int start = 0;
    int startEnd = (nums.size()%2==0) ? (nums.size()/2) - 1 : ceil(nums.size()/2);
    int end = startEnd + 1;
    int endEnd = nums.size()-1;
    while(start <= startEnd && end <= endEnd){
        result.push_back(nums[start++]);
        result.push_back(nums[end++]);
    }

    
    if(start <= startEnd){
        result.push_back(nums[start]);
    }

    if(end <= endEnd){
        result.push_back(nums[end]);
    }
    return result;
}

void print(vector<int> input){
    for(int i=0;i<input.size();i++){
        cout<<input[i]<<" ";
    }
    cout<<endl;
}

int main(){
    vector<int> nums {
        1,2,5,9
    };
    print(rearrangeArrary(nums));
    return 0;
}