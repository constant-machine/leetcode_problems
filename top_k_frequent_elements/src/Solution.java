import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> elemCount = new HashMap<>();
        Arrays.sort(nums);

        int element = nums[0];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                counter++;
            } else {
                elemCount.put(element, counter);
                element = nums[i];
                counter = 1;
            }
        }
        elemCount.put(element, counter);

        Map.Entry<Integer, Integer>[] counts = elemCount.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(counts, Map.Entry.comparingByValue());
        for (int i = 0; i < k; i++) {
            result[i] = counts[counts.length-1-i].getKey();
        }

        return result;
    }
}
