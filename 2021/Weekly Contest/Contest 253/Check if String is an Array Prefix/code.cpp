#include<bits/stdc++.h>
using namespace std;


bool isPrefixString(string s, vector<string>& words){

    string concatedString = "";
    for(int i=0;i<words.size();i++){
        if(s == concatedString) return true;
        concatedString += words[i];
    }

    if(s == concatedString) return true;
    return false;

}


int main(){
    string s = "iloveleetcode";
    vector<string> words {
        "i","love","leetcode","apples"
    };

    cout<<isPrefixString(s, words)<<endl;
    return 0;
}