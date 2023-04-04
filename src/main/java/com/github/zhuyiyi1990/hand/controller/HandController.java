package com.github.zhuyiyi1990.hand.controller;

import com.github.zhuyiyi1990.hand.common.api.vo.Result;
import com.github.zhuyiyi1990.hand.common.constant.CommonConstant;
import com.github.zhuyiyi1990.hand.service.HandService;
import com.github.zhuyiyi1990.hand.vo.CombinationSumRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hand")
public class HandController {

    @Autowired
    private HandService handService;

    @PostMapping("/combinationSum2")
    @ResponseBody
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

    @PostMapping("/combinationSum2One")
    public ModelAndView combinationSum2One(CombinationSumRequestVo vo) {
        ModelAndView mav = new ModelAndView();
        List<Long> target = handService.combinationSum2One(vo.getCandidates(), vo.getTarget());
        mav.addObject("target", target);
        mav.setViewName("target");
        return mav;
    }

}