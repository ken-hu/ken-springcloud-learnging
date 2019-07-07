package com.hui.base.springcloud.product.config;

import com.codingapi.txlcn.common.util.Maps;
import com.codingapi.txlcn.tc.core.transaction.txc.analy.def.PrimaryKeysProvider;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Date: 19-1-25 下午4:29
 *
 * @author ujued
 */
@Component
public class MysqlPrimaryKeysProvider implements PrimaryKeysProvider {

    @Override
    public Map<String, List<String>> provide() {
        return Maps.of("t_product", Collections.singletonList("product_id"),
                "t_order",Collections.singletonList("order_id"));
    }
}
