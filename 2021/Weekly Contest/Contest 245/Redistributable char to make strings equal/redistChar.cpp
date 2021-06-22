#include<bits/stdc++.h>
using namespace std;

bool makeEqual(vector<string>& words){
    int count[26] = {0};
    for(int i=0;i<words.size();i++){
        for(int j=0;j<words[i].size();j++){
            count[words[i][j]-'a']++;
        }
    }

    for(int i=0;i<26;i++){
        if(count[i]%words.size()!=0)
            return false;
    }

    return true;
}

int main(){
    vector<string> words {
        "abc","aabc","bc"
    };
    cout<<makeEqual(words)<<endl;
    return 0;
}