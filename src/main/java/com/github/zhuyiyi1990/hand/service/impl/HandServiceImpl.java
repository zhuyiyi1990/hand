package com.github.zhuyiyi1990.hand.service.impl;

import com.github.zhuyiyi1990.hand.service.HandService;
import com.github.zhuyiyi1990.hand.util.CombinationSumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandServiceImpl implements HandService {

    @Autowired
    private CombinationSumUtil combinationSumUtil;

    @Override
    public List<List<Long>> combinationSum2(long[] candidates, long target) {
        return combinationSumUtil.combinationSum2(candidates, target);
    }

    @Override
    public List<Long> combinationSum2One(long[] candidates, long target) {
        return combinationSumUtil.combinationSum2One(candidates, target);
    }

}