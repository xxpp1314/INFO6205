#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

bool isUnique(string ans){
    if(ans.size() == 0 || ans.size() == 1)
        return true;
    unordered_map<char, int> data;
    for(int i = 0; i < ans.size(); i++){
        data[ans[i]]++;
    }
    for(int j = 0; j < data.size(); j++){
        if(data[ans[j]] > 1)
            return false;
    }
    return true;
}


int main() {
    string ans;
    getline(cin, ans);
    cout << boolalpha << isUnique(ans) << endl;
    return 0;
}
