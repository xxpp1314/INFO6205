/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    char[] chars;
    int cur = 0;
    public NestedInteger deserialize(String s) {
        chars = s.toCharArray();
        if(chars[0]!='[') return new NestedInteger(Integer.valueOf(s));
        return getNest();
    }
    public NestedInteger getNest(){
        NestedInteger nest = new NestedInteger();
        int num = 0;
        int sign = 1;
        while(cur!=chars.length-1){
            cur ++;
            if(chars[cur]==',') continue;
            if(chars[cur]=='[') nest.add(getNest());
            else if(chars[cur]==']') return nest;
            else if(chars[cur]=='-') sign = -1;
            else{
                num = 10*num + sign * (chars[cur]-'0');
                if(chars[cur+1]==','||chars[cur+1]==']'){ 
                    nest.add(new NestedInteger(num));
                    num = 0;
                    sign = 1;
                }
            }
        }
        return null;
    }
}
