class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int small=Integer.MAX_VALUE;
        for(int i=0; i < strs.length; i++) {
            small = Math.min(small, strs[i].length());
        }
        StringBuilder prefix = new StringBuilder();
        for(int i=0; i<small; i++) {
            for(int j=0; j < strs.length-1; j++) {
                if(strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }
}