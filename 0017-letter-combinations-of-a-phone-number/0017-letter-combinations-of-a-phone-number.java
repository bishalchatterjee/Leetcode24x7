class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Integer, String> digitMap = new HashMap<>();
        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");

        List<String> res = new ArrayList<>();
        
        // Convert string digits to integer
        int equivalentNumber = Integer.parseInt(digits);
        
        backtrackAndUpdate(equivalentNumber, "", digitMap, res);
        return res;
    }

    private void backtrackAndUpdate(int num, String tempString, Map<Integer, String> digitMap, List<String> res) {
        if (num == 0) {
            res.add(new String(tempString));
            return;
        }

        int lastDigit = num % 10;
        String keyLastDigit = digitMap.get(lastDigit);

        for (int i = 0; i < keyLastDigit.length(); i++) {
            backtrackAndUpdate(num / 10, keyLastDigit.charAt(i) + tempString, digitMap, res);
        }
    }
}
