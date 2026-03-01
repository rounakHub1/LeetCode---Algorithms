class Solution {
    public boolean isPalindrome(int x) {
        
        String str = Integer.toString(x);
        int lim = str.length();
        lim = (lim % 2==0) ? lim/2 : (lim-1)/2;

        for(int i=0; i<lim; i++) {
            if(str.charAt(i) != str.charAt(str.length() -1 -i))
                return false;
            continue;
        }
        return true;
    }
}