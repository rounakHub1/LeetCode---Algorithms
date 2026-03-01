class Solution {
    public int myAtoi(String s) {
        
        int num=0, sign=0, count=0;
        for(char ch : s.toCharArray()) {
            if(sign==0 && count==0 && ch==' ')
                continue;
            else if(sign==0 && count==0 && ch=='-') {
                sign = -1;
                continue;
            }
            else if(sign==0 && count==0 && ch=='+') {
                sign = 1;
                continue;
            }
            else if(ch>='0' && ch<='9') {
                if (num > (Integer.MAX_VALUE - Character.getNumericValue(ch)) / 10) {
                    return (sign >= 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num*10 + Character.getNumericValue(ch);
                count++;
                continue;
            } else
                break;
        }
        sign = (sign==0) ? 1 : sign;
        num = sign * num;
        return num;
    }
}