package com.hui.springcloud.msg.service;

import javax.annotation.Resource;

/**
 * <b><code>MsgService</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/15 22:04.
 *
 * @author Hu Weihui
 */
@Resource
public interface MsgService {

    String testService();


    String testServiceFallBack();
}
