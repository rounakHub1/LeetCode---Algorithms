class Solution {
    private int countPow(int n) {
        
        int i=0;
        while(Math.pow(2, i) <= n) i++;
        return i;
    }
    private int[] binaryNum(int n) {

        int pow = countPow(n);
        int[] num = new int[pow];

        for(int i=pow-1; i>=0; i--) {

            if(Math.pow(2, i) <= n) {
                n -= Math.pow(2, i);
                num[i] = 1;

            } else num[i] = 0;
        }
        return num;
    }
    public int bitwiseComplement(int n) {

        if(n <= 0) return 1;

        int[] num;
        num = binaryNum(n);
        int compln = 0;

        for(int i=0; i<num.length; i++) {

            int mul = (num[i] == 0) ? 1 : 0;
            compln += Math.pow(2, i) * mul;
        }
        return compln;
    }
}