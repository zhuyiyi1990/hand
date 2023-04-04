package com.github.zhuyiyi1990.hand.service;

import java.util.List;

public interface HandService {

    List<List<Long>> combinationSum2(long[] candidates, long target);

    List<Long> combinationSum2One(long[] candidates, long target);

}