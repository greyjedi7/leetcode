#include<bits/stdc++.h>
using namespace std;

bool isSubSequence(string s, string p){
    int sIndex = 0;
    int pIndex = 0;

    while(sIndex < s.size() && pIndex < p.size()){
        if(s[sIndex] == '1'){
            sIndex++;
            continue;
        }
        if(s[sIndex] == p[pIndex]){
            sIndex++;
            pIndex++;
        } else{
            sIndex++;
        }
    }

    if(pIndex == p.size()) return true;
    return false;
}

int maximumRemovals(string s, string p, vector<int>& removable){
    int maxRemovals = 0;
    int start = 0;
    int end = removable.size()-1;
    int mid;
    
    string t;
    while(start <= end){
        mid = (start+end)/2;
        
        t = s;
        for(int i=0;i<=mid;i++){
            t[removable[i]] = '1';
        }
        
        if(isSubSequence(t, p)){
            maxRemovals = mid + 1;
            start = mid + 1;
        } 
        else end = mid - 1;
    }
    return maxRemovals;

}

// int maximumRemovals(string s, string p, vector<int>& removable){

//     int maxRemovals = 0;

//     for(int i=0;i<removable.size();i++){
//         s[removable[i]] = '1';
//         if(isSubSequence(s,p)){
//             maxRemovals++;
//         }
//     }

//     return  maxRemovals;
// }

int main(){
    string s = "qlevcvgzfpryiqlwy";
    string p = "qlecfqlw";
    vector<int> removable {
        12,5
    };

    cout<<maximumRemovals(s,p, removable)<<endl;
    return 0;
}