package com.hui.base.springcloud.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.hui.base.springcloud.gateway.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * <b><code>RateFilter</code></b>
 * <p/>
 * Description: 令牌桶限流 DEMO
 * <p/>
 * <b>Creation Time:</b> 2018/12/26 22:40.
 *
 * @author HuWeihui
 */
@Component
public class RateLimiterFilter extends ZuulFilter {

    /**
     * 每秒钟往里面放100个令牌。获取不到令牌的请求将无法访问。
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //需要寻找最高的优先级 还要高 最低-3 我们再减1
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1 ;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //如果没有拿到令牌 抛异常
        if (!RATE_LIMITER.tryAcquire()){
            throw new RateLimitException();
        }
        return null;
    }
}
