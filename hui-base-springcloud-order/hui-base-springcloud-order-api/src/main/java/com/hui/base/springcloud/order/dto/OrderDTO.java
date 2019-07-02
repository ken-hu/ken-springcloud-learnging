package com.hui.base.springcloud.order.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <b><code>OrderDTO</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/2/25 18:01.
 *
 * @author Hu-Weihui
 * @since hui-base-springcloud ${PROJECT_VERSION}
 */
@Data
public class OrderDTO implements Serializable {

    private String orderId;

    private String orderName;

    private String productId;

    private Integer buyQuantity;
}
