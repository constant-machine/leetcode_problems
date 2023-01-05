import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KthLargest {

    private final List<Integer> list = new ArrayList<>();
    private Integer kth;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k - 1;
        if (nums.length != 0) {
            for (int num : nums) {
                list.add(num);
            }
            list.sort(Comparator.reverseOrder());
        }
    }

    public int add(int val) {
        list.add(val);
        if ((kth != null) && (val < kth)) {
            kth = list.get(k);
            return kth;
        } else {
            list.sort(Comparator.reverseOrder());
            kth = list.get(k);
            return kth;
        }
    }
}
