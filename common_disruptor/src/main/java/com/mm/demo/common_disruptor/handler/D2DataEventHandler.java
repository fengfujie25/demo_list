package com.mm.demo.common_disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.mm.demo.common_disruptor.entity.Data;

import java.text.MessageFormat;


/**
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class D2DataEventHandler implements EventHandler<Data> {

    @Override
    public void onEvent(Data event, long sequence, boolean endOfBatch) throws Exception {
        long result = event.getValue() + 2;
        System.out.println(MessageFormat.format("consumer 2: {0} + 2 = {1}", event.getValue(), result));
    }
}
