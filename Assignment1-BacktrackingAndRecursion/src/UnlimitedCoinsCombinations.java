import java.util.ArrayList;
import java.util.List;

public class UnlimitedCoinsCombinations {

    public static List<Integer> res = new ArrayList<>();

    private static void backTracking(int[] coinType, int nums, int count, int begin){
        if (count == nums){
            System.out.println(res);
            return;
        }

        for (int k = begin; k < coinType.length; k++){
            res.add(coinType[k]);
            backTracking(coinType, nums, count + 1, k);
            res.remove(count);
        }
    }

    public static void main(String[] args) {
        int coinType[] = {5, 10, 25};
        backTracking(coinType, 5, 0, 0);
    }
}
