package com.kapcb.ccc.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kapcb.ccc.model.initial.CategoryAnalyzeDTO;

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
public class CategoryAnalyzeListener extends AnalysisEventListener<CategoryAnalyzeDTO> {

    private List<CategoryAnalyzeDTO> result = new ArrayList<>();

    @Override
    public void invoke(CategoryAnalyzeDTO test, AnalysisContext analysisContext) {
        System.out.println("read result is : " + test);
        result.add(test);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("all data read finished");
    }

    public List<CategoryAnalyzeDTO> getResult() {
        return result;
    }
}
