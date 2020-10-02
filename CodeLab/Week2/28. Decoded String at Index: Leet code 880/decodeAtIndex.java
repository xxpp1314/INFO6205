class Solution {
    public String decodeAtIndex(String S, int K) {
        if (S == null || S.length() == 0) return S;   
        char[] str = S.toCharArray();
        long size = 0;
        int index = -1;
        for (char item : str) {
            index++;
            if (Character.isDigit(item))
                size *= item - '0';
            else size++;
            if (size >= K) break;
        }
        for (int i = index; i >= 0; i--) {
            K %= size;
            if (K == 0 && Character.isLetter(str[i])) return String.valueOf(str[i]);
            if (Character.isDigit(str[i]))
                size /= str[i] - '0';
            else size--;
        }
        return "-1";
    }
}
