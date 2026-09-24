import java.util.*;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String X = sc.nextLine();
        String Y = sc.nextLine();

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("LCS Length: " + dp[m][n]);
        System.out.println("LCS: " + lcs.reverse());
    }
}
