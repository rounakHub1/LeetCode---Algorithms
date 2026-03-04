class Solution {
    private static final Map<Character, String> map = new TreeMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    private List<String> comb = new ArrayList<>();
    private int ln;
    private String digits;
    
    private void find(int idx, StringBuilder str) {
        if(idx == ln) {
            comb.add(str.toString());
            return;
        }
        if(idx == 0) {
            str.setLength(0);
        }
        String keys = map.get(digits.charAt(idx));
        int len = keys.length();
        for(int i=0; i < len; i++) {
            str.append(keys.charAt(i));
            find(idx + 1, str);
            str.deleteCharAt(idx);
        } return;
    }
    public List<String> letterCombinations(String digits) {
        
        this.digits = digits;
        this.ln = digits.length();

        StringBuilder str = new StringBuilder();
        find(0, str);
        return comb;
    }
}