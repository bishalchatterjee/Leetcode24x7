class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        // Remove leading and trailing whitespaces
        s = s.trim();
        if (s.length() == 0) return 0;

        // Determine the sign
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        // Recursively process the numeric part
        return recursiveAtoi(s, index, sign, 0);
    }

    private int recursiveAtoi(String s, int index, int sign, int result) {
        // Base case: if we've reached the end of the string or a non-digit character
        if (index == s.length() || !Character.isDigit(s.charAt(index))) {
            return result * sign;
        }

        // Get the digit value of the current character
        int digit = s.charAt(index) - '0';

        // Check for overflow and underflow before multiplying result by 10
        if (result > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Update the result and move to the next character
        result = result * 10 + digit;
        return recursiveAtoi(s, index + 1, sign, result);
    }
}
