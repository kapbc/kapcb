package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.po.DictionaryPO;

/**
 * <a>Title: IDictionaryService </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IDictionaryService <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/17 20:25
 */
public interface IDictionaryService extends IService<DictionaryPO> {

    Boolean analyzeCountryCode();

    Boolean analyzeCity();

}
