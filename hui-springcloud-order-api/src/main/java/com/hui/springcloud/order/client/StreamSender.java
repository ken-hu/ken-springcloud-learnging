package com.hui.springcloud.order.client;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * <b><code>StreamSender</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/12/2 22:01.
 *
 * @author HuWeihui
 */
public interface StreamSender {

    String OUTPUT = "huiStream";
    String OUTPUT2 = "huiStream2";

    String OUTPUT_OBJ = "huiStreamObj";

    @Output(StreamSender.OUTPUT)
    MessageChannel output();

    @Output(StreamSender.OUTPUT2)
    MessageChannel output2();

    @Output(StreamSender.OUTPUT_OBJ)
    MessageChannel outputObj();
}
