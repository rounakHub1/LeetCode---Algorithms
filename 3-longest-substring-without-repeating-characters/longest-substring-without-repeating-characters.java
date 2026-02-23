import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String input) {
        int maxln = 0;
        String temp = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String s = String.valueOf(ch);

            if (temp.contains(s)) {
                int firstOccurrence = temp.indexOf(s);
                temp = temp.substring(firstOccurrence + 1);
            }
            
            temp += s;
            maxln = Math.max(maxln, temp.length());
        }
        
        return maxln;
    }
}