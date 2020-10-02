class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> sta = new Stack<Integer>();
        for(int ast:asteroids){
            collision:{
                while(!sta.isEmpty() && sta.peek()>0 && ast<0){
                    if(sta.peek() + ast == 0){
                        sta.pop();
                        break collision;
                    }else if(sta.peek() + ast > 0){
                        break collision;
                    }else {
                        sta.pop();
                    }
                }
                sta.push(ast);
            }
        }
        int[] res = new int[sta.size()];
        for(int i = sta.size()-1;i >= 0;i--)
            res[i] = sta.pop();
        return res;
    }
}
