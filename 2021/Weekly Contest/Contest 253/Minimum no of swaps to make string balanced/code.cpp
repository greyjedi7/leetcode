#include<bits/stdc++.h>
using namespace std;

int minSwaps(string s){
        int maximum = INT_MIN;
        int sum = 0;


    for(int i=0;i<s.length();i++){
        if(s[i] == '[') sum--;
        else if(s[i] == ']') sum++;

        maximum = max(maximum, sum);
    }
    return (maximum + 1)/2;
}


int main(){
    string s = "]]][[[";

    cout<<minSwaps(s)<<endl;
    return 0;
}