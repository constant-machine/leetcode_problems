package com.constantine.multiply;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Solution {

    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) return "0";
        String[] lines = multiplyByDigit(num1, num2);

        List<String> linesList = Arrays.asList(lines);
        Collections.reverse(Arrays.asList(lines));
        lines = linesList.toArray(new String[0]);

        int resultLength = lines[0].length();
        int previous = lines[0].length();
        for (int i=1; i < lines.length; i++) {
            resultLength += lines[i].length() - previous + 1;
            previous = lines[i].length();
        }

        StringBuilder result = new StringBuilder();
        int carret = 0;
        for (int i=0; i < resultLength; i++) {
            if (lines.length == 1) {
                result.append(lines[0]);
                break;
            }
            int sum = 0;
            for (int j=0; j < lines.length; j++) {
                int value = 0;
                if ((i-j)>=0 && (i-j)<lines[j].length()) value = Character.getNumericValue(lines[j].charAt(i-j));
                sum += value;
            }

            sum += carret;
            if (i == resultLength-1) {
                if (sum != 0) result.append(reverse(String.valueOf(sum)));
            } else {
                result.append(sum % 10);
                carret = sum / 10;
            }
        }

        return reverse(result);
    }

    private String[] multiplyByDigit(String num1, String num2) {
        String[] lines = new String[num2.length()];

        for (int i=num2.length()-1; i >= 0; i--) {
            int position2 = Character.getNumericValue(num2.charAt(i));
            StringBuilder line = new StringBuilder();
            int carret = 0;
            for (int j=num1.length()-1; j >= 0; j--) {
                int position1 = Character.getNumericValue(num1.charAt(j));

                int intermediateResult = position1 * position2 + carret;
                if (j == 0) {
                    line.append(intermediateResult % 10);
                    if ((intermediateResult/10) != 0) line.append(intermediateResult / 10);
                } else {
                    line.append(intermediateResult % 10);
                    carret = intermediateResult / 10;
                }
            }
            lines[i] = line.toString();
        }
        return lines;
    }

    private String reverse(StringBuilder input) {
        StringBuilder reversed = new StringBuilder();
        for (int i=input.length()-1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    private String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i=input.length()-1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
}
