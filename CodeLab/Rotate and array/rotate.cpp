#include <iostream>
#include <vector>

using namespace std;

void reverse(vector<int>& nums,int begin,int end)
    {
        int temp;
        while(begin<end){
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
vector<int> rotate(vector<int>& nums, int k) {
        if(nums.size()<2)
            return nums;
        k %=nums.size();
        reverse(nums,0,nums.size()-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.size()-1);
        return nums;
    }

int main() {
    int n;
    cin >> n;
    int k;
    cin >> k;
    vector<int> p(n);
    for(int i = 0; i < n; i++)
        cin >> p[i];
    vector<int> result;
    result = rotate(p, k);
    for(int i = 0; i < result.size(); i++){
        if(i == 0)
            cout << "[ ";
        if((i >= 0) && (i < result.size() - 1))
            cout << result[i] << ", ";
        if(i == result.size() - 1)
            cout << result[i] << "]";
    }
    return 0;
}
