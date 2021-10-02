package com.kapcb.ccc.utils;

import com.alibaba.excel.context.AnalysisContext;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
@UtilityClass
public class EasyExcelUtil {

    public static class ModelExcelReader extends AnalysisEventListener {

        private List<Object> analysisResult = new ArrayList<>();

        @Override
        public void invoke(Object o, AnalysisContext analysisContext) {
            analysisResult.add(o);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            log.info("[analysed finished]");
        }

        public List<Object> getAnalysisResult() {
            return this.analysisResult;
        }
    }


}
