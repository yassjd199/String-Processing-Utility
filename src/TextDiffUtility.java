public class TextDiffUtility {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String UNDERLINE = "\033[4m";
    public static final String STRIKETHROUGH = "\033[9m";

    /**
     * Calculate the Longest Common Subsequence (LCS) of two strings.
     *
     * @param a First string
     * @param b Second string
     * @return Longest common subsequence
     */
    public static String longestCommonSubsequence(String a, String b) {
        if (a == null || b == null) return "";

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (a.charAt(i - 1) == b.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        // Sort of a backtracking approach to find the LCS from the DP table
        StringBuilder result = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                result.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        return result.reverse().toString();
    }

    /**
     * Highlight the differences between two strings.
     *
     * @param a First string
     * @param b Second string
     * @return formatted string with highlighted differences
     */
    public static String highlightDifferences(String a, String b) {
        if (a == null || b == null) return "";

        String lcs = longestCommonSubsequence(a, b);
        int i = 0, j = 0, k = 0;
        StringBuilder result = new StringBuilder();

        while (i < a.length() || j < b.length()) {
            if (k < lcs.length() && i < a.length() && j < b.length() && a.charAt(i) == lcs.charAt(k) && b.charAt(j) == lcs.charAt(k)) {
                result.append(a.charAt(i));
                i++;
                j++;
                k++;
            } else {
                while (i < a.length() && (k >= lcs.length() || a.charAt(i) != lcs.charAt(k))) {
                    result.append(RED).append(UNDERLINE).append(a.charAt(i)).append(RESET);
                    i++;
                }
                while (j < b.length() && (k >= lcs.length() || b.charAt(j) != lcs.charAt(k))) {
                    result.append(GREEN).append(STRIKETHROUGH).append(b.charAt(j)).append(RESET);
                    j++;
                }
            }
        }

        return result.toString();
    }
}
