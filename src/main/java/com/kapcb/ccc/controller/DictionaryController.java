package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.result.CommonResult;
import com.kapcb.ccc.model.vo.LocationVO;
import com.kapcb.ccc.service.IDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <a>Title: DictionaryController </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DictionaryController <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/17 20:28
 */
@Slf4j
@RestController
@Api(tags = "字典相关接口")
@RequiredArgsConstructor
@RequestMapping("dictionary")
public class DictionaryController {

    private final IDictionaryService dictionaryService;

    @ApiOperation("同步国际数据到数据库")
    @GetMapping("countryCode")
    public CommonResult<Boolean> analyzeCountryCode() {
        return CommonResult.success(dictionaryService.analyzeCountryCode());
    }
//
//    @GetMapping("province")
//    public String analyzeProvince() {
//        return dictionaryService.analyzeProvince() ? "success" : "fail";
//    }

//    @GetMapping("city")
//    public String analyzeCity() {
//        return dictionaryService.analyzeCity() ? "success" : "fail";
//    }

    @ApiOperation("获取全球所有地址信息")
    @GetMapping("all")
    public List<LocationVO> all() {
        return dictionaryService.getAllLocation();
    }

//    @GetMapping("trim")
//    public void trim() {
//        dictionaryService.trim();
//    }
}
