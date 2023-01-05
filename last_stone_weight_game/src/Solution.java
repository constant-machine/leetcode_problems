import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList(stones.length);
        for (int stone : stones) {
            list.add(stone);
        }

        while (true) {
            if (list.size() == 0) return 0;
            if (list.size() == 1) return list.get(0);

            int max = 0;
            int nextToMax = 0;
            for (int i=0; i < list.size(); i++) {
                if (list.get(i) > list.get(max)) {
                    max = i;
                }
            }
            if (max == 0) nextToMax = 1;
            for (int i=0; i < list.size(); i++) {
                if ((list.get(i) > list.get(nextToMax)) && (i != max)) {
                    nextToMax = i;
                }
            }

            if (max != nextToMax) {
                list.set(max, list.get(max) - list.get(nextToMax));
                list.remove(nextToMax);
            } else {
                list.remove(max);
                list.remove(nextToMax);
            }
        }
    }
}
