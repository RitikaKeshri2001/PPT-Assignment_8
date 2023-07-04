import java.util.*;
public class Q6_AllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        int slen = s.length(), plen = p.length();
        // if length of s is not equal to length of p no anagram
        if(slen < plen)
            return new ArrayList<>();

        // create a list to add the indexes of anagrams
        List<Integer> li = new ArrayList<>();
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int i=0; i<plen; i++) {
            c2[p.charAt(i) - 'a']++;
            c1[s.charAt(i) - 'a']++;
        }
        if(areEqual(c1, c2))
            li.add(0);

        for(int i=plen; i<slen; i++) {
            c1[s.charAt(i-plen) - 'a']--;
            c1[s.charAt(i) - 'a']++;
            if(areEqual(c1, c2))
                li.add(i-plen+1);
        }

        return li;
    }

    private static boolean areEqual(int[] a, int[] b) {
        for(int i=0; i<26; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> idx = findAnagrams(s, p);
        for(int i: idx) {
            System.out.print(i+" ");
        }
    }
}
