package com.kapcb.ccc.utils;

import com.kapcb.ccc.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <a>Title: PinYinUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PinYinUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/21 22:12
 */
@Slf4j
@UtilityClass
public class PinYinUtil {

    public static String getPinYin(String content) {
        if (StringUtils.isNotBlank(content)) {

            // 输出格式设置
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

            // 输出大小写设置
            // LOWERCASE 小写
            // UPPERCASE 大写
            format.setCaseType(HanyuPinyinCaseType.UPPERCASE);

            // 输出音标设置
            // WITH_TONE_MARK 直接使用音标符(必须设置WITH_U_UNICODE, 否则会抛出异常)
            // WITH_TONE_NUMBER 1 ~ 4 数字表示音标
            // WITHOUT_TONE 没有音标
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

            // 特殊音符设置
            //
//            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

            char[] chars = content.trim().toCharArray();
            StringBuilder result = new StringBuilder();
            try {
                for (int i = 0; i < chars.length; i++) {
                    char aChar = chars[i];
                    // 是否含有中文, 有中文则翻译
                    if (Character.toString(aChar).matches("[\\u4e00-\\u9fa5]")) {
                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(aChar, format);
                        result.append(temp[0]);
                    } else {
                        result.append(aChar);
                    }
                    result.append(StringPool.SPACE.value());
                }
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                log.error("get han yu pin yin error, error message is : {}", badHanyuPinyinOutputFormatCombination.getMessage());
            }
            return result.toString();
        }
        return StringPool.EMPTY_STRING.value();
    }

    public static void main(String[] args) {
        List<String> strings = InitialDataAnalyzeUtil.analyzeXml("xml/province.xml");
        List<String> collect = strings.stream().map(content -> {
            System.out.println("content = " + content);
            String pinYin = getPinYin(content);
            System.out.println("pinYin = " + pinYin);
            return pinYin;
        }).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}
