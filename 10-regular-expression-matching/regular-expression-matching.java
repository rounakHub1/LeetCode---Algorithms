class Solution {

    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(0, 0, s, p);
    }

    private boolean match(int i, int j, String s, String p) {

        if (memo[i][j] != null)
            return memo[i][j];

        if (j == p.length())
            return memo[i][j] = (i == s.length());

        boolean firstMatch =
                (i < s.length() &&
                 (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            memo[i][j] =
                match(i, j + 2, s, p) ||   // use 0 times
                (firstMatch && match(i + 1, j, s, p)); // use 1+ times

            return memo[i][j];
        }

        if (firstMatch)
            return memo[i][j] = match(i + 1, j + 1, s, p);

        return memo[i][j] = false;
    }
}