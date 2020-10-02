class Solution {
public int calculate(String s) {
    char[] array = s.toCharArray();
    int n = array.length;
    int res = 0;
    int num = 0;
    Stack<Integer> stack = new Stack<>();
    int sign = 1;
    for (int i = 0; i < n; i++) {
        if (array[i] == ' ') {
            continue;
        }
        if (array[i] >= '0' && array[i] <= '9') {
            num = num * 10 + array[i] - '0';
        } else if (array[i] == '+' || array[i] == '-') {
            res = res + sign * num;
            num = 0;
            sign = array[i] == '+' ? 1 : -1;
        } else if (array[i] == '(') {
            stack.push(res);
            stack.push(sign);
            sign = 1;
            res = 0;
        } else if (array[i] == ')') {
            res = res + sign * num;
            int signBefore = stack.pop();
            int resBefore = stack.pop();
            res = resBefore + signBefore * res;
            sign = 1;
            num = 0;
        }
    }
    res = res + sign * num;
    return res;
    }
}
