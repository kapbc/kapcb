package com.kapcb.ccc.lisenter;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kapcb.ccc.model.initial.CountryCodeAnalyzeDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: CountryAnalyzeListener </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CountryAnalyzeListener <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/17 14:16
 */
@Slf4j
public class CountryAnalyzeListener extends AnalysisEventListener<CountryCodeAnalyzeDTO> {
    
    private List<CountryCodeAnalyzeDTO> result = new ArrayList<>();

    @Override
    public void invoke(CountryCodeAnalyzeDTO countryCodeAnalyzeDTO, AnalysisContext analysisContext) {
        result.add(countryCodeAnalyzeDTO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("All Country Analyze Finished!");
    }

    public List<CountryCodeAnalyzeDTO> getResult() {
        return result;
    }
}
