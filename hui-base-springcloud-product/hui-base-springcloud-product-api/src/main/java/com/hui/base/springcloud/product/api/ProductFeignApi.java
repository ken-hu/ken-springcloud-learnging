package com.hui.base.springcloud.product.api;

import com.hui.base.springcloud.common.response.ResultVO;
import dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <b><code>ProductAPI</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/28 23:20.
 *
 * @author Hu Weihui
 */
@FeignClient(name = "product-server",path = "/product",fallback = ProductFeignApi.ProductFeignApiFallback.class )//如果产生服务降级就返回NULL
public interface ProductFeignApi {

    /**
     * fegin获取商品信息.
     *
     * @param id the id
     * @return the mapper
     * @author HuWeihui
     * @since hui_project v1
     */
    @GetMapping("/product/{id}")
    ResultVO<ProductDTO> get(@PathVariable("id") String id);

    @PutMapping("/products")
    ResultVO add(@RequestBody ProductDTO productDTO);

    @PutMapping("/lcn/tcc/products")
    ResultVO tccAdd(@RequestBody ProductDTO productDTO);

    @PutMapping("/lcn/txc/products")
    ResultVO txcAdd(@RequestBody ProductDTO productDTO);

    @Component
    static class ProductFeignApiFallback implements ProductFeignApi{
        /**
         * fegin获取商品信息.
         *
         * @param id the id
         * @return the mapper
         * @author HuWeihui
         * @since hui_project v1
         */
        @Override
        public ResultVO<ProductDTO> get(String id) {
            return null;
        }

        @Override
        public ResultVO add(ProductDTO productDTO) {
            return null;
        }

        @Override
        public ResultVO tccAdd(ProductDTO productDTO) {
            return null;
        }

        @Override
        public ResultVO txcAdd(ProductDTO productDTO) {
            return null;
        }
    }


}
