#include <iostream>
#include <vector>
#include <map>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target){
    map<int, int> data;
    for(int i = 0; i < nums.size();  i++){
        if(data.find(target-nums[i]) != data.end())
            return{data[target - nums[i]], i};
        data[nums[i]] = i;
    }
    return {};
}

int main() {
    int k;
    cin >> k;
    vector<int> result;
    int n;
    cin >> n;
    vector<int> p(n);
    for(int i = 0; i < n; i++){
        cin >> p[i];
    }
    result = twoSum(p, k);
//    for(int i = 0; i < result.size(); i++){
//        cout << result[i]  << " ";
//    }
    cout<< "[" << result[0] << "," << result[1] << "]";
    return 0;
}
