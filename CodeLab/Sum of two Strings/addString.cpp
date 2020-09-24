#include <string>
#include <iostream>
#include <vector>

using namespace std;

string addString(string &num1, string &num2){
    int i = num1.size() - 1, j = num2.size() - 1, add = 0;
    string res = "";
    while(i >= 0 || j >= 0 || add != 0){
        int x = i >= 0 ? num1[i] - '0' : 0;
        int y = j >= 0 ? num2[j] - '0' : 0;
        int sum = x + y + add;
        res.push_back('0' + sum % 10);
        add = sum / 10;
        i--;
        j--;
    }
    reverse(res.begin(), res.end());
    return res;
}

int main(){
    string num1;
    string num2;
    getline(cin, num1);
    getline(cin, num2);
    vector<string> result;
    cout << "result: " << addString(num1, num2) << endl;
    return 0;
}
