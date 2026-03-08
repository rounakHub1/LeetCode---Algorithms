class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> res, StringBuilder sb, int open, int close, int max) {
        // Base case: The string is complete
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }

        // Rule 1: Can we add an opening parenthesis?
        if (open < max) {
            sb.append("(");
            backtrack(res, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1); // Backtrack: remove the last char
        }

        // Rule 2: Can we add a closing parenthesis?
        if (close < open) {
            sb.append(")");
            backtrack(res, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1); // Backtrack: remove the last char
        }
    }
}