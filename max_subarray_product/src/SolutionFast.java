import java.util.HashSet;
import java.util.Set;

public class SolutionFast {

    public int maxProduct(int[] nums) {

        int max = nums[0];

        int maxTemp = nums[0];
        int minTemp = nums[0];

        int maxPrev = nums[0];
        int minPrev = nums[0];

        for (int i = 1; i < nums.length; i++) {

            maxTemp = Math.max(Math.max(minPrev * nums[i], maxPrev * nums[i]), nums[i]);
            max = Math.max(max, maxTemp);

            minTemp = Math.min(Math.min(maxPrev * nums[i], minPrev * nums[i]), nums[i]);

            minPrev = minTemp;
            maxPrev = maxTemp;
        }

        return max;
    }
}
