class Solution {
    public int myAtoi(String s) {
           s = s.trim(); // eliminate leading and trailing spaces
        int n = s.length();
        int idx = 0;
        
        int start = -1, end = -1;
        char sign = ' ';
        while (idx < n) {
            char ch = s.charAt(idx);
            if (ch == '+' || ch == '-') {
                if (sign == ' ' && start == -1) // 00-42a123 || +-123
                    sign = ch;
                else
                    break;
            } else if (ch >= '0' && ch <= '9') {
                if (start == -1)
                    start = idx;
                end = idx + 1;
            } else {
                break;
            }
            idx++;
        }
        
        if (end == -1) // abc 123
            return 0;
        
        int value;
        try {
            value = Integer.parseInt(s.substring(start, end));
        } catch (NumberFormatException e) {
            return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        return value = sign == '-' ? -value : value;
    }
}