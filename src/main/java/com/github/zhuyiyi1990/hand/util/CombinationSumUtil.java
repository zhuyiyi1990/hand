package com.github.zhuyiyi1990.hand.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
@Component
public class CombinationSumUtil {

    //返回所有组合
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

    //找到一个组合就返回
    public List<Long> combinationSum2One(long[] candidates, long target) {
        List<long[]> freq = new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        Arrays.sort(candidates);
        for (long num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new long[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        return dfsOne(0, target, freq, ans);
    }

    public List<Long> dfsOne(int pos, long rest, List<long[]> freq, List<Long> ans) {
        if (rest == 0) {
            return new ArrayList<>(ans);
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return null;
        }

        List<Long> tempAns = dfsOne(pos + 1, rest, freq, ans);
        if (tempAns != null) {
            return tempAns;
        }

        long most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (long i = 1; i <= most; ++i) {
            ans.add(freq.get(pos)[0]);
            tempAns = dfsOne(pos + 1, rest - i * freq.get(pos)[0], freq, ans);
            if (tempAns != null) {
                return tempAns;
            }
        }
        for (long i = 1; i <= most; ++i) {
            ans.remove(ans.size() - 1);
        }

        return null;
    }

}