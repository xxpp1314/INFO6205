class Solution {
    public String decodeString(String s) {
        int len=s.length();
        if(len<=0) return "";
        Stack<String> stack=new Stack<>();
        for(int i=0; i<len; i++){
            char mid=s.charAt(i);
            if(mid==']'){
                StringBuilder fir=new StringBuilder();
                while(!stack.peek().equals("[")){
                    fir.insert(0,stack.pop());
                }
                stack.pop();

                StringBuilder num=new StringBuilder();
                while(!stack.isEmpty()&&(stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9')){
                    num.insert(0,stack.pop());
                }
                int number=Integer.parseInt(num.toString());

                StringBuilder sec=new StringBuilder();
                for(int j=0; j<number; j++){
                    sec.append(fir);
                }
                stack.push(sec.toString());
            }else{
                StringBuilder sb=new StringBuilder();
                sb.insert(0,mid);
                stack.push(sb.toString());
            }
        }
        
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        return res.toString();
    }
}
