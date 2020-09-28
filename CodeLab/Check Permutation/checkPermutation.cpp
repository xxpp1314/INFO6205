#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool checkPermutation(string str1, string str2){
    int l1 = str1.size();
    int l2 = str2.size();

    if(l1 != l2)
        return false;
    sort(str1.begin(), str1.end());
    sort(str2.begin(), str2.end());
    for(int i = 0; i < l1; i++){
        if(str1[i] != str2[i])
            return false;
    }
    return true;
}


int main() {
    string str1;
    string str2;
    getline(cin, str1);
    getline(cin, str2);
    bool res = checkPermutation(str1, str2);
    cout << boolalpha << res << endl;
    return 0;
}
