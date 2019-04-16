import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int max = in.nextInt();
            int count = in.nextInt();

            String[] prefixes = new String[count];

            for (int j = 0; j < count; j++) {
                prefixes[j] = in.next();
            }

            System.out.println("Case #" + i + ": " + evaluate(max, prefixes));
        }
    }

    private static long evaluate(int n, String[] prefixes) {
        List<String> validPrefixes = new ArrayList<>(Arrays.asList(prefixes));

        for (String s: prefixes) {
            if (Arrays.stream(prefixes).anyMatch((parent) -> !s.equals(parent) && s.startsWith(parent))) {
                validPrefixes.remove(s);
            }
        }

        long result = (long)Math.pow(2, n);
        for (String s: validPrefixes) {
            result -= Math.pow(2, n - s.length());
        }

        return result;
    }
}
