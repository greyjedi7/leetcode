#include<bits/stdc++.h>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target){
    unordered_map<int, int> map;
    vector<int> targetSumIndexList;

    for(int i=0;i<nums.size();i++){
        if(map.find(target-nums[i]) != map.end()){
            targetSumIndexList.push_back(map[target - nums[i]]);
            targetSumIndexList.push_back(i);
        }
        map[nums[i]] = i;
    }
    return targetSumIndexList;
}

int main(){
    vector<int> input {
        2,7,11,15
    };

    return 0;
}