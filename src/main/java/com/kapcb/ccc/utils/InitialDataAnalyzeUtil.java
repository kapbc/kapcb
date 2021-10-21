package com.kapcb.ccc.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kapcb.ccc.lisenter.CategoryAnalyzeListener;
import com.kapcb.ccc.lisenter.CountryAnalyzeListener;
import com.kapcb.ccc.model.initial.CategoryAnalyzeDTO;
import com.kapcb.ccc.model.initial.CountryCodeAnalyzeDTO;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a>Title: InitialDataAnalyzeUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: InitialDataAnalyzeUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/9/25 21:27
 */
@Slf4j
@UtilityClass
public class InitialDataAnalyzeUtil {

    public static List<CategoryAnalyzeDTO> analyzeProductCategory() {
        String fileName = FileUtil.getPath() + "doc/product_category.xlsx";

        CategoryAnalyzeListener categoryAnalyzeListener = new CategoryAnalyzeListener();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (Exception e) {
            log.error("exception message is : {}", e.getMessage());
        }
        ExcelReader build = EasyExcelFactory.read(inputStream, CategoryAnalyzeDTO.class, categoryAnalyzeListener).headRowNumber(1).build();
        build.readAll();
        build.finish();
        return categoryAnalyzeListener.getResult();
    }

    public static List<CountryCodeAnalyzeDTO> analyzeCountryCode() {
        String fileName = FileUtil.getPath() + "doc/country_code.xls";

        CountryAnalyzeListener countryAnalyzeListener = new CountryAnalyzeListener();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (Exception e) {
            log.error("exception message is : {}", e.getMessage());
        }
        ExcelReader build = EasyExcelFactory.read(inputStream, CountryCodeAnalyzeDTO.class, countryAnalyzeListener).build();
        build.readAll();
        build.finish();
//        return countryAnalyzeListener.getResult();
        return null;
    }

    public static <M, T extends AnalysisEventListener<M>> T analyzeExcel(@NonNull String docPath, @NonNull Class<? extends M> modelClazz, @NonNull T analyzeListener) {
        String fileName = FileUtil.getPath() + docPath;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            log.error("analyze excel get io stream error, error message is : {}", e.getMessage());
        }

        ExcelReader build = EasyExcelFactory.read(inputStream, modelClazz, analyzeListener).headRowNumber(1).build();
        build.readAll();
        build.finish();
        return analyzeListener;
    }

    public static List<String> analyzeXml(String xmlPath) {
        // 创建SAXReader实例
        SAXReader saxReader = new SAXReader();
        String fileName = FileUtil.getPath() + xmlPath;
        Document document = null;
        try {
            // read()读取指定的XML文档并形成DOM树
            document = saxReader.read(new File(fileName));
        } catch (DocumentException e) {
            log.error("analyze xml document error, error message is : {}", e.getMessage());
        }
        Assert.notNull(document, "document can not be null!");
        Element rootElement = document.getRootElement();
        // elements()获取根节点的子节点
        List<Element> elements = rootElement.elements();
        // 获取xml中的内容
        return elements.parallelStream().map(Element::getText).filter(Objects::nonNull).distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<String> strings = analyzeXml("xml/province.xml");
        System.out.println("strings = " + strings);

//        List<CategoryAnalyzeDTO> categoryAnalyzeDTOS = analyzeProductCategory();

//        CategoryAnalyzeListener analyze = analyze("doc/product_category.xlsx", new CategoryAnalyzeListener());
//        List<CategoryAnalyzeDTO> result = analyze.getResult();

//        CountryAnalyzeListener analyze = analyze("doc/country_code.xls", CountryCodeAnalyzeDTO.class, new CountryAnalyzeListener());

//        CategoryAnalyzeListener analyze1 = analyze("doc/product_category.xlsx", CategoryAnalyzeDTO.class, new CategoryAnalyzeListener());

//        List<CountryCodeAnalyzeDTO> result = analyze.getResult();

//        List<CountryCodeAnalyzeDTO> countryCodeAnalyzeDTOS = analyzeCountryCode();
    }
}
