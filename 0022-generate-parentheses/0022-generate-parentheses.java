class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrackAndUpdate(res,"",n,0,0);
        return res;
    }
    
     private static void backtrackAndUpdate(List<String> res, String s, int n, int openCount, int closeCount) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        // Add '(' if the count of open parentheses is less than N
        if (openCount < n) {
            backtrackAndUpdate(res, s + '(', n, openCount + 1, closeCount);
        }

        // Add ')' if the count of close parentheses is less than the count of open parentheses
        if (closeCount < openCount) {
            backtrackAndUpdate(res, s + ')', n, openCount, closeCount + 1);
        }
    }
}  