import java.util.*;

public class SolutionDP {

    public int maxProduct(int[] nums) {
        Set<Integer> mults = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            var roll = 1;
            for (int j = i; j < nums.length; j++) {
                roll = roll * nums[j];
                mults.add(roll);
                if (roll == 0) break;
            }
        }

        var multsArr = mults.toArray(new Integer[0]);
        var max = multsArr[0];
        for (Integer mult : multsArr) {
            if (mult > max) max = mult;
        }
        return max;
    }
}
