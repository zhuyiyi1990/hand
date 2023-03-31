package com.github.zhuyiyi1990.hand.controller;

import com.github.zhuyiyi1990.hand.common.api.vo.Result;
import com.github.zhuyiyi1990.hand.common.constant.CommonConstant;
import com.github.zhuyiyi1990.hand.service.HandService;
import com.github.zhuyiyi1990.hand.vo.CombinationSumRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hand")
public class HandController {

    @Autowired
    private HandService handService;

    @PostMapping("/combinationSum2")
    public Result<List<List<Long>>> combinationSum2(@RequestBody CombinationSumRequestVo vo) {
        Result<List<List<Long>>> result = new Result<>();
        try {
            List<List<Long>> data = handService.combinationSum2(vo.getCandidates(), vo.getTarget());
            result.setSuccess(true);
            result.setCode(CommonConstant.SC_OK_200);
            result.setResult(data);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result.error500(e.getMessage());
        }
    }

}