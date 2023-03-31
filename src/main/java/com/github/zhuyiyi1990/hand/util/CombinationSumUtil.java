package com.github.zhuyiyi1990.hand.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
@Component
public class CombinationSumUtil {

    List<long[]> freq = new ArrayList<>();
    List<List<Long>> ans = new ArrayList<>();
    List<Long> sequence = new ArrayList<>();

    public List<List<Long>> combinationSum2(long[] candidates, long target) {
        freq.clear();
        ans.clear();
        sequence.clear();
        Arrays.sort(candidates);
        for (long num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new long[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, long rest) {
        if (rest == 0) {
            ans.add(new ArrayList<Long>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        long most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (long i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (long i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

}