class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int cur = T[i];
            if (cur < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > cur) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
