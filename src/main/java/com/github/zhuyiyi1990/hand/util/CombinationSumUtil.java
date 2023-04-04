package com.github.zhuyiyi1990.hand.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
@Component
public class CombinationSumUtil {

    public List<List<Long>> combinationSum2(long[] candidates, long target) {
        List<long[]> freq = new ArrayList<>();
        List<List<Long>> ans = new ArrayList<>();
        List<Long> sequence = new ArrayList<>();
        Arrays.sort(candidates);
        for (long num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new long[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target, freq, ans, sequence);
        return ans;
    }

    public void dfs(int pos, long rest, List<long[]> freq, List<List<Long>> ans, List<Long> sequence) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest, freq, ans, sequence);

        long most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (long i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0], freq, ans, sequence);
        }
        for (long i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

}