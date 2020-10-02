class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(stack.contains(c))
                continue;
            while(!stack.isEmpty() && c < stack.peek() && s.indexOf(stack.peek(), i) != -1){
                stack.pop();
            }
            stack.push(c);
        }
        char[] res = new char[stack.size()];
        for(int i = 0; i < stack.size(); i++)
            res[i] = stack.get(i);
        return new String(res);
    }
}
