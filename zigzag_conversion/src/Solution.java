public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (s.length() <= numRows) return s;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            char letter = s.charAt(i);
            result.append(letter);
            int j = i;
            while (j < s.length()) {
                int incr1 = (numRows - i - 1) * 2;
                int incr2 = (numRows - 1) * 2;
                int up = j + incr1;
                int down = j + incr2;
                if ((up != down) && (incr1 != 0)) {
                    if (up < s.length()) result.append(s.charAt(up));
                }
                if (down < s.length()) result.append(s.charAt(down));
                j = down;
            }
        }

        return result.toString();
    }
}
