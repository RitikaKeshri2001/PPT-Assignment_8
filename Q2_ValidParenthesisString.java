public class Q2_ValidParenthesisString {
    public static boolean checkValidString(String s) {
        int cmin = 0, cmax = 0; // open parentheses count in range [cmin, cmax]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++; // if `*` become `(` then openCount++
                cmin--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }
            if (cmax < 0) return false; // Currently, don't have enough open parentheses to match close parentheses
            // For example: ())(
            cmin = Math.max(cmin, 0);   // It's invalid if open parentheses count < 0
        }
        return cmin == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
    }

    public static void main(String[] args) {
        String s = "(*)";
        System.out.println(checkValidString(s));
    }
}
