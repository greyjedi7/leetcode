#include<bits/stdc++.h>
using namespace std;


string addStrings(string num1, string num2){
    string num1Reversed = "";
    string num2Reversed = "";
    
    for(int i=num1.length()-1;i>=0;i--) num1Reversed += num1[i];

    for(int i=num2.length()-1;i>=0;i--) num2Reversed += num2[i];

    int num1Length = num1.length();
    int num2Length = num2.length();

    int i=0,j=0;
    int ones = 0, tens = 0;
    int sum = 0;

    string result = "";
    int num1Part = 0, num2Part = 0;
    while(i < num1Length || j < num2Length){
        num1Part = (i < num1Length) ? num1Reversed[i] - '0' : 0;
        num2Part = (j < num2Length) ? num2Reversed[j] - '0' : 0;
        sum = num1Part + num2Part + tens;

        ones = sum % 10;
        tens = sum / 10;

        result += ones + '0';

        i++;    j++;
    }

    if(tens != 0) result += tens + '0';

    reverse(result.begin(),result.end());
    return result;
}

int main(){
    string num1 = "911";
    string num2 = "123";
    cout<<addStrings(num1, num2)<<endl;
    return 0;
}