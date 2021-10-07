package com.kapcb.ccc.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

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
public class CategoryAnalyzeListener extends AnalysisEventListener<CategoryAnalyze> {

    private List<CategoryAnalyze> result = new ArrayList<>();

    @Override
    public void invoke(CategoryAnalyze test, AnalysisContext analysisContext) {
        System.out.println("read result is : " + test);
        result.add(test);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("all data read finished");
    }

    public List<CategoryAnalyze> getResult() {
        return result;
    }
}
