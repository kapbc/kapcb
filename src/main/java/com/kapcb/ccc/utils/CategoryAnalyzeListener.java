package com.kapcb.ccc.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kapcb.ccc.model.initial.CategoryAnalyzeDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: CategoryAnalyzeListener </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CategoryAnalyzeListener <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/7 22:41
 */
@Slf4j
public class CategoryAnalyzeListener extends AnalysisEventListener<CategoryAnalyzeDTO> {

    private List<CategoryAnalyzeDTO> result = new ArrayList<>();

    @Override
    public void invoke(CategoryAnalyzeDTO test, AnalysisContext analysisContext) {
        result.add(test);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("All Category Analyze Finished!");
    }

    public List<CategoryAnalyzeDTO> getResult() {
        return result;
    }
}
