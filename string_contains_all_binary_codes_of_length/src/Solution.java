import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean hasAllCodes(String s, int k) {
        int numberOfAll = (int) Math.pow(2, k);
        Set<String> subs = new HashSet<>();

        for (int i=k; i <= s.length(); i++) {
            String sub = s.substring(i-k, i);
            if (!subs.contains(sub)) {
                subs.add(sub);
                numberOfAll--;
            }

            if (numberOfAll == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * dumb bad solution
     */
    public boolean hasAllCodesDumb(String s, int k) {
        Long counter = 0L;

        int minLength = Math.min(s.length(), k);
        for (int i = 0; i < minLength; i++) {
            var binaryString = Long.toBinaryString(counter);
            var fixedLengthString = String.format("%" + k + "s", binaryString)
                    .replaceAll(" ", "0");
            if (!s.contains(fixedLengthString)) return false;
            counter++;
        }
        return true;
    }
}
