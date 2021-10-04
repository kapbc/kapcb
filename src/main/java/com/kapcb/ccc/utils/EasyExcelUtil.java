package com.kapcb.ccc.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a>Title: EasyExcelUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: EasyExcelUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/2 15:33
 */
@Slf4j
//@UtilityClass
public class EasyExcelUtil {

    public static class ModelExcelReader extends AnalysisEventListener<CategoryAnalyze> {

        private List<CategoryAnalyze> analysisResult = new ArrayList<>();

        @Override
        public void invoke(CategoryAnalyze o, AnalysisContext analysisContext) {
            analysisResult.add(o);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            log.info("[analysed finished]");
        }

        public List<CategoryAnalyze> getAnalysisResult() {
            return this.analysisResult;
        }
    }


    public static void main(String[] args) {
        EasyExcel.read("src/main/resources/doc/product_category.xlsx", CategoryAnalyze.class, new ReadListener<CategoryAnalyze>() {

            private List<CategoryAnalyze> analyzeResult = new ArrayList<>();

            @Override
            public void onException(Exception e, AnalysisContext analysisContext) throws Exception {
                log.error("exception is : {}", e.getMessage());
            }

            @Override
            public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {
            }

            @Override
            public void invoke(CategoryAnalyze categoryAnalyze, AnalysisContext analysisContext) {
                log.info("categoryAnalyze : {}", categoryAnalyze);
                analyzeResult.add(categoryAnalyze);
            }

            @Override
            public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {

            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }

            @Override
            public boolean hasNext(AnalysisContext analysisContext) {
                return false;
            }
        }).sheet(1).doRead();
    }
}
