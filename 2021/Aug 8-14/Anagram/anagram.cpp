#include<bits/stdc++.h>
using namespace std;

void fillZeros(vector<int>& freq){
    for(int i=0;i<26;i++){
        freq[i] = 0;
    }
}

vector<vector<string>> groupAnagrams(vector<string>& strs){
    map<vector<int>, vector<string>> mapAnagrams;

    vector<int> freq;

    for(int i=0;i<26;i++){
        freq.push_back(0);
    }

    for(int i=0;i<strs.size();i++){
        fillZeros(freq);
        for(int j=0;j<strs[i].length();j++){
            freq[strs[i][j]-'a']++;
        }
        mapAnagrams[freq].push_back(strs[i]);
    }

    vector<vector<string>> result;
    for(auto i:mapAnagrams){
        result.push_back(i.second);
    }
    return result;
    
}

void print(vector<vector<string>> result){
    for(int i=0;i<result.size();i++){
        for(int j=0;j<result[i].size();j++){
            cout<<result[i][j]<<" ";
        }
        cout<<endl;
    }
}

int main(){
    vector<string> input {
        "eat","tea","tan","ate","nat","bat"
    };

    print(groupAnagrams(input));
    return 0;
}