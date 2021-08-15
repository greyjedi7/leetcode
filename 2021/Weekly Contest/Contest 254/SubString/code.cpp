#include<bits/stdc++.h>
using namespace std;

int numOfString(vector<string>& patterns, string word){
    int count = 0;
    for(auto pattern: patterns){
        if(word.find(pattern) != string::npos){
            count++;
        }
    }
    return count;
}

int main(){
    vector<string> patterns {
        "a","abc","bc","d"
    };
    string word = "abc";
    cout<<numOfString(patterns, word)<<endl;
    return 0;
}