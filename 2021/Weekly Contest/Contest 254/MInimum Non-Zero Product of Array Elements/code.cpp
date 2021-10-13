#include<bits/stdc++.h>
using namespace std;

int minNonZeroProduct(int p){
    if(p == 1) return 1;
    if(p == 2) return 6;

    int second = pow(pow(2,p) - 2, p);
    int first = pow(2,p) - 1;
    int modulo = pow(10,9)+7;
    
    return (second*first)%modulo;
}

int main(){
    cout<<minNonZeroProduct(3)<<endl;
    return 0;
}