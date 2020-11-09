import java.util.*;

public class LimitedCoinsCombinations {

    public List<List<Integer>> coinsSum(int[] coins, int target) {
        int size = coins.length;
        List<List<Integer>> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        Arrays.sort(coins);
        Stack<Integer> tmp = new Stack<>();
        backTracking(coins, size, 0, target, tmp, res);
        return res;
    }

    private void backTracking(int[] coins, int size, int begin, int target, Stack<Integer> tmp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < size; i++) {
            if (target - coins[i] < 0) {
                break;
            }
            if (i > begin && coins[i] == coins[i - 1]) {
                continue;
            }
            tmp.add(coins[i]);
            backTracking(coins, size, i + 1, target - coins[i], tmp, res);
            tmp.pop();
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 1, 1, 1, 1, 5, 5, 5, 10, 10, 10, 10, 25, 25};
        int target = 73;
        LimitedCoinsCombinations solution = new LimitedCoinsCombinations();
        List<List<Integer>> res = solution.coinsSum(coins, target);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
        System.out.println("The number of combinations is : " + res.size());
    }
}
