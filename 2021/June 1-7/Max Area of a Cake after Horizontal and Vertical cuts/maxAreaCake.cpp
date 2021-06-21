#include<bits/stdc++.h>
using namespace std;

const int MOD = 1e9+7;

int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
    sort(horizontalCuts.begin(), horizontalCuts.end());
    sort(verticalCuts.begin(), verticalCuts.end());

    long long maxHorizontalPortion = horizontalCuts[0];
    for(int i=1;i<horizontalCuts.size();i++){
        maxHorizontalPortion = max<long long>(maxHorizontalPortion, abs(horizontalCuts[i-1]-horizontalCuts[i]));
    }
    maxHorizontalPortion = max<long long>(maxHorizontalPortion, abs(h-horizontalCuts[horizontalCuts.size()-1]));

    long long maxVerticalPortion = verticalCuts[0];
    for(int i=1;i<verticalCuts.size();i++){
        maxVerticalPortion = max<long long>(maxVerticalPortion, abs(verticalCuts[i-1]-verticalCuts[i]));
    }
    maxVerticalPortion = max<long long>(maxVerticalPortion, abs(w-verticalCuts[verticalCuts.size()-1]));
    
    return (maxHorizontalPortion * maxVerticalPortion) % MOD;
}

int main(){
    int h = 8, w = 5;
    vector<int> horizontalCuts {
        // 1,2,4
        // 3,1
        5,2,6,3
    };
    vector<int> verticalCuts {
        // 1,3
        // 1
        1,4
    };

    cout<<maxArea(h,w,horizontalCuts,verticalCuts)<<endl;
    return 0;
}