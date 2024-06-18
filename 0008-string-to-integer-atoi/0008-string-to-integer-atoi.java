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


/*
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // Trim leading and trailing spaces
        s = s.trim();
        
        // Check if the string is empty after trimming
        if (s.length() == 0) return 0;
        
        // Initialize variables
        int sign = 1;
        int index = 0;
        int result = 0;
        int length = s.length();
        
        // Handle optional sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        // Process each digit and stop at first non-digit character
        while (index < length) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') break;
            
            // Handle overflow and underflow
            if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + (c - '0');
            index++;
        }
        
        return result * sign;
    }
}


*/