package com.hui.springcloud.product.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * <b><code>StreamAccept</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/12/2 19:40.
 *
 * @author HuWeihui
 */
public interface StreamAccept {

    String INPUT = "huiStream";
    String INPUT2 = "huiStream2";

    String INPUT_OBJ = "huiStreamObj";


    @Input(StreamAccept.INPUT)
    SubscribableChannel input();


    @Input(StreamAccept.INPUT2)
    SubscribableChannel input2();

    @Input(StreamAccept.INPUT_OBJ)
    SubscribableChannel inputObj();
}
