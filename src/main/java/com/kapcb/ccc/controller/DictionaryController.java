package com.kapcb.ccc.controller;

import com.kapcb.ccc.service.IDictionaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequiredArgsConstructor
@RequestMapping("dictionary")
public class DictionaryController {

    private final IDictionaryService dictionaryService;

//    @GetMapping("countryCode")
//    public String analyzeCountryCode() {
//        return dictionaryService.analyzeCountryCode() ? "success" : "fail";
//    }

//    @GetMapping("province")
//    public String analyzeProvince() {
//        return dictionaryService.analyzeProvince() ? "success" : "fail";
//    }

    @GetMapping("city")
    public String analyzeCity() {
        return dictionaryService.analyzeCity() ? "success" : "fail";
    }

    @GetMapping("test")
    public String test(){
        return dictionaryService.test() ? "success" : "fail";
    }
}
