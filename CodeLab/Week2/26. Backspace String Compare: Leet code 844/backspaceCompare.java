class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder Sstr = new StringBuilder();
        StringBuilder Tstr = new StringBuilder();
        int count=0;
        for(int i=S.length()-1;i>=0;i--){
            char t = S.charAt(i);
            if(t=='#'){
                count++;
                continue;
            }
            if(count>0){
                count--;
                continue;
            }else{
                Sstr.append(t);
            }
        }
        count=0;
        for(int i=T.length()-1;i>=0;i--){
            char t = T.charAt(i);
            if(t=='#'){
                count++;
                continue;
            }
            if(count>0){
                count--;
                continue;
            }else{
                Tstr.append(t);
            }
        }
        if(Sstr.toString().equals(Tstr.toString())){
            return true;
        }else
            return false;
    }
}
