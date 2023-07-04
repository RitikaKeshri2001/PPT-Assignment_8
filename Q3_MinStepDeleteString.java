public class Q3_MinStepDeleteString {
    public static int minDistance(String word1, String word2) {
        // calculate the length of wrods
        int m = word1.length();
        int n = word2.length();

        // create a 2d array to keep all the values
        int[][] dp = new int[m+1][n+1];
        // 1st row and 1st column contains 0 value
        for(int i = 1 ; i < m+1 ;i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return m+n-(2*dp[m][n]);
    }

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }
}
