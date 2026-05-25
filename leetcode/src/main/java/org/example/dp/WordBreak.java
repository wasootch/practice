package org.example.dp;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] prefix = new boolean[n + 1];
        prefix[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && prefix[i - len] && s.substring(i - len, i).equals(word)) {
                    prefix[i] = true;
                }
            }
        }

        return prefix[n];
    }
}
