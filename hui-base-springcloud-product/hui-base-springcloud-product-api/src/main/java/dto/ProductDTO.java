package dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b><code>ProductDTO</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/2/25 17:11.
 *
 * @author Hu-Weihui
 * @since hui-base-springcloud ${PROJECT_VERSION}
 */
@Data
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 7735213674335763554L;

    private String productId;

    private String productName;

    private Integer productStock;

    private BigDecimal productPrice;
}
