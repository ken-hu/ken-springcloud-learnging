package com.hui.base.springcloud.product.bo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.math.BigDecimal;

/**
 * <b><code>ProductInfo</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2019/3/4 23:37.
 *
 * @author HuWeihui
 */
@Data
@Document(indexName = "",type = "productinfo",shards = 1,replicas = 0, refreshInterval = "-1")
public class ProductInfo {
    @Id
    private String productId;

    @Field
    private String productName;

    @Field
    private Integer productStock;

    @Field
    private BigDecimal productPrice;
}
