package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> combinations = new ArrayList<>();
        getCombinations(res, combinations, candidates, target, 0);

        return res;
    }

    void getCombinations(List<List<Integer>> res, List<Integer> combinations, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(List.copyOf(combinations));
            return;
        }

        if (start >= candidates.length) {
            return;
        }
        int candidate = candidates[start];
        if (candidate > target) {
            return;
        }

        combinations.add(candidate);
        getCombinations(res, combinations, candidates, target - candidate, start);
        combinations.remove(combinations.size() - 1);
        getCombinations(res, combinations, candidates, target, start + 1);
    }
}
