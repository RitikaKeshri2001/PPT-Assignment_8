import java.util.*;
public class Q8_BuddyString {
    public static boolean buddyStrings(String s, String goal) {
        int ns = s.length();
        int ng = goal.length();

        // if length of both string not equal then false
        if (ns != ng) {
            return false;
        }

        // we check if s and goal are equal or not
        if (s.equals(goal)) {
            // if equal we check if it contain duplicate value or not

            // create an integer array to keep the frequency of characters
            int[] farr = new int[26];
            for (char ch : s.toCharArray()) {
                farr[ch - 'a']++;
                // if duplicate value is present then it is true otherwise false
                if (farr[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }

        ArrayList<Integer>ans=new ArrayList<>();
        //int count = 0;
        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                ans.add(i);
                if (ans.size()> 2) {
                    return false;
                }
            }
        }

        return ans.size() == 2 && s.charAt(ans.get(0)) == goal.charAt(ans.get(1)) && s.charAt(ans.get(1)) == goal.charAt(ans.get(0));
    }

    public static void main(String[] args) {
        String s = "ab", goal = "ba";
        System.out.println(buddyStrings(s, goal));
    }
}
