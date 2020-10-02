class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder simple = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) simple.append(c);
            if (c == '(') ++level;
        }
        return simple.toString();
    }
}
