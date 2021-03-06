class Solution {
    public int scoreOfParentheses(String S) {
		int score = 0;
		int length = S.length();
		Stack<Character> stack = new Stack<>();	
		for(int i=0; i<length; i++){
			char temp = S.charAt(i);
			if(temp=='(')
				stack.add(temp);
			else{
				if(S.charAt(i-1)=='('){
					score += Math.pow(2, stack.size()-1);
					stack.pop();
				}else{
					stack.pop();
				}
			}		
		}
		return score;
    }
}
