class Solution {
    private static final Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }
    
    public boolean isValid(String s) {
        int ln = s.length();
        int len = 0; // Acts as our stack pointer
        char[] stack = new char[ln]; // Your 'check' array
        
        for(int i = 0; i < ln; i++) {
            char c = s.charAt(i);
            // If it's an opening bracket, push to stack
            if(map.containsKey(c)) {
                stack[len++] = c;
            } 
            // If it's a closing bracket
            else {
                // If stack is empty or mismatch, return false
                if(len == 0 || map.get(stack[--len]) != c) {
                    return false;
                }
            }
        }
        // If stack is empty, all brackets were matched correctly
        if(len <= 0) return true;
        else return false;
    }
}