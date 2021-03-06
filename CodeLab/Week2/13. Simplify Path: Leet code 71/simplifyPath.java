class Solution {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length; i++){
            if(!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if(!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if(stack.isEmpty())
            return "/";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < stack.size(); i++)
            res.append("/" + stack.get(i));
        return res.toString();
    }
}
