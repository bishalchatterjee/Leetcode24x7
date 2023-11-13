/*
//Approach 1: Use string digits as it is and apply recursion 
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) {
            return new ArrayList<>();
        }

        Map<Character, String> digitMap = new HashMap<>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        
        recursiveHelper(digits, "", digitMap, res, 0);
        return res;
    }

    private void recursiveHelper(String digits, String tempString, Map<Character, String> digitMap, List<String> res,int index) {
        if(index==digits.length()){
            res.add(new String(tempString));
            return;
        }

        for(char c:digitMap.get(digits.charAt(index)).toCharArray()){
            recursiveHelper(digits, tempString + c, digitMap, res, index+1);
        }
    }
}
*/


//Approach 1: Convert digits to int and perform recursion Logic

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length()==0) {
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
        
        recursiveHelper(equivalentNumber, "", digitMap, res);
        return res;
    }

    private void recursiveHelper(int num, String tempString, Map<Integer, String> digitMap, List<String> res) {
        if (num == 0) {
            res.add(new String(tempString));
            return;
        }

        int lastDigit = num % 10;
        String keyLastDigit = digitMap.get(lastDigit);

        for (int i = 0; i < keyLastDigit.length(); i++) {
            recursiveHelper(num / 10, keyLastDigit.charAt(i) + tempString, digitMap, res);
        }
    }
}
