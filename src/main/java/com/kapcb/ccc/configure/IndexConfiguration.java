package com.kapcb.ccc.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * <a>Title: IndexConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 12:00
 */
@Data
@Order(-2)
@Configuration
@ConfigurationProperties(prefix = "kapcb.elasticsearch.index.config", ignoreInvalidFields = true)
@ConditionalOnProperty(value = "kapcb.elasticsearch.index.config.enable", havingValue = "true", matchIfMissing = true)
public class IndexConfiguration {

    @Value("${kapcb.product.index.name:kapcb_product_index}")
    private String productIndexName = "kapcb_product_index";
}
